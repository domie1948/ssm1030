package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JianshenkechengMapper;
import com.entity.Jianshenkecheng;
import com.server.JianshenkechengServer;
@Service
public class JianshenkechengServerImpi implements JianshenkechengServer {
   @Resource
   private JianshenkechengMapper gdao;
	@Override
	public int add(Jianshenkecheng po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jianshenkecheng po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jianshenkecheng> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jianshenkecheng> getsyjianshenkecheng1(Map<String, Object> map) {
		return gdao.getsyjianshenkecheng1(map);
	}
	public List<Jianshenkecheng> getsyjianshenkecheng2(Map<String, Object> map) {
		return gdao.getsyjianshenkecheng2(map);
	}
	public List<Jianshenkecheng> getsyjianshenkecheng3(Map<String, Object> map) {
		return gdao.getsyjianshenkecheng3(map);
	}
	
	@Override
	public Jianshenkecheng quchongJianshenkecheng(Map<String, Object> account) {
		return gdao.quchongJianshenkecheng(account);
	}

	@Override
	public List<Jianshenkecheng> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jianshenkecheng> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jianshenkecheng getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

