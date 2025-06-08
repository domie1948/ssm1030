package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.KechengyuyueMapper;
import com.entity.Kechengyuyue;
import com.server.KechengyuyueServer;
@Service
public class KechengyuyueServerImpi implements KechengyuyueServer {
   @Resource
   private KechengyuyueMapper gdao;
	@Override
	public int add(Kechengyuyue po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Kechengyuyue po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Kechengyuyue> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Kechengyuyue> getsykechengyuyue1(Map<String, Object> map) {
		return gdao.getsykechengyuyue1(map);
	}
	public List<Kechengyuyue> getsykechengyuyue2(Map<String, Object> map) {
		return gdao.getsykechengyuyue2(map);
	}
	public List<Kechengyuyue> getsykechengyuyue3(Map<String, Object> map) {
		return gdao.getsykechengyuyue3(map);
	}
	
	@Override
	public Kechengyuyue quchongKechengyuyue(Map<String, Object> account) {
		return gdao.quchongKechengyuyue(account);
	}

	@Override
	public List<Kechengyuyue> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Kechengyuyue> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Kechengyuyue getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

