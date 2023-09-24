package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Sckt;

import java.util.List;

public interface ScktMapper {
    /**
     *查询全部市场信息
     * @return
     */
    List<Sckt> SelectAll();
    /**
     * 按id查询市场信息
     * @param id
     * @return
     */
    Sckt SelectById( int id);

    /**
     * 更新市场信息
     * @param sckt
     * @return
     */
    int Update(Sckt sckt);

    /**
     * 插入一个市场信息
     * @param sckt
     * @return
     */
int Insert(Sckt sckt);

    /**+
     * 删除市场信息
     * @param sckt
     * @return
     */
    int Delete(Sckt sckt);
}
