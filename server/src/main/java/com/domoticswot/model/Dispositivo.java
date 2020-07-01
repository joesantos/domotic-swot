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

    private boolean estaMudo;

    private boolean temStatus;

    @Nullable
    private Double temValor;

    @Nullable
    private Integer temVolume;

    private UUID temId;

    private String temNome;
}
