package com.jeanlima.mvcappdatajpa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.jeanlima.mvcappdatajpa.model.Avatar;

public interface AvatarService {

    public Avatar salvarAvatar(Avatar avatar);

    public List<Avatar> getListaAvatar();
}
