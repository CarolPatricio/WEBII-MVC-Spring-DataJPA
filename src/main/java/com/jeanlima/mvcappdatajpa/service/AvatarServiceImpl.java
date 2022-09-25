package com.jeanlima.mvcappdatajpa.service;

import com.jeanlima.mvcappdatajpa.model.Avatar;
import com.jeanlima.mvcappdatajpa.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AvatarServiceImpl implements AvatarService{

    @Autowired
    AvatarRepository avatarRepository;

    @Override
    public Avatar salvarAvatar(Avatar avatar) {
        return avatarRepository.save(avatar);
    }


    @Override
    public List<Avatar> getListaAvatar() {
        return avatarRepository.findAll();
    }
}
