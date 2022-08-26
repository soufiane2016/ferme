package com.projet.ferme.controllers;

import com.projet.ferme.domain.Fournisseur;
import com.projet.ferme.dto.FournisseurDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.FournisseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/fournisseur"})
public class FournisseurController {
    private FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @PostMapping("/add")
    public ResponseEntity<Fournisseur> addFournisseur(@RequestBody FournisseurDto fournisseurDto) {
        Fournisseur newFournisseur = fournisseurService.addFournisseur(fournisseurDto);
        return new ResponseEntity<>(newFournisseur, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Fournisseur> updateFournisseur(@RequestBody FournisseurDto fournisseurDto) {
        Fournisseur updateFournisseur = fournisseurService.updateFournisseur(fournisseurDto);
        return new ResponseEntity<>(updateFournisseur,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FournisseurDto>> getAllFournisseurs() {
        List<FournisseurDto> fournisseurs = fournisseurService.getAllFournisseur();
        return new ResponseEntity<>(fournisseurs,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable("id") Long id){
        Fournisseur fournisseur = fournisseurService.getFournisseurbyId(id);
        return new ResponseEntity<>(fournisseur,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteFournisseurById(@PathVariable("id") Long id){
        fournisseurService.deleteFournisseurById(id);
        return response(HttpStatus.OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
