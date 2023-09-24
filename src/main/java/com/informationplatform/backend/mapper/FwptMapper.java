package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Fwpt;

import java.util.List;

public interface FwptMapper {
    /**
     * 查询服务平台全部信息
     * @return
     */
List<Fwpt> SelectAll();

/**
 *按id查询服务平台信息
 * @param id
 * @return
 */
Fwpt SelectById(int id);


/**
 * 更新服务平台信息
 * @param fwpt
 * @return
 */

int Update(Fwpt fwpt);

    /**
     * 插入一个服务平台信息
     * @param
     * @return
     */
    int Insert(Fwpt fwpt);

    /**
     * 删除服务平台信息
     * @param fwpt
     * @return
     */
    int Delete(Fwpt fwpt);

}
