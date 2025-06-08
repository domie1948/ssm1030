package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Kechengyuyue;

public interface KechengyuyueServer {

  public int add(Kechengyuyue po);

  public int update(Kechengyuyue po);
  
  
  
  public int delete(int id);

  public List<Kechengyuyue> getAll(Map<String,Object> map);
  public List<Kechengyuyue> getsykechengyuyue1(Map<String,Object> map);
  public List<Kechengyuyue> getsykechengyuyue2(Map<String,Object> map);
  public List<Kechengyuyue> getsykechengyuyue3(Map<String,Object> map);
  public Kechengyuyue quchongKechengyuyue(Map<String, Object> acount);

  public Kechengyuyue getById( int id);

  public List<Kechengyuyue> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Kechengyuyue> select(Map<String, Object> map);
}
//	所有List
