package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Kechengyuyue;

public interface KechengyuyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kechengyuyue record);

    int insertSelective(Kechengyuyue record);

    Kechengyuyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kechengyuyue record);
	
    int updateByPrimaryKey(Kechengyuyue record);
	public Kechengyuyue quchongKechengyuyue(Map<String, Object> yonghuming);
	public List<Kechengyuyue> getAll(Map<String, Object> map);
	public List<Kechengyuyue> getsykechengyuyue1(Map<String, Object> map);
	public List<Kechengyuyue> getsykechengyuyue3(Map<String, Object> map);
	public List<Kechengyuyue> getsykechengyuyue2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Kechengyuyue> getByPage(Map<String, Object> map);
	public List<Kechengyuyue> select(Map<String, Object> map);
//	所有List
}

