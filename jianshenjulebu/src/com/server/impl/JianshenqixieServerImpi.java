package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JianshenqixieMapper;
import com.entity.Jianshenqixie;
import com.server.JianshenqixieServer;
@Service
public class JianshenqixieServerImpi implements JianshenqixieServer {
   @Resource
   private JianshenqixieMapper gdao;
	@Override
	public int add(Jianshenqixie po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jianshenqixie po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jianshenqixie> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jianshenqixie> getsyjianshenqixie1(Map<String, Object> map) {
		return gdao.getsyjianshenqixie1(map);
	}
	public List<Jianshenqixie> getsyjianshenqixie2(Map<String, Object> map) {
		return gdao.getsyjianshenqixie2(map);
	}
	public List<Jianshenqixie> getsyjianshenqixie3(Map<String, Object> map) {
		return gdao.getsyjianshenqixie3(map);
	}
	
	@Override
	public Jianshenqixie quchongJianshenqixie(Map<String, Object> account) {
		return gdao.quchongJianshenqixie(account);
	}

	@Override
	public List<Jianshenqixie> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jianshenqixie> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jianshenqixie getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

