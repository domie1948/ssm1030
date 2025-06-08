package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiaolianyuyue;

public interface JiaolianyuyueServer {

  public int add(Jiaolianyuyue po);

  public int update(Jiaolianyuyue po);
  
  
  
  public int delete(int id);

  public List<Jiaolianyuyue> getAll(Map<String,Object> map);
  public List<Jiaolianyuyue> getsyjiaolianyuyue1(Map<String,Object> map);
  public List<Jiaolianyuyue> getsyjiaolianyuyue2(Map<String,Object> map);
  public List<Jiaolianyuyue> getsyjiaolianyuyue3(Map<String,Object> map);
  public Jiaolianyuyue quchongJiaolianyuyue(Map<String, Object> acount);

  public Jiaolianyuyue getById( int id);

  public List<Jiaolianyuyue> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiaolianyuyue> select(Map<String, Object> map);
}
//	所有List
