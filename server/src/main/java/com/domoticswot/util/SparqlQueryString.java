package com.domoticswot.util;

public class SparqlQueryString {
    public static String getPrefixes() {
        return "PREFIX : <http://www.semanticweb.org/joeds/ontologies/2020/3/swotDomoticProject#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX xml: <http://www.w3.org/XML/1998/namespace>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                "PREFIX ssn: <http://www.w3.org/ns/ssn/>\n" +
                "PREFIX sosa: <http://www.w3.org/ns/sosa/>\n";
    }

    public static String getPreAndPostConditionService(String servicePath) {
        return getPrefixes() + "\n SELECT ?hasPreCondition ?hasPostCondition ?affects WHERE{\n" +
                "?s rdf:type :Servico;\n" +
                ":hasPath '" + servicePath + "';\n" +
                ":hasPreCondition ?hasPreCondition;\n" +
                ":hasPostCondition ?hasPostCondition;\n" +
                ":affects ?affects .\n" +
                "}\n";
    }

    public static String getPreAndPostConditionServiceBySensor(String sensorUri) {
        return getPrefixes() + "\n SELECT ?hasPreCondition ?hasPostCondition ?affects WHERE{\n" +
                "?s rdf:type :Servico;\n" +
                ":reactsTo <" + sensorUri + ">;\n" +
                ":hasPreCondition ?hasPreCondition;\n" +
                ":hasPostCondition ?hasPostCondition;\n" +
                ":affects ?affects .\n" +
                "}\n";
    }

    public static String getActuatorByUri(String actuatorUri) {
        return getPrefixes() + "\n SELECT ?isHostedBy ?madeActuation ?forProperty WHERE{\n" +
                "?s rdf:type :LightSwitch;\n" +
                "sosa:isHostedBy ?isHostedBy;\n" +
                "sosa:madeActuation ?madeActuation;\n" +
                "ssn:forProperty ?forProperty .\n" +
                "FILTER (?s = "+actuatorUri+" )  \n" +
                "}\n";
    }

    public static String getActuationByUri(String actuationUri) {
        return getPrefixes() + "\n SELECT ?hasSimpleResult ?actsOnProperty WHERE{\n" +
                "?s rdf:type sosa:Actuation;\n" +
                "sosa:hasSimpleResult ?hasSimpleResult;\n" +
                "sosa:actsOnProperty ?actsOnProperty;\n" +
                " FILTER (?s = <"+actuationUri+"> )  \n" +
                "}\n";
    }

    public static String getFeaturesOfInterest() {
        return getPrefixes() + "SELECT ?uri ?hasProperty ?type WHERE{\n" +
                "  ?uri a ?subClass;\n" +
                "  ssn:hasProperty ?hasProperty ;\n" +
                "  rdf:type ?type .\n" +
                "  ?subClass rdfs:subClassOf sosa:FeatureOfInterest\n" +
                "  FILTER(?type != owl:NamedIndividual)\n" +
                "}";
    }

    public static String getFeaturesOfInterestWithActuators() {
        return getPrefixes() + "SELECT ?uri ?hasProperty ?type ?actedBy WHERE{\n" +
                "  ?uri a ?subClass;\n" +
                "  ssn:hasProperty ?hasProperty ;\n" +
                "  rdf:type ?type .\n" +
                "  ?subClass rdfs:subClassOf  sosa:FeatureOfInterest .\n" +
                "  FILTER(?type != owl:NamedIndividual)\n" +
                "  { SELECT * WHERE{\n" +
                "      ?actedBy a ?subClassOfActuator ;\n" +
                "      ?x ?hasProperty .\n" +
                "      ?subClassOfActuator rdfs:subClassOf sosa:Actuator .\n" +
                "  }}\n" +
                "}";
    }

    public static String getProcedureByUri(String procedureUri) {
        return getPrefixes() + "\n SELECT ?hasSimpleValue WHERE{\n" +
                "?s rdf:type owl:NamedIndividual;\n" +
                ":hasSimpleValue ?hasSimpleValue;\n" +
                " FILTER (?s = <"+procedureUri+"> )  \n" +
                "}\n";
    }


    public static String getServicesPathByClass(String deviceClass) {
        return getPrefixes() + "SELECT ?hasPath WHERE{\n" +
                "?s a owl:NamedIndividual, :Servico;\n" +
                ":affects :" + deviceClass + ";\n" +
                ":hasPath ?hasPath . \n" +
                "}";
    }

    public static String getAcs(){
        return getPrefixes() + "SELECT ?s ?hasTemperature ?hasName ?hasId ?hasLocal WHERE{\n" +
                "?s a owl:NamedIndividual, :ArCondicionado;\n" +
                ":hasTemperature ?hasTemperature;\n" +
                ":hasName ?hasName;\n" +
                ":hasId ?hasId;\n" +
                ":hasLocal ?hasLocal .\n" +
                "}";
    }


    public static String getClasses(){
        return getPrefixes() + "SELECT ?class WHERE{\n" +
                "\t?class a owl:Class;\n" +
                "}";
    }
}
