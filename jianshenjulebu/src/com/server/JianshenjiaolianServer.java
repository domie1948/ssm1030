package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jianshenjiaolian;

public interface JianshenjiaolianServer {

  public int add(Jianshenjiaolian po);

  public int update(Jianshenjiaolian po);
  
  
  
  public int delete(int id);

  public List<Jianshenjiaolian> getAll(Map<String,Object> map);
  public List<Jianshenjiaolian> getsyjianshenjiaolian1(Map<String,Object> map);
  public List<Jianshenjiaolian> getsyjianshenjiaolian2(Map<String,Object> map);
  public List<Jianshenjiaolian> getsyjianshenjiaolian3(Map<String,Object> map);
  public Jianshenjiaolian quchongJianshenjiaolian(Map<String, Object> acount);

  public Jianshenjiaolian getById( int id);

  public List<Jianshenjiaolian> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jianshenjiaolian> select(Map<String, Object> map);
}
//	所有List
