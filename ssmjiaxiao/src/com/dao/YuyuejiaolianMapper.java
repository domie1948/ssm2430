package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Yuyuejiaolian;

public interface YuyuejiaolianMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Yuyuejiaolian record);

    int insertSelective(Yuyuejiaolian record);

    Yuyuejiaolian selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Yuyuejiaolian record);
	
    int updateByPrimaryKey(Yuyuejiaolian record);
	public Yuyuejiaolian quchongYuyuejiaolian(Map<String, Object> yuyueren);
	public List<Yuyuejiaolian> getAll(Map<String, Object> map);
	public List<Yuyuejiaolian> getsyyuyuejiaolian1(Map<String, Object> map);
	public List<Yuyuejiaolian> getsyyuyuejiaolian3(Map<String, Object> map);
	public List<Yuyuejiaolian> getsyyuyuejiaolian2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Yuyuejiaolian> getByPage(Map<String, Object> map);
	public List<Yuyuejiaolian> select(Map<String, Object> map);
//	所有List
}

