package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JianshenjiaolianMapper;
import com.entity.Jianshenjiaolian;
import com.server.JianshenjiaolianServer;
@Service
public class JianshenjiaolianServerImpi implements JianshenjiaolianServer {
   @Resource
   private JianshenjiaolianMapper gdao;
	@Override
	public int add(Jianshenjiaolian po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jianshenjiaolian po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jianshenjiaolian> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jianshenjiaolian> getsyjianshenjiaolian1(Map<String, Object> map) {
		return gdao.getsyjianshenjiaolian1(map);
	}
	public List<Jianshenjiaolian> getsyjianshenjiaolian2(Map<String, Object> map) {
		return gdao.getsyjianshenjiaolian2(map);
	}
	public List<Jianshenjiaolian> getsyjianshenjiaolian3(Map<String, Object> map) {
		return gdao.getsyjianshenjiaolian3(map);
	}
	
	@Override
	public Jianshenjiaolian quchongJianshenjiaolian(Map<String, Object> account) {
		return gdao.quchongJianshenjiaolian(account);
	}

	@Override
	public List<Jianshenjiaolian> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jianshenjiaolian> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jianshenjiaolian getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

