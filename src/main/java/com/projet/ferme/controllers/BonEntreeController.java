package com.projet.ferme.controllers;

import com.projet.ferme.domain.Bon_Entree;
import com.projet.ferme.dto.Bon_EntreeDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.BonEntreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/bonEntree"})
public class BonEntreeController {
    private BonEntreeService bonEntreeService;

    public BonEntreeController(BonEntreeService bonEntreeService) {
        this.bonEntreeService = bonEntreeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Bon_Entree> addBonEntree(@RequestBody Bon_EntreeDto bon_entreeDto) {
        Bon_Entree newBon = bonEntreeService.addBonEntree(bon_entreeDto);
        return new ResponseEntity<>(newBon, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Bon_Entree> updateBonEntree(@RequestBody Bon_EntreeDto bon_entreeDto) {
        Bon_Entree updateBonEntree = bonEntreeService.updateBonEntree(bon_entreeDto);
        return new ResponseEntity<>(updateBonEntree,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bon_EntreeDto>> getAllBonEntrees() {
        List<Bon_EntreeDto> produits = bonEntreeService.getAllBonEntree();
        return new ResponseEntity<>(produits,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Bon_Entree> getBonEntreeById(@PathVariable("id") Long id){
        Bon_Entree produit = bonEntreeService.getBonEntreebyId(id);
        return new ResponseEntity<>(produit,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteBonEntreeById(@PathVariable("id") Long id){
        bonEntreeService.deleteBonEntreeById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
