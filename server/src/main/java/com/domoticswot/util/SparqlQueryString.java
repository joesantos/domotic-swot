package com.domoticswot.util;

public class SparqlQueryString {
    public static String getPrefixes() {
        return "PREFIX : <http://www.semanticweb.org/joeds/ontologies/2020/3/swotDomoticProject#>\n" +
                "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n" +
                "PREFIX xml: <http://www.w3.org/XML/1998/namespace>\n" +
                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#>\n" +
                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n";
    }

    //Variável ?o corresponde a preCondicao e ?p a posCondicao
    public static String getPreAndPostConditionService(String servicePath) {
        return getPrefixes() + "\n SELECT ?hasPreCondition ?hasPostCondition  WHERE{\n" +
                "?s rdf:type :Servico;\n" +
                ":hasPath '" + servicePath + "';\n" +
                ":hasPreCondition ?hasPreCondition;\n" +
                ":hasPostCondition ?hasPostCondition.\n" +
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
}
