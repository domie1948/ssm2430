package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Jiaolianxinxi;

public interface JiaolianxinxiServer {

  public int add(Jiaolianxinxi po);

  public int update(Jiaolianxinxi po);
  
  
  
  public int delete(int id);

  public List<Jiaolianxinxi> getAll(Map<String,Object> map);
  public List<Jiaolianxinxi> getsyjiaolianxinxi1(Map<String,Object> map);
  public List<Jiaolianxinxi> getsyjiaolianxinxi2(Map<String,Object> map);
  public List<Jiaolianxinxi> getsyjiaolianxinxi3(Map<String,Object> map);
  public Jiaolianxinxi quchongJiaolianxinxi(Map<String, Object> acount);

  public Jiaolianxinxi getById( int id);

  public List<Jiaolianxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Jiaolianxinxi> select(Map<String, Object> map);
}
//	所有List
