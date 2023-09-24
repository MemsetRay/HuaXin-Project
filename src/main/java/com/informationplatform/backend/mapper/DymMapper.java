package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Dym;

import java.util.List;

public interface DymMapper {
    void selectAll();//查询表中所有结果
    List<Dym> selectTolist();//查询结果存储在集合中
    Dym select (Dym dym);//查询单条记录
    int insert(Dym dym);//插入
    int delete(Dym dym);//删除
    int update(Dym dym);//更新


}
