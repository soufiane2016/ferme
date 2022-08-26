package com.projet.ferme.controllers;


import com.projet.ferme.domain.Ligne_Entree;
import com.projet.ferme.dto.Ligne_EntreeDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.LigneEntreeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = {"/ligneEntree"})
public class LigneEntreeController {

    private LigneEntreeService ligneEntreeService;

    public LigneEntreeController(LigneEntreeService ligneEntreeService) {
        this.ligneEntreeService = ligneEntreeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Ligne_Entree> addLigneEntree(@RequestBody Ligne_EntreeDto ligneEntreeDto) {
        Ligne_Entree newLigneEntree = ligneEntreeService.addLigneEntree(ligneEntreeDto);
        return new ResponseEntity<>(newLigneEntree, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Ligne_Entree> updateLigneEntree(@RequestBody Ligne_EntreeDto ligneEntreeDto) {
        Ligne_Entree updateLigneEntree = ligneEntreeService.updateLigneEntree(ligneEntreeDto);
        return new ResponseEntity<>(updateLigneEntree,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ligne_EntreeDto>> getAllLigneEntrees() {
        List<Ligne_EntreeDto> ligneEntrees = ligneEntreeService.getAllLigneEntree();
        return new ResponseEntity<>(ligneEntrees,OK);
    }

    @GetMapping("/allBon/{idBon}")
    public ResponseEntity<List<Ligne_EntreeDto>> getAllLigneEntreesWithBonEntree(@PathVariable("idBon") Long idBon) {
        List<Ligne_EntreeDto> ligneEntreesDtos = ligneEntreeService.getAllLigneEntreeBonEntree(idBon);
        return new ResponseEntity<>(ligneEntreesDtos,OK);
    }

    /*@GetMapping("/find/{id}")
    public ResponseEntity<Ligne_Entree> getLigneEntreeById(@PathVariable("id") Long id){
        Ligne_Entree ligneEntree = ligneEntreeService.getLigneEntreebyId(id);
        return new ResponseEntity<>(ligneEntree,OK);
    }*/

    @GetMapping("/find/{id}")
    public ResponseEntity<Ligne_EntreeDto> getLigneEntreeById(@PathVariable("id") Long id){
        Ligne_EntreeDto ligneEntreeDto = ligneEntreeService.getLigneEntreebyId(id);
        return new ResponseEntity<>(ligneEntreeDto,OK);
    }

    /*@GetMapping("/findBon/{id}")
    public ResponseEntity<List<Ligne_Entree>> getAllByBonEntree(@PathVariable("id") Long id){
        List<Ligne_Entree> ligneEntrees = ligneEntreeService.getLigneEntreeByBonId(id);
        return new ResponseEntity<>(ligneEntrees,OK);
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteLigneEntreeById(@PathVariable("id") Long id){
        ligneEntreeService.deleteLigneEntreeById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
