package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jianshenqixie;

public interface JianshenqixieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jianshenqixie record);

    int insertSelective(Jianshenqixie record);

    Jianshenqixie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jianshenqixie record);
	
    int updateByPrimaryKey(Jianshenqixie record);
	public Jianshenqixie quchongJianshenqixie(Map<String, Object> bianhao);
	public List<Jianshenqixie> getAll(Map<String, Object> map);
	public List<Jianshenqixie> getsyjianshenqixie1(Map<String, Object> map);
	public List<Jianshenqixie> getsyjianshenqixie3(Map<String, Object> map);
	public List<Jianshenqixie> getsyjianshenqixie2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jianshenqixie> getByPage(Map<String, Object> map);
	public List<Jianshenqixie> select(Map<String, Object> map);
//	所有List
}

