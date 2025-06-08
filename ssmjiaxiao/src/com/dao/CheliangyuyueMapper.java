package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Cheliangyuyue;

public interface CheliangyuyueMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cheliangyuyue record);

    int insertSelective(Cheliangyuyue record);

    Cheliangyuyue selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cheliangyuyue record);
	
    int updateByPrimaryKey(Cheliangyuyue record);
	public Cheliangyuyue quchongCheliangyuyue(Map<String, Object> yuyueren);
	public List<Cheliangyuyue> getAll(Map<String, Object> map);
	public List<Cheliangyuyue> getsycheliangyuyue1(Map<String, Object> map);
	public List<Cheliangyuyue> getsycheliangyuyue3(Map<String, Object> map);
	public List<Cheliangyuyue> getsycheliangyuyue2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Cheliangyuyue> getByPage(Map<String, Object> map);
	public List<Cheliangyuyue> select(Map<String, Object> map);
//	所有List
}

