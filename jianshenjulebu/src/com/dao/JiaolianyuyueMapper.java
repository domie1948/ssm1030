package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiaolianyuyue;

public interface JiaolianyuyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiaolianyuyue record);

    int insertSelective(Jiaolianyuyue record);

    Jiaolianyuyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiaolianyuyue record);
	
    int updateByPrimaryKey(Jiaolianyuyue record);
	public Jiaolianyuyue quchongJiaolianyuyue(Map<String, Object> yonghuming);
	public List<Jiaolianyuyue> getAll(Map<String, Object> map);
	public List<Jiaolianyuyue> getsyjiaolianyuyue1(Map<String, Object> map);
	public List<Jiaolianyuyue> getsyjiaolianyuyue3(Map<String, Object> map);
	public List<Jiaolianyuyue> getsyjiaolianyuyue2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiaolianyuyue> getByPage(Map<String, Object> map);
	public List<Jiaolianyuyue> select(Map<String, Object> map);
//	所有List
}

