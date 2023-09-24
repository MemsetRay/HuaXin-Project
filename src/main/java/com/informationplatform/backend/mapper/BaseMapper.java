package com.informationplatform.backend.mapper;

import com.informationplatform.backend.pojo.Base;

import java.util.List;

public interface BaseMapper {
    Base getByBaseId (int baseId);

    List<Base> getByCityId (int cityId);
    List<Base> getAllBase();
    void insert (Base base);
    void change (Base base);
    void delete (int baseId);
}
