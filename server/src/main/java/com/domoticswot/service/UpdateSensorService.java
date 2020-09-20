package com.domoticswot.service;

import com.domoticswot.hardware.Sensor;
import com.domoticswot.hardware.VirtualDevice;
import com.domoticswot.model.DeviceMap;
import com.domoticswot.model.SensorBasic;
import com.domoticswot.util.SparqlQueryString;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateSensorService {

    @Autowired
    VirtualDevice virtualDevice;

    @Autowired
    ObjectMapper mapper;

    public static void updateSensors() {
        //List<String> sensorsUri;
        List<SensorBasic> sensors = listSensors();
        String SERVICE_PATH = "/Sensor/atualizar";

        sensors.forEach((sensor) -> {
            Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));

            int newValue = Sensor.updateValue();
            System.out.println("Id: " + sensor.getHasId().toString() + " - Anterior: " + sensor.getHasValue().toString() + " - Novo: " + newValue + "\n");

            //Note
            RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
            //Rpi
            //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

            try {
                RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
                Literal preCondicao;
                Literal posCondicao;

                QueryExecution qe = conn.query(getService);
                ResultSet rsService = qe.execSelect();

                do {
                    QuerySolution qs = rsService.next();
                    preCondicao = qs.getLiteral("hasPreCondition");
                    posCondicao = qs.getLiteral("hasPostCondition");
                } while (rsService.hasNext());

                qe.close();

                QueryExecution qeAsk = conn.query(
                        SparqlQueryString.getPrefixes() + preCondicao.getString()
                                .replace("#id", String.valueOf(sensor.getHasId()))
                                .replace("#newValue", String.valueOf(newValue))
                );

                boolean rsAsk = qeAsk.execAsk();

                if (rsAsk) {
                    try {
                        UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                                posCondicao.getString()
                                        .replace("#currentValue", String.valueOf(sensor.getHasValue()))
                                        .replace("#newValue", String.valueOf(newValue))
                                        .replace("#id", String.valueOf(sensor.getHasId()))
                        );

                        try {
                            System.out.println("Atualizando sensor");
                            conn.update(updateDevice);
                            ligarDispositivoAuto(sensor);
                            desligarDispositivoAuto(sensor);

                            //Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();
                            //System.out.println(deviceMap);
                            //Código abaixo só roda em raspberry
/*                            try {
                                controlGpioExample.setStatusTrue(deviceMap.get(id));
                            } catch (Exception e) {
                                System.out.println("Não estou no RPi");
                            }*/

                        } catch (Exception e) {
                            System.out.println("Não foi possível atualizar o estado do dispositivo" + e.getMessage());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    System.out.println("Pré condição não bate");
                }
                conn.end();
                conn.close();
            } catch (Exception e) {
                System.out.println("Não foi possível instanciar conexão");
                e.printStackTrace();
            }
        });
    }

    public DeviceMap parseJsonToObj() {
        try {
            Resource resource = new ClassPathResource("DeviceOntologyMapping.json");
            DeviceMap deviceMap = mapper.readValue(resource.getFile(), DeviceMap.class);
            return deviceMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<SensorBasic> listSensors() {
        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getSensors = QueryFactory.create(SparqlQueryString.getPrefixes() +
                "SELECT ?individual ?hasId ?hasValue ?hasLocal WHERE {\n" +
                "?individual rdf:type owl:NamedIndividual, :SensorDeTemperatura ;\n" +
                ":hasId ?hasId ;\n" +
                ":hasValue ?hasValue\n ;" +
                ":hasLocal ?hasLocal .\n" +
                "\n}"
        );

        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();

            List<SensorBasic> sensors = new ArrayList<>();
            //List<String> sensorUris = new ArrayList<>();

            QueryExecution qe = conn.query(getSensors);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                Literal sensorId = qs.getLiteral("hasId");
                Literal sensorValue = qs.getLiteral("hasValue");
                org.apache.jena.rdf.model.Resource sensorLocal = qs.getResource("hasLocal");
                org.apache.jena.rdf.model.Resource individual = qs.getResource("individual");

                sensors.add(SensorBasic.builder().hasValue(sensorValue.getInt()).hasId(sensorId.getInt()).hasLocal(sensorLocal.getURI()).uri(individual.getURI()).build());

            } while (rsService.hasNext());

            qe.close();
            return sensors;
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void ligarDispositivoAuto(SensorBasic sensor) {

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionServiceBySensor(sensor.getUri()));


        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
            Literal preCondicao;
            Literal posCondicao;

            QueryExecution qe = conn.query(getService);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                preCondicao = qs.getLiteral("hasPreCondition");
                posCondicao = qs.getLiteral("hasPostCondition");
            } while (rsService.hasNext());

            qe.close();

            QueryExecution qeAsk = conn.query(SparqlQueryString.getPrefixes() + preCondicao.getString());
            boolean rsAsk = qeAsk.execAsk();


            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            posCondicao.getString()
                    );

                    try {
                        conn.update(updateDevice);
                        System.out.println("\n Ligando ar condicionado");
                        /*Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();
                        System.out.println(deviceMap);
                        Código abaixo só roda em raspberry
                        try {
                            controlGpioExample.setStatusTrue(deviceMap.get(id));
                        } catch (Exception e) {
                            System.out.println("Não estou no RPi");
                        }*/

                    } catch (Exception e) {
                        System.out.println("Não foi possível atualizar o estado do dispositivo" + e.getMessage());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("pré condição não bate");
            }
            conn.end();
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
        }
    }

    public static void desligarDispositivoAuto(SensorBasic sensor) {
        String SERVICE_PATH = "/Dispositivo/desligar/auto";

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionServiceBySensor(sensor.getUri()));


        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
            Literal preCondicao;
            Literal posCondicao;

            QueryExecution qe = conn.query(getService);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                preCondicao = qs.getLiteral("hasPreCondition");
                posCondicao = qs.getLiteral("hasPostCondition");
            } while (rsService.hasNext());

            qe.close();

            QueryExecution qeAsk = conn.query(SparqlQueryString.getPrefixes() + preCondicao.getString());
            boolean rsAsk = qeAsk.execAsk();


            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            posCondicao.getString()
                    );

                    try {
                        conn.update(updateDevice);
                        System.out.println("\n desligando ar condicionado");
                        /*Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();
                        System.out.println(deviceMap);
                        Código abaixo só roda em raspberry
                        try {
                            controlGpioExample.setStatusTrue(deviceMap.get(id));
                        } catch (Exception e) {
                            System.out.println("Não estou no RPi");
                        }*/

                    } catch (Exception e) {
                        System.out.println("Não foi possível atualizar o estado do dispositivo" + e.getMessage());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("pré condição não bate");
            }
            conn.end();
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
        }
    }
}

