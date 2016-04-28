package com.freturn.tech.dal.dao;

import com.freturn.tech.dal.dataobject.UserMetaDO;
import java.util.List;

public interface UserMetaDOMapper {
    int insert(UserMetaDO record);

    List<UserMetaDO> queryListByUserId(Long userId);
}