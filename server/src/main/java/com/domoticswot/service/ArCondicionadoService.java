package com.domoticswot.service;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.hardware.VirtualDevice;
import com.domoticswot.model.AcDTO;
import com.domoticswot.model.DeviceMap;
import com.domoticswot.util.Services;
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
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArCondicionadoService {

    @Autowired
    ControlGpioExample controlGpioExample;

    @Autowired
    VirtualDevice virtualDevice;

    @Autowired
    private ObjectMapper mapper;

    public String aumentarTemperatura(String id) {
        String SERVICE_PATH = "/ArCondicionado/aumentar-temperatura";

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));

        Query getDevice = QueryFactory.create(SparqlQueryString.getPrefixes() +
                "SELECT ?hasTemperature WHERE {\n" +
                "?s rdf:type owl:NamedIndividual ;\n" +
                ":hasId '" + id + "';\n" +
                ":hasTemperature ?hasTemperature\n" +
                "\n}"
        );


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

            Literal hasTemperature;

            QueryExecution qeAsk = conn.query(SparqlQueryString.getPrefixes() + preCondicao.getString().replace("#id", id));
            boolean rsAsk = qeAsk.execAsk();

            QueryExecution qeDevice = conn.query(getDevice);
            ResultSet rsDevice = qeDevice.execSelect();

            do {
                QuerySolution qs = rsDevice.next();
                hasTemperature = qs.getLiteral("hasTemperature");

            } while (rsDevice.hasNext());

            qeDevice.close();

            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            posCondicao.getString()
                                    .replace("#currentTemperature", hasTemperature.getString())
                                    .replace("#newTemperature", String.valueOf(hasTemperature.getInt() + 1))
                                    .replace("#id", id)
                    );

                    try {
                        conn.update(updateDevice);

                        virtualDevice.aumentarTemperaturaAc(hasTemperature.getInt() + 1);
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
                return "pré condição não bate";
            }
            conn.end();
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
        }

        return "ok";
    }

    public String reduzirTemperatura(String id) {
        String SERVICE_PATH = "/ArCondicionado/reduzir-temperatura";

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));

        Query getDevice = QueryFactory.create(SparqlQueryString.getPrefixes() +
                "SELECT ?hasTemperature WHERE {\n" +
                "?s rdf:type owl:NamedIndividual ;\n" +
                ":hasId '" + id + "';\n" +
                ":hasTemperature ?hasTemperature\n" +
                "\n}"
        );


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

            Literal hasTemperature;

            QueryExecution qeAsk = conn.query(SparqlQueryString.getPrefixes() + preCondicao.getString().replace("#id", id));
            boolean rsAsk = qeAsk.execAsk();

            QueryExecution qeDevice = conn.query(getDevice);
            ResultSet rsDevice = qeDevice.execSelect();

            do {
                QuerySolution qs = rsDevice.next();
                hasTemperature = qs.getLiteral("hasTemperature");

            } while (rsDevice.hasNext());

            qeDevice.close();

            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            posCondicao.getString()
                                    .replace("#currentTemperature", hasTemperature.getString())
                                    .replace("#newTemperature", String.valueOf(hasTemperature.getInt() - 1))
                                    .replace("#id", id)
                    );

                    try {
                        conn.update(updateDevice);

                        virtualDevice.reduzirTemperaturaAc(hasTemperature.getInt() - 1);
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
                return "pré condição não bate";
            }
            conn.end();
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
        }

        return "ok";
    }

    public String definirTemperatura(String id, Integer temperatura) {
        String SERVICE_PATH = "/ArCondicionado/definir-temperatura";

        if(temperatura > 29 || temperatura < 16) return "Temperatura informada inválida";

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));

        Query getDevice = QueryFactory.create(SparqlQueryString.getPrefixes() +
                "SELECT ?hasTemperature WHERE {\n" +
                "?s rdf:type owl:NamedIndividual ;\n" +
                ":hasId '" + id + "';\n" +
                ":hasTemperature ?hasTemperature\n" +
                "\n}"
        );


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

            Literal hasTemperature;


            QueryExecution qeAsk = conn.query(
                    SparqlQueryString.getPrefixes() + preCondicao.getString()
                            .replace("#id", id)
                            .replace("#givenTemperature", temperatura.toString())
            );

            boolean rsAsk = qeAsk.execAsk();

            QueryExecution qeDevice = conn.query(getDevice);
            ResultSet rsDevice = qeDevice.execSelect();

            do {
                QuerySolution qs = rsDevice.next();
                hasTemperature = qs.getLiteral("hasTemperature");

            } while (rsDevice.hasNext());

            qeDevice.close();

            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            posCondicao.getString()
                                    .replace("#currentTemperature", hasTemperature.getString())
                                    .replace("#newTemperature", String.valueOf(hasTemperature.getInt() - 1))
                                    .replace("#id", id)
                    );

                    try {
                        conn.update(updateDevice);

                        virtualDevice.reduzirTemperaturaAc(hasTemperature.getInt() - 1);
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
                return "pré condição não bate";
            }
            conn.end();
            conn.close();
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
        }

        return "ok";
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

    public List<AcDTO> listAcs() {
        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getAcs = QueryFactory.create(SparqlQueryString.getAcs());

        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();

            QueryExecution qe = conn.query(getAcs);
            ResultSet rsService = qe.execSelect();

            List<AcDTO> acs = new ArrayList<>();

            do {
                QuerySolution qs = rsService.next();
                AcDTO temp = AcDTO.builder()
                        .hasId(qs.getLiteral("hasId").getInt())
                        .hasLocal(qs.getResource("hasLocal").getURI())
                        .hasName(qs.getLiteral("hasName").getString())
                        .hasTemperature(qs.getLiteral("hasTemperature").getInt())
                        .services(Services.getServicesPath("ArCondicionado"))
                        .build();

                acs.add(temp);

            } while (rsService.hasNext());

            qe.close();
            conn.end();
            conn.close();

            return acs;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
