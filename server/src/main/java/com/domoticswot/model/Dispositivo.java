package com.domoticswot.model;

import lombok.Builder;
import lombok.Value;
import org.apache.jena.ext.xerces.util.URI;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Value
@Builder
public class Dispositivo {

    @Nullable
    private URI uri;

    private boolean isMute;

    private boolean hasStatus;

    @Nullable
    private Double hasValue;

    @Nullable
    private Integer hasVolume;

    private UUID hasId;

    private String hasName;
}
