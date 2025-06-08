package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jianshenqixie;

public interface JianshenqixieServer {

  public int add(Jianshenqixie po);

  public int update(Jianshenqixie po);
  
  
  
  public int delete(int id);

  public List<Jianshenqixie> getAll(Map<String,Object> map);
  public List<Jianshenqixie> getsyjianshenqixie1(Map<String,Object> map);
  public List<Jianshenqixie> getsyjianshenqixie2(Map<String,Object> map);
  public List<Jianshenqixie> getsyjianshenqixie3(Map<String,Object> map);
  public Jianshenqixie quchongJianshenqixie(Map<String, Object> acount);

  public Jianshenqixie getById( int id);

  public List<Jianshenqixie> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jianshenqixie> select(Map<String, Object> map);
}
//	所有List
