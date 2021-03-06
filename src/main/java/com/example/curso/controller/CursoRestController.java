package com.example.curso.controller;

import com.example.curso.entity.Curso;
import com.example.curso.entity.Profesor;
import com.example.curso.service.iCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CursoRestController {

    @Autowired
    private iCursoService cursoService;

    private Map <String, Object> makeMap(String key, Object value){
        Map<String, Object> map = new HashMap<>();
        map.put(key,value);
        return map;
    }


    @GetMapping("/cursos")
    public ResponseEntity<?> listaCursos(){
        List<Curso> listaCursos= cursoService.findAll();
        if(listaCursos != null || listaCursos.size()!=0) {
            return new ResponseEntity<>(listaCursos, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear_curso")
    public ResponseEntity<?> agregarCurso(@RequestBody Curso curso){
        cursoService.save(curso);
        return new ResponseEntity<>(makeMap("Creado", curso.getCurso_id() + " - " + curso.getNombre() + " - " + curso.getProfesorId() ),HttpStatus.CREATED);
    }

    @PostMapping("/cursos_profesor")
    public ResponseEntity<?> verCursosProfesor(@RequestBody Profesor profesor){
        List<Curso> listaCursos = cursoService.getCursosProfesor(profesor.getId());
        if(listaCursos != null || listaCursos.size()!=0) {
            return new ResponseEntity<>(listaCursos, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete_curso/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable(value="id") Long id){
        if(cursoService.findByID(id) != null) {
            cursoService.deleteCurso(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete_all_curso")
    public ResponseEntity<Void> deleteAllCursos(){
        cursoService.deleteAllCurso();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }




}
