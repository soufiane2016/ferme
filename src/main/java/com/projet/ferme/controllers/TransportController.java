package com.projet.ferme.controllers;

import com.projet.ferme.domain.Transport;
import com.projet.ferme.dto.TransportDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.TransportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/transport"})
public class TransportController {
    private TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping("/add")
    public ResponseEntity<Transport> addTransport(@RequestBody TransportDto transportDto) {
        Transport newTransport = transportService.addTransport(transportDto);
        return new ResponseEntity<>(newTransport,OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Transport> updateTransport(@RequestBody TransportDto transportDto) {
        Transport updateTransport = transportService.updateTransport(transportDto);
        return new ResponseEntity<>(updateTransport,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TransportDto>> getAllTransports() {
        List<TransportDto> produits = transportService.getAllTransport();
        return new ResponseEntity<>(produits,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Transport> getTransportById(@PathVariable("id") Long id){
        Transport produit = transportService.getTransportbyId(id);
        return new ResponseEntity<>(produit,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteTransportById(@PathVariable("id") Long id){
        transportService.deleteTransportById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
