package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qixieyuyue;

public interface QixieyuyueServer {

  public int add(Qixieyuyue po);

  public int update(Qixieyuyue po);
  
  
  
  public int delete(int id);

  public List<Qixieyuyue> getAll(Map<String,Object> map);
  public List<Qixieyuyue> getsyqixieyuyue1(Map<String,Object> map);
  public List<Qixieyuyue> getsyqixieyuyue2(Map<String,Object> map);
  public List<Qixieyuyue> getsyqixieyuyue3(Map<String,Object> map);
  public Qixieyuyue quchongQixieyuyue(Map<String, Object> acount);

  public Qixieyuyue getById( int id);

  public List<Qixieyuyue> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Qixieyuyue> select(Map<String, Object> map);
}
//	所有List
