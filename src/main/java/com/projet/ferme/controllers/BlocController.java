package com.projet.ferme.controllers;

import com.projet.ferme.domain.Bloc;
import com.projet.ferme.dto.BlocDto;
import com.projet.ferme.security.model.HttpResponse;
import com.projet.ferme.services.BlocService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/bloc"})
public class BlocController {
    private BlocService blocService;

    public BlocController(BlocService blocService) {
        this.blocService = blocService;
    }

    @PostMapping("/add")
    public ResponseEntity<Bloc> addBloc(@RequestBody BlocDto blocDto) {
        Bloc newBloc = blocService.addBloc(blocDto);
        return new ResponseEntity<>(newBloc, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Bloc> updateBloc(@RequestBody BlocDto blocDto) {
        Bloc updateFerme = blocService.updateBloc(blocDto);
        return new ResponseEntity<>(updateFerme,HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<BlocDto>> getAllBlocs() {
        List<BlocDto> blocs = blocService.getAllBlocs();
        return new ResponseEntity<>(blocs,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Bloc> getBlocById(@PathVariable("id") Long id){
        Bloc bloc = blocService.getBlocById(id);
        return new ResponseEntity<>(bloc,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpResponse> deleteBlocById(@PathVariable("id") Long id){
        blocService.deleteBlocById(id);
        return response(HttpStatus.OK, "DELETED SUCCESSFULLY" );
    }
    private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
        return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),message), httpStatus);
    }
}
