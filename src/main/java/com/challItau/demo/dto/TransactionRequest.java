package com.challItau.demo.dto;

import java.time.OffsetDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record TransactionRequest(
    @NotNull
    Double valor, 
    
    @NotNull
    OffsetDateTime dataHora) 
{
}
