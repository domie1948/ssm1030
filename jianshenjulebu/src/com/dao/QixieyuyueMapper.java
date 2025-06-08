package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qixieyuyue;

public interface QixieyuyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qixieyuyue record);

    int insertSelective(Qixieyuyue record);

    Qixieyuyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qixieyuyue record);
	
    int updateByPrimaryKey(Qixieyuyue record);
	public Qixieyuyue quchongQixieyuyue(Map<String, Object> yonghuming);
	public List<Qixieyuyue> getAll(Map<String, Object> map);
	public List<Qixieyuyue> getsyqixieyuyue1(Map<String, Object> map);
	public List<Qixieyuyue> getsyqixieyuyue3(Map<String, Object> map);
	public List<Qixieyuyue> getsyqixieyuyue2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qixieyuyue> getByPage(Map<String, Object> map);
	public List<Qixieyuyue> select(Map<String, Object> map);
//	所有List
}

