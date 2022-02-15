package com.example.curso.service;

import com.example.curso.entity.Curso;

import java.util.List;

public interface iCursoService {

    public List<Curso> findAll();

    public void save(Curso curso);

    public List<Curso> getCursosProfesor(Long id);

}
