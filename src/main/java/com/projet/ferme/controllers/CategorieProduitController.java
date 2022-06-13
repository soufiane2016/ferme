package com.projet.ferme.controllers;

import com.projet.ferme.domain.Categorie_Produit;
import com.projet.ferme.dto.Categorie_ProduitDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.CategorieProduitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/categorie"})
public class CategorieProduitController {
    private CategorieProduitService categorieProduitService;

    public CategorieProduitController(CategorieProduitService categorieProduitService) {
        this.categorieProduitService = categorieProduitService;
    }

    @PostMapping("/add")
    public ResponseEntity<Categorie_Produit> addProduit(@RequestBody Categorie_ProduitDto categorieProduitDto) {
        Categorie_Produit newProduit = categorieProduitService.addProduit(categorieProduitDto);
        return new ResponseEntity<>(newProduit, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Categorie_Produit> updateProduit(@RequestBody Categorie_ProduitDto categorieProduitDto) {
        Categorie_Produit updateProduit = categorieProduitService.updateProduit(categorieProduitDto);
        return new ResponseEntity<>(updateProduit,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Categorie_ProduitDto>> getAllProduits() {
        List<Categorie_ProduitDto> produits = categorieProduitService.getAllProduit();
        return new ResponseEntity<>(produits,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Categorie_Produit> getProduitById(@PathVariable("id") Long id){
        Categorie_Produit produit = categorieProduitService.getProduitbyId(id);
        return new ResponseEntity<>(produit,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteProduitById(@PathVariable("id") Long id){
        categorieProduitService.deleteProduitById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
