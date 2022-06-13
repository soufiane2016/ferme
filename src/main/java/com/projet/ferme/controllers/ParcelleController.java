package com.projet.ferme.controllers;

import com.projet.ferme.domain.Parcelle;
import com.projet.ferme.dto.ParcelleDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.ParcelleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/parcelle"})
public class ParcelleController {

    private ParcelleService parcelleService;

    public ParcelleController(ParcelleService parcelleService) {
        this.parcelleService = parcelleService;
    }

    @PostMapping("/add")
    public ResponseEntity<Parcelle> addParcelle(@RequestBody ParcelleDto parcelleDto) {
        Parcelle newParcelle = parcelleService.addParcelle(parcelleDto);
        return new ResponseEntity<>(newParcelle, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Parcelle> updateParcelle(@RequestBody ParcelleDto parcelleDto) {
        Parcelle updateParcelle = parcelleService.updateParcelle(parcelleDto);
        return new ResponseEntity<>(updateParcelle,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParcelleDto>> getAllParcelles() {
        List<ParcelleDto> parcelles = parcelleService.getAllParcelle();
        return new ResponseEntity<>(parcelles,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Parcelle> getParcelleById(@PathVariable("id") Long id){
        Parcelle parcelle = parcelleService.getParcellebyId(id);
        return new ResponseEntity<>(parcelle,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteParcelleById(@PathVariable("id") Long id){
        parcelleService.deleteParcelleById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
