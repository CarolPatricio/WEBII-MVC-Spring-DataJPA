package com.jeanlima.mvcappdatajpa.controller;

import com.jeanlima.mvcappdatajpa.model.Avatar;
import com.jeanlima.mvcappdatajpa.model.Estudante;
import com.jeanlima.mvcappdatajpa.service.AvatarService;
import com.jeanlima.mvcappdatajpa.service.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    @Qualifier("avatarServiceImpl")
    AvatarService avatarService;

    @Autowired
    @Qualifier("estudanteServiceImpl")
    EstudanteService estudanteService;

    @RequestMapping("/getListaAvatar")
    public String showListaCursos(Model model) {
        List<Avatar> avatarList = avatarService.getListaAvatar();

        model.addAttribute("avatares", avatarList);
        return "avatar/listaAvatares";
    }

    @RequestMapping("/showForm")
    public String showFromAvatar(Model model) {
        List<Estudante> estudantes = estudanteService.getListaEstudante();

        model.addAttribute("avatar", new Avatar());
        model.addAttribute("estudantes", estudantes);
        return "avatar/formAvatar";
    }

    @RequestMapping("/addAvatar")
    public String addAvatar(@ModelAttribute("avatar") Avatar avatar, Model model) {
        avatarService.salvarAvatar(avatar);

        List<Avatar> avatarList = avatarService.getListaAvatar();
        model.addAttribute("avatares", avatarList);
        return "avatar/listaAvatares";
    }

}
