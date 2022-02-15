package com.example.curso.controller;

import com.example.curso.mapper.Mapper;
import com.example.curso.model.MProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curso.entity.Profesor;
import com.example.curso.service.iProfesorService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/api")
public class ProfesorRestController {

    @Autowired
    private iProfesorService profesorService;


    @GetMapping("/profesores")
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> getProfesores(){
        return profesorService.findAll();
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor) {
        if(profesorService.findProfesor(profesor)==null) {
            profesorService.save(profesor);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProfesor(@PathVariable (value="id") Long id, @RequestBody Profesor profesor) {

        Profesor profesorDb = null;
        profesorDb = profesorService.findByID(id);
        if(profesorDb != null) {
            profesorDb.setEmail(profesor.getEmail());
            profesorDb.setNombre(profesor.getNombre());
            profesorService.updateProfesor(profesorDb); // actualiza la DB con el objeto profesorDb
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update_sql")
    public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor) {
        Profesor profesorDb = null;
        profesorDb = profesorService.findByIdSQL(profesor.getId());
        if(profesorDb != null) {
            profesorDb.setEmail(profesor.getEmail());
            profesorDb.setNombre(profesor.getNombre());
            profesorService.updateProfesor(profesorDb); // actualiza la DB con el objeto profesorDb
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable(value="id") Long id){
        profesorService.deleteProfesor(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAllProfesor(){
        profesorService.deleteAllProfesor();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /* con Post se puede borrar */
    @PostMapping("/delete_post")
    public ResponseEntity<Void> deleteProfesorPost(@RequestBody Profesor profesor){
        if(profesorService.findProfesor(profesor) != null) {
            profesorService.deleteProfesor(profesor);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping("/find_profesor")
    public ResponseEntity<?> findProfesor(@RequestBody Profesor profesor) {
        Profesor profesorDb = profesorService.findProfesor(profesor);
        if (profesorDb != null) {
            return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor){
        Profesor profesorDb = profesorService.checkProfesorLogin(profesor);
        if(profesorDb != null){
            List<Profesor> profesores = new ArrayList<>();
            profesores.add(profesorDb);
            List<MProfesor> mProfesores = new ArrayList<>();
            mProfesores = Mapper.convertirLista(profesores);
            return new ResponseEntity<>(mProfesores, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

}
