package com.example.curso.service;

import com.example.curso.dao.iCursoDao;
import com.example.curso.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements iCursoService{

    @Autowired
    private iCursoDao cursoDao;




    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return(List<Curso>) cursoDao.findAll();
    }

    @Override
    public void save(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> getCursosProfesor(Long id) {
        return (List<Curso>) cursoDao.findByProfesorId(id);
    }

    @Override
    public void deleteCurso(Curso curso) {
        cursoDao.deleteById(curso.getCurso_id());
    }

    @Override
    public void deleteCurso(Long id) {
        cursoDao.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAllCurso() {
        cursoDao.deleteAll();
    }

    @Override
    public Curso findByID(Long id) {
        return cursoDao.findById(id).orElse(null);
    }


}
