package com.projet.ferme.controllers;

import com.projet.ferme.domain.Ferme;
import com.projet.ferme.dto.FermeDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.FermeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping(path = {"/ferme"})
public class FermeController {

    private FermeService fermeService;

    public FermeController(FermeService fermeService) {
        this.fermeService = fermeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Ferme> addFerme(@RequestBody FermeDto fermeDto) {
        Ferme newFerme = fermeService.addFerme(fermeDto);
        return new ResponseEntity<>(newFerme, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ferme> updateFerme(@RequestBody FermeDto fermeDto) {
        Ferme updateFerme = fermeService.updateFerme(fermeDto);
        return new ResponseEntity<>(updateFerme,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FermeDto>> getAllFerms() {
        List<FermeDto> fermes = fermeService.getAllFerme();
        return new ResponseEntity<>(fermes,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Ferme> getFermeById(@PathVariable("id") Long id){
        Ferme ferme = fermeService.getFermebyId(id);
        return new ResponseEntity<>(ferme,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteFermeById(@PathVariable("id") Long id){
        fermeService.deleteFermeById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
