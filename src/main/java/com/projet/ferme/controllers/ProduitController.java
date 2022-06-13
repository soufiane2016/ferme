package com.projet.ferme.controllers;

import com.projet.ferme.domain.Produit;
import com.projet.ferme.dto.ProduitDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.ProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/produit"})
public class ProduitController {
    private ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping("/add")
    public ResponseEntity<Produit> addProduit(@RequestBody ProduitDto produitDto) {
        Produit newProduit = produitService.addProduit(produitDto);
        return new ResponseEntity<>(newProduit, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Produit> updateProduit(@RequestBody ProduitDto produitDto) {
        Produit updateProduit = produitService.updateProduit(produitDto);
        return new ResponseEntity<>(updateProduit,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProduitDto>> getAllProduits() {
        List<ProduitDto> produits = produitService.getAllProduit();
        return new ResponseEntity<>(produits,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable("id") Long id){
        Produit produit = produitService.getProduitbyId(id);
        return new ResponseEntity<>(produit,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteProduitById(@PathVariable("id") Long id){
        produitService.deleteProduitById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
