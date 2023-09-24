package com.informationplatform.backend.mapper;



import com.informationplatform.backend.pojo.City;

import java.util.List;

public interface CityMapper {
    /**
     *查询全部城市信息
     * @return
     */
    List<City> SelectAll();

    /**
     * 按城市号查询城市信息
     * @param cityid
     * @return
     */
    City SelectById( int cityid);

    /**
     * 更新城市信息
     * @param city
     * @return
     */
    int Update(City city);

    /**
     * 插入一个城市信息
     * @param city
     * @return
     */
    int Insert(City city);

    /**+
     * 删除城市信息
     * @param city
     * @return
     */
    int Delete(City city);
}
