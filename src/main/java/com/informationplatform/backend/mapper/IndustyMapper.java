package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Industy;

import java.util.List;

public interface IndustyMapper {
    void selectAll();//查询表中所有结果
    List<Industy> selectTolist();//查询结果存储在集合中
    Industy select (Industy in);//查询单条记录
    int insert(Industy in);//插入
    int delete(Industy in);//删除
    int update(Industy in);
}
