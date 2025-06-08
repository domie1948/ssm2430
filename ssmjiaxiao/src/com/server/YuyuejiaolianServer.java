package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Yuyuejiaolian;

public interface YuyuejiaolianServer {

  public int add(Yuyuejiaolian po);

  public int update(Yuyuejiaolian po);
  
  
  
  public int delete(int id);

  public List<Yuyuejiaolian> getAll(Map<String,Object> map);
  public List<Yuyuejiaolian> getsyyuyuejiaolian1(Map<String,Object> map);
  public List<Yuyuejiaolian> getsyyuyuejiaolian2(Map<String,Object> map);
  public List<Yuyuejiaolian> getsyyuyuejiaolian3(Map<String,Object> map);
  public Yuyuejiaolian quchongYuyuejiaolian(Map<String, Object> acount);

  public Yuyuejiaolian getById( int id);

  public List<Yuyuejiaolian> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Yuyuejiaolian> select(Map<String, Object> map);
}
//	所有List
