package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Baomingxinxi;

public interface BaomingxinxiServer {

  public int add(Baomingxinxi po);

  public int update(Baomingxinxi po);
  
  
  
  public int delete(int id);

  public List<Baomingxinxi> getAll(Map<String,Object> map);
  public List<Baomingxinxi> getsybaomingxinxi1(Map<String,Object> map);
  public List<Baomingxinxi> getsybaomingxinxi2(Map<String,Object> map);
  public List<Baomingxinxi> getsybaomingxinxi3(Map<String,Object> map);
  public Baomingxinxi quchongBaomingxinxi(Map<String, Object> acount);

  public Baomingxinxi getById( int id);

  public List<Baomingxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Baomingxinxi> select(Map<String, Object> map);
}
//	所有List
