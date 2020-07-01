package com.domoticswot.service;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.model.DeviceMap;
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
import java.util.Map;

@Service
public class LampadaService {
    @Autowired
    ControlGpioExample controlGpioExample;

    @Autowired
    private ObjectMapper mapper;

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

    public String acenderLampada(String id) {
        String SERVICE_PATH = "/lampada/acender";

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
//        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));

        Query getDevice = QueryFactory.create(SparqlQueryString.getPrefixes() +
                "SELECT ?s ?o WHERE {\n" +
                "?s rdf:type owl:NamedIndividual ;\n" +
                ":temId '" + id + "';\n" +
                ":temStatus ?o\n" +
                "\n}"
        );


        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
            Literal preCondicao;
            Literal posCondicao;
            org.apache.jena.rdf.model.Resource individual;

            QueryExecution qe = conn.query(getService);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                preCondicao = qs.getLiteral("o");
                posCondicao = qs.getLiteral("p");
            } while (rsService.hasNext());

            qe.close();

            if (preCondicao != null && posCondicao != null) {
                System.out.println("precondition --- " + preCondicao);
                System.out.println("poscondition --- " + posCondicao);
            }

            Literal temStatus;

            QueryExecution qeAsk = conn.query(SparqlQueryString.getPrefixes() + preCondicao.getString());
            boolean rsAsk = qeAsk.execAsk();

            System.out.println("After ask -> " + rsAsk);

            QueryExecution qeDevice = conn.query(getDevice);
            ResultSet rsDevice = qeDevice.execSelect();

            do {
                QuerySolution qs = rsDevice.next();
                temStatus = qs.getLiteral("o");
                individual = qs.getResource("s");

            } while (rsDevice.hasNext());

            qeDevice.close();

            if (temStatus != null) {
                System.out.println("Before --- " + temStatus);
                System.out.println("Individuo --- " + individual);
            }

            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            "DELETE { ?s :temStatus " + temStatus.getBoolean() + " }\n" +
                            "INSERT {\n" +
                            "<" + individual + ">" +
                            "   :temStatus " + posCondicao.getBoolean() + "\n" +
                            "}\n" +
                            "WHERE{\n" +
                            "?s :temId '" + id + "';\n" +
                            "}\n"
                    );

                    try {
                        conn.update(updateDevice);

                        Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();

                        System.out.println(deviceMap);
                        //Código abaixo só roda em raspberry
//                        try {
//                            controlGpioExample.setStatusTrue(deviceMap.get(id));
//                        } catch (Exception e) {
//                            System.out.println("Não estou no RPi");
//                        }
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

    public String apagarLampada(String id) {
        String SERVICE_PATH = "/lampada/apagar";

        //Setar destination dinamicamente dependendo do profile raspberry ou IDE
        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
//        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");


        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(SERVICE_PATH));

        Query getDevice = QueryFactory.create(SparqlQueryString.getPrefixes() +
                "SELECT ?s ?o WHERE {\n" +
                "?s rdf:type owl:NamedIndividual ;\n" +
                ":temId '" + id + "';\n" +
                ":temStatus ?o\n" +
                "\n}"
        );


        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();
            Literal preCondicao;
            Literal posCondicao;
            org.apache.jena.rdf.model.Resource individual;

            QueryExecution qe = conn.query(getService);
            ResultSet rsService = qe.execSelect();

            do {
                QuerySolution qs = rsService.next();
                preCondicao = qs.getLiteral("o");
                posCondicao = qs.getLiteral("p");
            } while (rsService.hasNext());

            qe.close();

            if (preCondicao != null && posCondicao != null) {
                System.out.println("precondition --- " + preCondicao);
                System.out.println("poscondition --- " + posCondicao);
            }

            QueryExecution qeAsk = conn.query(SparqlQueryString.getPrefixes() + preCondicao.getString());
            boolean rsAsk = qeAsk.execAsk();

            System.out.println("After ask -> " + rsAsk);

            Literal temStatus;

            QueryExecution qeDevice = conn.query(getDevice);
            ResultSet rsDevice = qeDevice.execSelect();

            do {
                QuerySolution qs = rsDevice.next();
                temStatus = qs.getLiteral("o");
                individual = qs.getResource("s");

            } while (rsDevice.hasNext());

            qeDevice.close();

            if (temStatus != null) {
                System.out.println("Before --- " + temStatus);
                System.out.println("Individuo --- " + individual);
            }

            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            "DELETE { ?s :temStatus "+temStatus.getBoolean()+" }\n" +
                            "INSERT {\n" +
                            "<" + individual + ">" +
                            "   :temStatus " + posCondicao.getBoolean() + "\n" +
                            "}\n" +
                            "WHERE{\n" +
                            "?s :temId '" + id + "';\n" +
                            "}\n"
                    );

                    try {
                        conn.update(updateDevice);

                        Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();

                        System.out.println(deviceMap);
                        //Código abaixo só roda em raspberry
//                        try {
//                            controlGpioExample.setStatusFalse(deviceMap.get(id));
//                        } catch (Exception e) {
//                            System.out.println("Não estou no RPi");
//                        }
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
}