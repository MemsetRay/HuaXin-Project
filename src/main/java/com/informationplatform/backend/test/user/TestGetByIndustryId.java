package com.informationplatform.backend.test.user;

import com.informationplatform.backend.mapper.impl.UserMapperImpl;
import com.informationplatform.backend.pojo.User;

import java.util.List;

public class TestGetByIndustryId {
    public static void main(String[] args) {
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        List<User> userList = userMapperImpl.getByIndustryId(20);
        for (User user : userList) {
            System.out.println(user.getId() + " " + user.getBaseId() + " " + user.getBase() + " " + user.getName());
        }
    }
}
