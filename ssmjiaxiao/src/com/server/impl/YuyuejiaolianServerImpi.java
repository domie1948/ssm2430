package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.YuyuejiaolianMapper;
import com.entity.Yuyuejiaolian;
import com.server.YuyuejiaolianServer;
@Service
public class YuyuejiaolianServerImpi implements YuyuejiaolianServer {
   @Resource
   private YuyuejiaolianMapper gdao;
	@Override
	public int add(Yuyuejiaolian po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Yuyuejiaolian po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Yuyuejiaolian> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Yuyuejiaolian> getsyyuyuejiaolian1(Map<String, Object> map) {
		return gdao.getsyyuyuejiaolian1(map);
	}
	public List<Yuyuejiaolian> getsyyuyuejiaolian2(Map<String, Object> map) {
		return gdao.getsyyuyuejiaolian2(map);
	}
	public List<Yuyuejiaolian> getsyyuyuejiaolian3(Map<String, Object> map) {
		return gdao.getsyyuyuejiaolian3(map);
	}
	
	@Override
	public Yuyuejiaolian quchongYuyuejiaolian(Map<String, Object> account) {
		return gdao.quchongYuyuejiaolian(account);
	}

	@Override
	public List<Yuyuejiaolian> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Yuyuejiaolian> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Yuyuejiaolian getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

