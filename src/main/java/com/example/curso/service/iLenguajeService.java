package com.example.curso.service;

import com.example.curso.entity.Lenguaje;

import java.util.List;
import java.util.Optional;

public interface iLenguajeService {

    public List<Lenguaje> findAll();

    public void savelenguaje(Lenguaje lenguaje);

    public Lenguaje findLenguajeByID(Long id);

}
