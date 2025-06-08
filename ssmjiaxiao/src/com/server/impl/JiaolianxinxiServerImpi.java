package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.JiaolianxinxiMapper;
import com.entity.Jiaolianxinxi;
import com.server.JiaolianxinxiServer;
@Service
public class JiaolianxinxiServerImpi implements JiaolianxinxiServer {
   @Resource
   private JiaolianxinxiMapper gdao;
	@Override
	public int add(Jiaolianxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Jiaolianxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Jiaolianxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Jiaolianxinxi> getsyjiaolianxinxi1(Map<String, Object> map) {
		return gdao.getsyjiaolianxinxi1(map);
	}
	public List<Jiaolianxinxi> getsyjiaolianxinxi2(Map<String, Object> map) {
		return gdao.getsyjiaolianxinxi2(map);
	}
	public List<Jiaolianxinxi> getsyjiaolianxinxi3(Map<String, Object> map) {
		return gdao.getsyjiaolianxinxi3(map);
	}
	
	@Override
	public Jiaolianxinxi quchongJiaolianxinxi(Map<String, Object> account) {
		return gdao.quchongJiaolianxinxi(account);
	}

	@Override
	public List<Jiaolianxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Jiaolianxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Jiaolianxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

