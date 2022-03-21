package com.example.curso.service;

import com.example.curso.dao.ILenguajeDao;
import com.example.curso.entity.Lenguaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LenguajeService implements iLenguajeService{

    @Autowired
    private ILenguajeDao ilenguajeDao;


    @Override
    @Transactional(readOnly = true)
    public List<Lenguaje> findAll() {
        return (List<Lenguaje>) ilenguajeDao.findAll();
    }

    @Override
    @Transactional
    public void savelenguaje(Lenguaje lenguaje) {
        ilenguajeDao.save(lenguaje);
    }

    @Override
    @Transactional(readOnly = true)
    public Lenguaje findLenguajeByID(Long id) {
        return ilenguajeDao.findByIdSQL(id);
    }


}
