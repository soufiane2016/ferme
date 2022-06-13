package com.projet.ferme.controllers;

import com.projet.ferme.domain.Serre;
import com.projet.ferme.dto.SerreDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.SerreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
@RestController
@RequestMapping(path = {"/serre"})
public class SerreController {

    private SerreService serreService;

    public SerreController(SerreService serreService) {
        this.serreService = serreService;
    }

    @PostMapping("/add")
    public ResponseEntity<Serre> addSerre(@RequestBody SerreDto serreDto) {
        Serre newSerre = serreService.addSerre(serreDto);
        return new ResponseEntity<>(newSerre, OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Serre> updateSerre(@RequestBody SerreDto serreDto) {
        Serre updateSerre = serreService.updateSerre(serreDto);
        return new ResponseEntity<>(updateSerre,OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SerreDto>> getAllSerres() {
        List<SerreDto> serres = serreService.getAllSerre();
        return new ResponseEntity<>(serres,OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Serre> getSerreById(@PathVariable("id") Long id){
        Serre serre = serreService.getSerrebyId(id);
        return new ResponseEntity<>(serre,OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteSerreById(@PathVariable("id") Long id){
        serreService.deleteSerreById(id);
        return response(OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
