package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.XuexiziliaoMapper;
import com.entity.Xuexiziliao;
import com.server.XuexiziliaoServer;
@Service
public class XuexiziliaoServerImpi implements XuexiziliaoServer {
   @Resource
   private XuexiziliaoMapper gdao;
	@Override
	public int add(Xuexiziliao po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Xuexiziliao po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Xuexiziliao> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Xuexiziliao> getsyxuexiziliao1(Map<String, Object> map) {
		return gdao.getsyxuexiziliao1(map);
	}
	public List<Xuexiziliao> getsyxuexiziliao2(Map<String, Object> map) {
		return gdao.getsyxuexiziliao2(map);
	}
	public List<Xuexiziliao> getsyxuexiziliao3(Map<String, Object> map) {
		return gdao.getsyxuexiziliao3(map);
	}
	
	@Override
	public Xuexiziliao quchongXuexiziliao(Map<String, Object> account) {
		return gdao.quchongXuexiziliao(account);
	}

	@Override
	public List<Xuexiziliao> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Xuexiziliao> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Xuexiziliao getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

