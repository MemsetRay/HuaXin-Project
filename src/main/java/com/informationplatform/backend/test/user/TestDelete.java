package com.informationplatform.backend.test.user;

import com.informationplatform.backend.mapper.impl.UserMapperImpl;
import com.informationplatform.backend.pojo.User;

public class TestDelete {
    public static void main(String[] args) {
        UserMapperImpl userMapperImpl = new UserMapperImpl();
//        User user = new User("jjn","999","ibm","110110110","jjn@email",10,20,"pldbase","it","gif");
//        user = userMapperImpl.getByUsername("lqr");
//        System.out.println(user.getId() + " " + user.getName() + " " + user.getPassword());
//        userMapperImpl.insert(user);
        userMapperImpl.delete("lqr");
    }
}
