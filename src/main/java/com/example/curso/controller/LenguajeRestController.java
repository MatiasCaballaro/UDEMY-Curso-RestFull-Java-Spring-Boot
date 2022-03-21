package com.example.curso.controller;

import com.example.curso.entity.Lenguaje;
import com.example.curso.service.LenguajeService;
import com.example.curso.service.iLenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LenguajeRestController {

    @Autowired
    private LenguajeService lenguajeService;

    @GetMapping("/lenguajes")
    public ResponseEntity<?> listalenguajes (){
        List<Lenguaje> listalenguajes = lenguajeService.findAll();
        if(listalenguajes !=null) {
            if(listalenguajes.size()!=0) {
                return new ResponseEntity<>(listalenguajes, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear_lenguaje")
    public ResponseEntity<?> agregarLenguaje (@RequestBody Lenguaje lenguaje) {
        lenguajeService.savelenguaje(lenguaje);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
