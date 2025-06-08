package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jianshenkecheng;

public interface JianshenkechengServer {

  public int add(Jianshenkecheng po);

  public int update(Jianshenkecheng po);
  
  
  
  public int delete(int id);

  public List<Jianshenkecheng> getAll(Map<String,Object> map);
  public List<Jianshenkecheng> getsyjianshenkecheng1(Map<String,Object> map);
  public List<Jianshenkecheng> getsyjianshenkecheng2(Map<String,Object> map);
  public List<Jianshenkecheng> getsyjianshenkecheng3(Map<String,Object> map);
  public Jianshenkecheng quchongJianshenkecheng(Map<String, Object> acount);

  public Jianshenkecheng getById( int id);

  public List<Jianshenkecheng> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jianshenkecheng> select(Map<String, Object> map);
}
//	所有List
