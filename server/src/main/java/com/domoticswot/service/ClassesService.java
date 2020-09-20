package com.domoticswot.service;

import com.domoticswot.hardware.ControlGpioExample;
import com.domoticswot.hardware.VirtualDevice;
import com.domoticswot.model.AcDTO;
import com.domoticswot.model.OntologyClass;
import com.domoticswot.util.Services;
import com.domoticswot.util.SparqlQueryString;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdfconnection.RDFConnectionFuseki;
import org.apache.jena.rdfconnection.RDFConnectionRemoteBuilder;
import org.apache.jena.update.UpdateFactory;
import org.apache.jena.update.UpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesService {

    @Autowired
    ControlGpioExample controlGpioExample;

    @Autowired
    VirtualDevice virtualDevice;


    public List<OntologyClass> listClasses() {

        //Note
        RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://localhost:3030/test");
        //Rpi
        //RDFConnectionRemoteBuilder builder = RDFConnectionFuseki.create().destination("http://192.168.1.56:3030/test");

        Query getAcs = QueryFactory.create(SparqlQueryString.getClasses());

        try {
            RDFConnectionFuseki conn = (RDFConnectionFuseki) builder.build();

            QueryExecution qe = conn.query(getAcs);
            ResultSet rsService = qe.execSelect();

            List<OntologyClass> classes = new ArrayList<>();

            do {
                QuerySolution qs = rsService.next();
                OntologyClass temp = OntologyClass.builder()
                        .hasUri(qs.getResource("class").getURI())
                        .build();

                classes.add(temp);

            } while (rsService.hasNext());

            qe.close();
            conn.end();
            conn.close();

            return classes;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
