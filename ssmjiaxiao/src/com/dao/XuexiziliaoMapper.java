package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Xuexiziliao;

public interface XuexiziliaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Xuexiziliao record);

    int insertSelective(Xuexiziliao record);

    Xuexiziliao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Xuexiziliao record);
	
    int updateByPrimaryKey(Xuexiziliao record);
	public Xuexiziliao quchongXuexiziliao(Map<String, Object> ziliaomingcheng);
	public List<Xuexiziliao> getAll(Map<String, Object> map);
	public List<Xuexiziliao> getsyxuexiziliao1(Map<String, Object> map);
	public List<Xuexiziliao> getsyxuexiziliao3(Map<String, Object> map);
	public List<Xuexiziliao> getsyxuexiziliao2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Xuexiziliao> getByPage(Map<String, Object> map);
	public List<Xuexiziliao> select(Map<String, Object> map);
//	所有List
}

