package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BaomingxinxiMapper;
import com.entity.Baomingxinxi;
import com.server.BaomingxinxiServer;
@Service
public class BaomingxinxiServerImpi implements BaomingxinxiServer {
   @Resource
   private BaomingxinxiMapper gdao;
	@Override
	public int add(Baomingxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Baomingxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Baomingxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Baomingxinxi> getsybaomingxinxi1(Map<String, Object> map) {
		return gdao.getsybaomingxinxi1(map);
	}
	public List<Baomingxinxi> getsybaomingxinxi2(Map<String, Object> map) {
		return gdao.getsybaomingxinxi2(map);
	}
	public List<Baomingxinxi> getsybaomingxinxi3(Map<String, Object> map) {
		return gdao.getsybaomingxinxi3(map);
	}
	
	@Override
	public Baomingxinxi quchongBaomingxinxi(Map<String, Object> account) {
		return gdao.quchongBaomingxinxi(account);
	}

	@Override
	public List<Baomingxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Baomingxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Baomingxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

