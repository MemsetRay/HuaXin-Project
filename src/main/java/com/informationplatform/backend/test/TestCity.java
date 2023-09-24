package com.informationplatform.backend.test;


import com.informationplatform.backend.mapper.impl.CityMapperImpl;
import com.informationplatform.backend.pojo.City;

import java.util.List;

public class TestCity {
    public static void main(String[] args) {
        TestCity testCity=new TestCity();
        testCity.testSelectAll();
        //testCity.testSelectById();
        //testCity.testUpdate();
        //testCity.testInsert();
        //testCity.testDelete();
    }
    public  void testSelectAll()
    {
        CityMapperImpl cityMapper=new CityMapperImpl();
        List<City>list=cityMapper.SelectAll();
        for(City city:list)
        {
            System.out.print(city.getCityid()+"\t");
            System.out.print(city.getCityname()+"\t");
            System.out.println(city.getIs_deleted()+"\t");
        }
    }
    public  void  testSelectById()
    {
        CityMapperImpl cityMapper=new CityMapperImpl();
        City city=cityMapper.SelectById(2);
        if (city!=null)
        {
            System.out.print(city.getCityid()+"\t");
            System.out.print(city.getCityname()+"\t");
            System.out.println(city.getIs_deleted()+"\t");
        }
        else {
            System.out.println("false");
        }
    }
    public  void testUpdate()
    {
        CityMapperImpl cityMapper=new CityMapperImpl();
        City city=new City();
        city.setCityid(4);
        city.setCityname("抚顺");
        int update=cityMapper.Update(city);
        if(update==1)
        {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

    }
    public  void testInsert()
    {
        CityMapperImpl cityMapper=new CityMapperImpl();
        City city=new City();
        city.setCityname("黑龙江");
        int insert=cityMapper.Insert(city);
        if(insert==1)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }
    }
    public  void testDelete()
    {
        CityMapperImpl cityMapper=new CityMapperImpl();
        City city=new City();
        city.setCityid(6);
        city.setIs_deleted(1);
        int delete=cityMapper.Delete(city);
        if(delete==1)
        {
            System.out.println("true");
        }
        else
        {
            System.out.println("false");
        }

    }
}
