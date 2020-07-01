package com.domoticswot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Builder
@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = DeviceMap.DeviceMapBuilder.class)
public class DeviceMap {

   @JsonPOJOBuilder()
   public static class DeviceMapBuilder{

   }

   @JsonProperty("DeviceMap")
   private Map<String, String> ontologyToGPIOMap;
}

