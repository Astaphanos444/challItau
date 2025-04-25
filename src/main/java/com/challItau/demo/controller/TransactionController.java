package com.challItau.demo.controller;

import java.time.OffsetDateTime;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challItau.demo.dto.TransactionRequest;
import com.challItau.demo.model.Transaction;
import com.challItau.demo.service.TransactionService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService serv;

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) 
    {
        if(request.dataHora().isAfter(OffsetDateTime.now()) || request.valor() <= 0)
        {return ResponseEntity.unprocessableEntity().build();}

        serv.addTransaction(new Transaction(request.valor(), request.dataHora()));

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions()
    {
        serv.clearTransaction();
        return ResponseEntity.ok().build();
    }
}
