package com.jeanlima.mvcappdatajpa.service;

import java.util.List;

import com.jeanlima.mvcappdatajpa.model.Curso;
import com.jeanlima.mvcappdatajpa.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CursoServiceImpl implements CursoService{

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso salveCurso(Curso curso) {

        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Curso curso) {
        cursoRepository.delete(curso);

    }

    @Override
    public Curso getCursoById(Integer id) {
        return cursoRepository.findById(id).map(curso -> {
            return curso;
        }).orElseThrow(() -> null);
    }

    @Override
    public List<Curso> getListaCurso() {
        return cursoRepository.findAll();
    }

}
