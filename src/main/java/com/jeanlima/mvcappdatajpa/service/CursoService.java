package com.jeanlima.mvcappdatajpa.service;

import java.util.List;

import com.jeanlima.mvcappdatajpa.model.Curso;
import org.springframework.stereotype.Service;

import com.jeanlima.mvcappdatajpa.model.Estudante;


@Service
public interface CursoService {

    public Curso salveCurso(Curso curso);
    public void deleteCurso(Curso curso);

    Curso getCursoById(Integer id);

    public List<Curso> getListaCurso();






}
