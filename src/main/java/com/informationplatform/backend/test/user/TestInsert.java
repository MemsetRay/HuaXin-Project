package com.informationplatform.backend.test.user;

import com.informationplatform.backend.mapper.impl.UserMapperImpl;
import com.informationplatform.backend.pojo.User;

public class TestInsert {
    public static void main(String[] args) {
        UserMapperImpl userMapperImpl = new UserMapperImpl();
        User user = new User("ins","333","ibm2","110110110","ins@email",6,20,"pldbase","it","gif");
        userMapperImpl.insert(user);
    }
}
