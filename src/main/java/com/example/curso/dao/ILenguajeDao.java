package com.example.curso.dao;

import com.example.curso.entity.Lenguaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ILenguajeDao extends CrudRepository<Lenguaje, Long> {

//    @Query("select l from lenguaje l where l.id=?1")
//    public Lenguaje findByIdSQL(Long id);

//    public Optional<Lenguaje> findById(Long id);


    @Query("select l from Lenguaje l where l.id=?1")
    public Lenguaje findByIdSQL(Long id);
}
