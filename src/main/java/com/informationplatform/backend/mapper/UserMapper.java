package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getByUsername (String username);

    /**
     * 根据baseId查询用户集
     * @param baseId
     * @return
     */

    List<User> getByBaseId (int baseId);

    /**
     * 根据IndustryId查询用户集
     * @param industryId
     * @return
     */
    List<User> getByIndustryId (int industryId);

    List<User> getAllUser ();

    /**
     * 添加一个用户
     * @param user
     */
    void insert (User user);

    /**
     * 修改一个用户
     * @param user
     */
    void change (User user);

    /**
     * 删除一个用户
     * @param username
     */
    void delete (String username);
}
