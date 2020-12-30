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
@JsonDeserialize(builder = FeatureOfInterest.FeatureOfInterestBuilder.class)
public class FeatureOfInterest {

    @JsonPOJOBuilder()
    public static class FeatureOfInterestBuilder {

    }

    String hasProperty;

    String hasUri;

    String hasType;

    String actuatedBy;
}