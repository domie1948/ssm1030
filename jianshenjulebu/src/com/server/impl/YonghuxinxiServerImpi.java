package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YonghuxinxiMapper;
import com.entity.Yonghuxinxi;
import com.server.YonghuxinxiServer;
@Service
public class YonghuxinxiServerImpi implements YonghuxinxiServer {
   @Resource
   private YonghuxinxiMapper gdao;
	@Override
	public int add(Yonghuxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yonghuxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yonghuxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yonghuxinxi> getsyyonghuxinxi1(Map<String, Object> map) {
		return gdao.getsyyonghuxinxi1(map);
	}
	public List<Yonghuxinxi> getsyyonghuxinxi2(Map<String, Object> map) {
		return gdao.getsyyonghuxinxi2(map);
	}
	public List<Yonghuxinxi> getsyyonghuxinxi3(Map<String, Object> map) {
		return gdao.getsyyonghuxinxi3(map);
	}
	
	@Override
	public Yonghuxinxi quchongYonghuxinxi(Map<String, Object> account) {
		return gdao.quchongYonghuxinxi(account);
	}

	@Override
	public List<Yonghuxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yonghuxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yonghuxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

