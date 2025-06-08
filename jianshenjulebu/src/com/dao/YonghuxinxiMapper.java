package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yonghuxinxi;

public interface YonghuxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yonghuxinxi record);

    int insertSelective(Yonghuxinxi record);

    Yonghuxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yonghuxinxi record);
	
    int updateByPrimaryKey(Yonghuxinxi record);
	public Yonghuxinxi quchongYonghuxinxi(Map<String, Object> yonghuming);
	public List<Yonghuxinxi> getAll(Map<String, Object> map);
	public List<Yonghuxinxi> getsyyonghuxinxi1(Map<String, Object> map);
	public List<Yonghuxinxi> getsyyonghuxinxi3(Map<String, Object> map);
	public List<Yonghuxinxi> getsyyonghuxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yonghuxinxi> getByPage(Map<String, Object> map);
	public List<Yonghuxinxi> select(Map<String, Object> map);
//	所有List
}

