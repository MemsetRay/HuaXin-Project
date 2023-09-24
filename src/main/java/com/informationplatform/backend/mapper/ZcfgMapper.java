package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Zcfg;

import java.util.List;

public interface ZcfgMapper {
    /**
     *查询全部政策信息
     * @return
     */
    List<Zcfg> SelectAll();

    /**
     * 按城市号查询政策信息
     * @param id
     * @return
     */
    Zcfg SelectById( int id);

    /**
     * 更新政策信息
     * @param zcfg
     * @return
     */
    int Update(Zcfg zcfg);

    /**
     * 插入一个政策信息
     * @param zcfg
     * @return
     */
    int Insert(Zcfg zcfg);

    /**+
     * 删除政策信息
     * @param zcfg
     * @return
     */
    int Delete(Zcfg zcfg);
}


