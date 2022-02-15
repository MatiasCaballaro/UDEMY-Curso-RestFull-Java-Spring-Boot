package com.example.curso.dao;

import com.example.curso.entity.Profesor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface iProfesorDao extends CrudRepository <Profesor, Long> {

    public Profesor findByEmail(String email);

    public Profesor findByEmailAndPassword(String email, String password);

    public Optional<Profesor> findById(String id);


    // Ejemplo de Query con su annotation
    @Query("select p from Profesor p where p.id=?1")
    public Profesor findByIdSQL(Long id);

}
