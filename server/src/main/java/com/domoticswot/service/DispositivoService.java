package com.domoticswot.service;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.hardware.VirtualDevice;
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
public class DispositivoService {
    @Autowired
    ControlGpioExample controlGpioExample;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    VirtualDevice virtualDevice;

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

    public String ligarDispositivo(String id){
        String SERVICE_PATH = "/Dispositivo/ligar";
        try{
            String result = baseDispositivoControle(id, SERVICE_PATH);
            virtualDevice.ligarDispositivo(id);
            return result;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public String desligarDispositivo(String id){
        String SERVICE_PATH = "/Dispositivo/desligar";
        try{
            String result = baseDispositivoControle(id, SERVICE_PATH);
            virtualDevice.ligarDispositivo(id);
            return result;
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public String baseDispositivoControle(String id, String servicePath) {

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getService = QueryFactory.create(SparqlQueryString.getPreAndPostConditionService(servicePath));


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

            System.out.println("After ask -> " + rsAsk);


            if (rsAsk) {
                try {
                    UpdateRequest updateDevice = UpdateFactory.create(SparqlQueryString.getPrefixes() +
                            posCondicao.getString()
                            .replace("#id", id)
                    );

                    try {
                        conn.update(updateDevice);

                        virtualDevice.ligarDispositivo(id);

//                        Map<String, String> deviceMap = parseJsonToObj().getOntologyToGPIOMap();
//                        System.out.println(deviceMap);
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
}