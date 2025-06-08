package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Jiaolianxinxi;

public interface JiaolianxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Jiaolianxinxi record);

    int insertSelective(Jiaolianxinxi record);

    Jiaolianxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Jiaolianxinxi record);
	
    int updateByPrimaryKey(Jiaolianxinxi record);
	public Jiaolianxinxi quchongJiaolianxinxi(Map<String, Object> gonghao);
	public List<Jiaolianxinxi> getAll(Map<String, Object> map);
	public List<Jiaolianxinxi> getsyjiaolianxinxi1(Map<String, Object> map);
	public List<Jiaolianxinxi> getsyjiaolianxinxi3(Map<String, Object> map);
	public List<Jiaolianxinxi> getsyjiaolianxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Jiaolianxinxi> getByPage(Map<String, Object> map);
	public List<Jiaolianxinxi> select(Map<String, Object> map);
//	所有List
}

