package com.domoticswot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = SensorBasic.SensorBasicBuilder.class)
public class SensorBasic {

    @JsonPOJOBuilder()
    public static class SensorBasicBuilder{

    }

    Integer hasValue;

    Integer hasId;

    String hasLocal;

    String uri;
}