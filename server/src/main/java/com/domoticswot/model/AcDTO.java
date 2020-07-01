package com.domoticswot.model;

import lombok.Builder;
import lombok.Value;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Resource;

import java.util.List;

@Value
@Builder
public class AcDTO {
    Integer hasTemperature;

    String hasName;

    Integer hasId;

    String hasLocal;

    List<String> services;
}
