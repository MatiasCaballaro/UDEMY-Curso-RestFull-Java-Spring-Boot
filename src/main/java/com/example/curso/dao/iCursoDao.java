package com.example.curso.dao;


import com.example.curso.entity.Curso;
import com.example.curso.entity.Profesor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface iCursoDao extends CrudRepository <Curso, Long> {

    public List<Curso> findByProfesorId(Long id);


}
