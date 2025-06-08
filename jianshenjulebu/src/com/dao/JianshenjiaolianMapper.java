package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jianshenjiaolian;

public interface JianshenjiaolianMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jianshenjiaolian record);

    int insertSelective(Jianshenjiaolian record);

    Jianshenjiaolian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jianshenjiaolian record);
	
    int updateByPrimaryKey(Jianshenjiaolian record);
	public Jianshenjiaolian quchongJianshenjiaolian(Map<String, Object> jiaolianbianhao);
	public List<Jianshenjiaolian> getAll(Map<String, Object> map);
	public List<Jianshenjiaolian> getsyjianshenjiaolian1(Map<String, Object> map);
	public List<Jianshenjiaolian> getsyjianshenjiaolian3(Map<String, Object> map);
	public List<Jianshenjiaolian> getsyjianshenjiaolian2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jianshenjiaolian> getByPage(Map<String, Object> map);
	public List<Jianshenjiaolian> select(Map<String, Object> map);
//	所有List
}

