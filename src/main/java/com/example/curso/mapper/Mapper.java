package com.example.curso.mapper;

import com.example.curso.entity.Profesor;
import com.example.curso.model.MProfesor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("mapper")
public class Mapper {

    public static List<MProfesor> convertirLista(List<Profesor> profesores){
        List<MProfesor> mprofesores = new ArrayList<>();
        for(Profesor profesor : profesores){
            mprofesores.add(new MProfesor(profesor));
        }
        return mprofesores;
    }
}
