package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QixieyuyueMapper;
import com.entity.Qixieyuyue;
import com.server.QixieyuyueServer;
@Service
public class QixieyuyueServerImpi implements QixieyuyueServer {
   @Resource
   private QixieyuyueMapper gdao;
	@Override
	public int add(Qixieyuyue po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qixieyuyue po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qixieyuyue> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qixieyuyue> getsyqixieyuyue1(Map<String, Object> map) {
		return gdao.getsyqixieyuyue1(map);
	}
	public List<Qixieyuyue> getsyqixieyuyue2(Map<String, Object> map) {
		return gdao.getsyqixieyuyue2(map);
	}
	public List<Qixieyuyue> getsyqixieyuyue3(Map<String, Object> map) {
		return gdao.getsyqixieyuyue3(map);
	}
	
	@Override
	public Qixieyuyue quchongQixieyuyue(Map<String, Object> account) {
		return gdao.quchongQixieyuyue(account);
	}

	@Override
	public List<Qixieyuyue> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qixieyuyue> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qixieyuyue getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

