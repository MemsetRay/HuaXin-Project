package com.informationplatform.backend.test.user;

import com.informationplatform.backend.mapper.impl.UserMapperImpl;
import com.informationplatform.backend.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class TestGetByBaseId {
    public static void main(String[] args) {
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        List<User> userList = userMapperImpl.getByBaseId(3);
        for (User user : userList) {
            System.out.println(user.getId() + " " + user.getBaseId() + " " + user.getBase() + " " + user.getName());
        }
    }
}
