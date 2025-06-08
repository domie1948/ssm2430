package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Baomingxinxi;

public interface BaomingxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Baomingxinxi record);

    int insertSelective(Baomingxinxi record);

    Baomingxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Baomingxinxi record);
	
    int updateByPrimaryKey(Baomingxinxi record);
	public Baomingxinxi quchongBaomingxinxi(Map<String, Object> yonghuming);
	public List<Baomingxinxi> getAll(Map<String, Object> map);
	public List<Baomingxinxi> getsybaomingxinxi1(Map<String, Object> map);
	public List<Baomingxinxi> getsybaomingxinxi3(Map<String, Object> map);
	public List<Baomingxinxi> getsybaomingxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Baomingxinxi> getByPage(Map<String, Object> map);
	public List<Baomingxinxi> select(Map<String, Object> map);
//	所有List
}

