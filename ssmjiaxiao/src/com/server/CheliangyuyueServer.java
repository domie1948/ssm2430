package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Cheliangyuyue;

public interface CheliangyuyueServer {

  public int add(Cheliangyuyue po);

  public int update(Cheliangyuyue po);
  
  
  
  public int delete(int id);

  public List<Cheliangyuyue> getAll(Map<String,Object> map);
  public List<Cheliangyuyue> getsycheliangyuyue1(Map<String,Object> map);
  public List<Cheliangyuyue> getsycheliangyuyue2(Map<String,Object> map);
  public List<Cheliangyuyue> getsycheliangyuyue3(Map<String,Object> map);
  public Cheliangyuyue quchongCheliangyuyue(Map<String, Object> acount);

  public Cheliangyuyue getById( int id);

  public List<Cheliangyuyue> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Cheliangyuyue> select(Map<String, Object> map);
}
//	所有List
