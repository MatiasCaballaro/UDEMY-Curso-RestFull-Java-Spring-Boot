package com.example.curso.service;

import com.example.curso.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface iProfesorService {

    public List<Profesor> findAll();

    public void save (Profesor profesor);

    public Profesor findProfesor (Profesor Profesor);

    public Profesor checkProfesorLogin (Profesor profesor);

    public void deleteProfesor (Profesor profesor);

    public Profesor updateProfesor (Profesor profesor);

    public Optional<Profesor> findProfesorById (Long profesor_id);

    public void deleteProfesor (Long id);

    public void deleteAllProfesor();

    public Profesor findByID (Long id);

    public Profesor findByIdSQL (Long id);


}
