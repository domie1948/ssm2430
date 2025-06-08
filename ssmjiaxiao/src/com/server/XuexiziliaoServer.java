package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Xuexiziliao;

public interface XuexiziliaoServer {

  public int add(Xuexiziliao po);

  public int update(Xuexiziliao po);
  
  
  
  public int delete(int id);

  public List<Xuexiziliao> getAll(Map<String,Object> map);
  public List<Xuexiziliao> getsyxuexiziliao1(Map<String,Object> map);
  public List<Xuexiziliao> getsyxuexiziliao2(Map<String,Object> map);
  public List<Xuexiziliao> getsyxuexiziliao3(Map<String,Object> map);
  public Xuexiziliao quchongXuexiziliao(Map<String, Object> acount);

  public Xuexiziliao getById( int id);

  public List<Xuexiziliao> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Xuexiziliao> select(Map<String, Object> map);
}
//	所有List
