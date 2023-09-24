package com.informationplatform.backend.test.user;

import com.informationplatform.backend.mapper.impl.UserMapperImpl;
import com.informationplatform.backend.pojo.User;

public class TestChange {
    public static void main(String[] args) {
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        User user = userMapperImpl.getByUsername("jjn");
        user.setTelephone("998244353");
        userMapperImpl.change(user);
    }
}
