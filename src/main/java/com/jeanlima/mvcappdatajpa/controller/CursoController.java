package com.jeanlima.mvcappdatajpa.controller;

import com.jeanlima.mvcappdatajpa.model.Curso;
import com.jeanlima.mvcappdatajpa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    @Qualifier("cursoServiceImpl")
    CursoService cursoService;

    @RequestMapping("/showForm")
    public String showFromCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "curso/formCurso";
    }

    @RequestMapping("/addCurso")
    public String addCurso(@ModelAttribute("curso") Curso curso, Model model) {

        Curso novoCurso = cursoService.salveCurso(curso);
        model.addAttribute("curso", novoCurso);
        return "curso/paginaCurso";
    }

    @RequestMapping("/getListaCursos")
    public String showListaCursos(Model model) {
        List<Curso> cursos = cursoService.getListaCurso();
        model.addAttribute("cursos", cursos);
        return "curso/listaCursos";
    }


    @GetMapping("/deleteCurso/{id}")
    public String deleteCurso( @PathVariable Integer id, Model model) {
        Curso curso = cursoService.getCursoById(id);
        cursoService.deleteCurso(curso);
        List<Curso> cursos = cursoService.getListaCurso();
        model.addAttribute("cursos",cursos);
        return "curso/listaCursos";
    }

    @RequestMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        Curso curso = cursoService.getCursoById(id);
        model.addAttribute("curso", curso);
        return "curso/formEditCurso";
    }

    @RequestMapping("/updateCurso")
    public String updateCurso (@ModelAttribute("curso") Curso curso, Model model) {
        Curso cursoUpdate = cursoService.getCursoById(curso.getId());
        cursoUpdate.setDescricao(curso.getDescricao());
        cursoService.salveCurso(cursoUpdate);
        boolean edit = true;
        model.addAttribute("curso",  cursoUpdate);
        model.addAttribute("edit", edit );
        return "curso/paginaCurso";
    }

}

