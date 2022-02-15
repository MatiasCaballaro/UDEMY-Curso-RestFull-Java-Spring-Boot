package com.example.curso.dao;


import com.example.curso.entity.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface iCursoDao extends CrudRepository <Curso, Long> {

    public List<Curso> findByProfesorId(Long id);
}
