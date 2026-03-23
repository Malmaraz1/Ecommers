package com.example.ecommerce.Record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExchangeResponse(
                @JsonProperty("ARSBRL") 
                ModenaDetalle datos
) {}
