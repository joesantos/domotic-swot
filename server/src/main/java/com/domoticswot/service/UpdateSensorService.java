package com.domoticswot.service;

import com.domoticswot.hardware.VirtualDevice;
import com.domoticswot.model.Actuation;
import com.domoticswot.model.DeviceMap;
import com.domoticswot.model.FeatureOfInterest;
import com.domoticswot.model.UpdateFeatureOfInterestRequest;
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
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateSensorService {

    @Autowired
    VirtualDevice virtualDevice;

    @Autowired
    ObjectMapper mapper;

    public static void updateSensors() {
        List<FeatureOfInterest> featuresOfInterest = listFeatureOfInterests();

//        sensors.forEach((sensor) -> {
//            Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));
//
//            int newValue = Sensor.updateValue();
//            System.out.println("Id: " + sensor.getHasId().toString() + " - Anterior: " + sensor.getHasValue().toString() + " - Novo: " + newValue + "\n");
//
//            //Note
//            RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
//            //Rpi
//            //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");
//
//            try {
//                RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
//                Literal preCondicao;
//                Literal posCondicao;
//
//                QueryExecution qe = conn.query(getService);
//                ResultSet rsService = qe.execSelect();
//
//                do {
//                    QuerySolution qs = rsService.next();
//                    preCondicao = qs.getLiteral("hasPreCondition");
//                    posCondicao = qs.getLiteral("hasPostCondition");
//                } while (rsService.hasNext());
//
//                qe.close();
//
//                QueryExecution qeAsk = conn.query(
//                        SparqlQueryString.getPrefixes() + preCondicao.getString()
//                                .replace("#id", String.valueOf(sensor.getHasId()))
//                                .replace("#newValue", String.valueOf(newValue))
//                );
//
//                boolean rsAsk = qeAsk.execAsk();
//
//                if (rsAsk) {
//                    try {
//                        UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
//                                posCondicao.getString()
//                                        .replace("#currentValue", String.valueOf(sensor.getHasValue()))
//                                        .replace("#newValue", String.valueOf(newValue))
//                                        .replace("#id", String.valueOf(sensor.getHasId()))
//                        );
//
//                        try {
//                            System.out.println("Atualizando sensor");
//                            conn.update(updateDevice);
//                            ligarDispositivoAuto(sensor);
//                            desligarDispositivoAuto(sensor);
//
//                            //Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();
//                            //System.out.println(deviceMap);
//                            //Código abaixo só roda em raspberry
///*                            try {
//                                controlGpioExample.setStatusTrue(deviceMap.get(id));
//                            } catch (Exception e) {
//                                System.out.println("Não estou no RPi");
//                            }*/
//
//                        } catch (Exception e) {
//                            System.out.println("Não foi possível atualizar o estado do dispositivo" + e.getMessage());
//                        }
//                    } catch (Exception e) {
//                        System.out.println(e.getMessage());
//                    }
//                } else {
//                    System.out.println("Pré condição não bate");
//                }
//                conn.end();
//                conn.close();
//            } catch (Exception e) {
//                System.out.println("Não foi possível instanciar conexão");
//                e.printStackTrace();
//            }
//        });
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

    public static void getActuator(org.apache.jena.rdf.model.Resource hasProperty) {
        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getActuator = QueryFactory.create(SparqlQueryString.getFeaturesOfInterest());

        try(RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build()) {
            List<FeatureOfInterest> featuresOfInterest = new ArrayList<>();

            QueryExecution qe = conn.query(getActuator);
            ResultSet rsService = qe.execSelect();

            do {
//                QuerySolution qs = rsService.next();
//                org.apache.jena.rdf.model.Resource hasProperty = qs.getResource("hasProperty");
//                org.apache.jena.rdf.model.Resource uri = qs.getResource("uri");
//                org.apache.jena.rdf.model.Resource type = qs.getResource("type");
//
//                System.out.println(hasProperty);
//
//                featuresOfInterest.add(FeatureOfInterest.builder().hasProperty(hasProperty.getURI()).hasUri(uri.getURI()).hasType(type.getURI()).build());

            } while (rsService.hasNext());

            qe.close();

//            return featuresOfInterest;
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void testEmbeddedFuseki(){
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3332/ds");
        try(RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build()) {
            File file = ResourceUtils.getFile("classpath:Ontology.ttl");
            conn.put(file.toString());

            try{
                UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.insertDevices());
                conn.update(updateDevice);
            }catch(Exception e){
                System.out.println("Erro no insert");
            }

        }catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static List<FeatureOfInterest> listFeatureOfInterests() {
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3332/ds");

        Query getFeaturesOfInterests = QueryFactory.create(SparqlQueryString.getFeaturesOfInterest());
        Query getActuation = QueryFactory.create(SparqlQueryString.getActuationQuery());

        try(RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build()) {
            List<FeatureOfInterest> featuresOfInterest = new ArrayList<>();
            List<Actuation> actuations = new ArrayList<>();

            QueryExecution qe = conn.query(getFeaturesOfInterests);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                org.apache.jena.rdf.model.Resource hasProperty = qs.getResource("hasProperty");
                org.apache.jena.rdf.model.Resource uri = qs.getResource("uri");
                org.apache.jena.rdf.model.Resource type = qs.getResource("type");

                System.out.println(hasProperty);

                featuresOfInterest.add(FeatureOfInterest.builder().hasProperty(hasProperty.getURI()).hasUri(uri.getURI()).hasType(type.getURI()).build());

            } while (rsService.hasNext());

            qe.close();

            QueryExecution qeActuation = conn.query(getActuation);
            ResultSet rsServiceActuation = qeActuation.execSelect();

            do {
                QuerySolution qs = rsServiceActuation.next();

                org.apache.jena.rdf.model.Resource uri = qs.getResource("uri");
                org.apache.jena.rdf.model.Resource affectedProperty = qs.getResource("affectedProperty");
                org.apache.jena.rdf.model.Literal simpleResult = qs.getLiteral("hasSimpleResult");

                actuations.add(Actuation.builder()
                        .affectedProperty(affectedProperty.getURI())
                        .hasSimpleResult(simpleResult.getString())
                        .uri(uri.getURI())
                        .build());
            } while (rsService.hasNext());

//            Query getProperties = QueryFactory.create();
//            QueryExecution qeProperty = conn.query()

            return featuresOfInterest;
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static

    public static List<FeatureOfInterest> listFeaturesOfInterestWithActuators() {
        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getFeaturesOfInterests = QueryFactory.create(SparqlQueryString.getFeaturesOfInterestWithActuators());

        try(RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build()) {
            List<FeatureOfInterest> featuresOfInterest = new ArrayList<>();

            QueryExecution qe = conn.query(getFeaturesOfInterests);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                org.apache.jena.rdf.model.Resource hasProperty = qs.getResource("hasProperty");
                org.apache.jena.rdf.model.Resource uri = qs.getResource("uri");

//                featuresOfInterest.add(FeatureOfInterest.builder().hasProperty(hasProperty.getURI()).hasUri(uri.getURI()).hasType(type.getURI()).actuatedBy(actuatedBy.getURI()).build());

            } while (rsService.hasNext());

            qe.close();
            return featuresOfInterest;
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static String getActuation(UpdateFeatureOfInterestRequest payload){
        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query actuatorUriQuery = QueryFactory.create(SparqlQueryString.getActuatorByUri(payload.getUri()));
        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
            org.apache.jena.rdf.model.Resource madeActuation;
            org.apache.jena.rdf.model.Resource forProperty;

            QueryExecution qe = conn.query(actuatorUriQuery);
            ResultSet rsActuator = qe.execSelect();

            do {
                QuerySolution qs = rsActuator.next();
                madeActuation = qs.getResource("madeActuation");
                forProperty = qs.getResource("forProperty");

            } while (rsActuator.hasNext());
            qe.close();

                Query actuationQuery = QueryFactory.create(SparqlQueryString.getActuationByUri(madeActuation.getURI()));

            Literal hasSimpleResult;
            org.apache.jena.rdf.model.Resource actsOnProperty;
            QueryExecution qeActuation = conn.query(actuationQuery);
            ResultSet rsActuation = qeActuation.execSelect();

            do{
                QuerySolution qs = rsActuation.next();
                hasSimpleResult = qs.getLiteral("hasSimpleResult");
                actsOnProperty = qs.getResource("actsOnProperty");


            }while(rsActuation.hasNext());
            qeActuation.close();

            System.out.println(forProperty.getURI());


            executeUpdate(hasSimpleResult.getString(), forProperty.getURI(), conn);

            conn.end();
            conn.close();

            return madeActuation.getURI();
        } catch (Exception e) {
            System.out.println("Não foi possível instanciar conexão");
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static void executeUpdate(String hasSimpleValue, String propertyUri, RDFConnectionFuseki conn){
        int value = Integer.parseInt(hasSimpleValue);
        if(value == 0){
            try {
                UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                        "DELETE { ?s :hasLiteral false } INSERT { ?s :hasLiteral true }" +
                        "WHERE { ?s a owl:NamedIndividual FILTER(?s = <"+propertyUri+">)}"
                );

                try {
                    conn.update(updateDevice);
                    System.out.println("\n Atualizando o Valor da property");


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
        }else if(value > 0){
            try {
                UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                        "DELETE { ?s :hasLiteral true } INSERT { ?s :hasLiteral false }" +
                        "WHERE { ?s a owl:NamedIndividual FILTER(?s = <"+propertyUri+">)}"
                );

                try {
                    conn.update(updateDevice);
                    System.out.println("\n Atualizando o Valor da property");


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
        }
    }
}

