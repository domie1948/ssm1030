package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jianshenkecheng;

public interface JianshenkechengMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jianshenkecheng record);

    int insertSelective(Jianshenkecheng record);

    Jianshenkecheng selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jianshenkecheng record);
	
    int updateByPrimaryKey(Jianshenkecheng record);
	public Jianshenkecheng quchongJianshenkecheng(Map<String, Object> bianhao);
	public List<Jianshenkecheng> getAll(Map<String, Object> map);
	public List<Jianshenkecheng> getsyjianshenkecheng1(Map<String, Object> map);
	public List<Jianshenkecheng> getsyjianshenkecheng3(Map<String, Object> map);
	public List<Jianshenkecheng> getsyjianshenkecheng2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jianshenkecheng> getByPage(Map<String, Object> map);
	public List<Jianshenkecheng> select(Map<String, Object> map);
//	所有List
}

