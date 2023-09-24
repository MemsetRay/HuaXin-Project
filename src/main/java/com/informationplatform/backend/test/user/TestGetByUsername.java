package com.informationplatform.backend.test.user;

import com.informationplatform.backend.mapper.impl.UserMapperImpl;
import com.informationplatform.backend.pojo.User;

import java.util.List;

public class TestGetByUsername {
    public static void main(String[] args) {
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        User user = userMapperImpl.getByUsername("aj");
        System.out.println(user.getId() + " " + user.getBaseId() + " " + user.getBase() + " " + user.getName());
    }
}
