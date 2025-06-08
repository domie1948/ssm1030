package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiaolianyuyueMapper;
import com.entity.Jiaolianyuyue;
import com.server.JiaolianyuyueServer;
@Service
public class JiaolianyuyueServerImpi implements JiaolianyuyueServer {
   @Resource
   private JiaolianyuyueMapper gdao;
	@Override
	public int add(Jiaolianyuyue po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiaolianyuyue po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiaolianyuyue> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiaolianyuyue> getsyjiaolianyuyue1(Map<String, Object> map) {
		return gdao.getsyjiaolianyuyue1(map);
	}
	public List<Jiaolianyuyue> getsyjiaolianyuyue2(Map<String, Object> map) {
		return gdao.getsyjiaolianyuyue2(map);
	}
	public List<Jiaolianyuyue> getsyjiaolianyuyue3(Map<String, Object> map) {
		return gdao.getsyjiaolianyuyue3(map);
	}
	
	@Override
	public Jiaolianyuyue quchongJiaolianyuyue(Map<String, Object> account) {
		return gdao.quchongJiaolianyuyue(account);
	}

	@Override
	public List<Jiaolianyuyue> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiaolianyuyue> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiaolianyuyue getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

