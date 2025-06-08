package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CheliangyuyueMapper;
import com.entity.Cheliangyuyue;
import com.server.CheliangyuyueServer;
@Service
public class CheliangyuyueServerImpi implements CheliangyuyueServer {
   @Resource
   private CheliangyuyueMapper gdao;
	@Override
	public int add(Cheliangyuyue po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Cheliangyuyue po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Cheliangyuyue> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Cheliangyuyue> getsycheliangyuyue1(Map<String, Object> map) {
		return gdao.getsycheliangyuyue1(map);
	}
	public List<Cheliangyuyue> getsycheliangyuyue2(Map<String, Object> map) {
		return gdao.getsycheliangyuyue2(map);
	}
	public List<Cheliangyuyue> getsycheliangyuyue3(Map<String, Object> map) {
		return gdao.getsycheliangyuyue3(map);
	}
	
	@Override
	public Cheliangyuyue quchongCheliangyuyue(Map<String, Object> account) {
		return gdao.quchongCheliangyuyue(account);
	}

	@Override
	public List<Cheliangyuyue> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Cheliangyuyue> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Cheliangyuyue getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

