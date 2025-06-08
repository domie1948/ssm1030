package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yonghuxinxi;

public interface YonghuxinxiServer {

  public int add(Yonghuxinxi po);

  public int update(Yonghuxinxi po);
  
  
  
  public int delete(int id);

  public List<Yonghuxinxi> getAll(Map<String,Object> map);
  public List<Yonghuxinxi> getsyyonghuxinxi1(Map<String,Object> map);
  public List<Yonghuxinxi> getsyyonghuxinxi2(Map<String,Object> map);
  public List<Yonghuxinxi> getsyyonghuxinxi3(Map<String,Object> map);
  public Yonghuxinxi quchongYonghuxinxi(Map<String, Object> acount);

  public Yonghuxinxi getById( int id);

  public List<Yonghuxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yonghuxinxi> select(Map<String, Object> map);
}
//	所有List
