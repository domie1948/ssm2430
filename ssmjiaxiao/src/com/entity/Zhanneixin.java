﻿package com.entity;

public class Zhanneixin {
    private Integer id;
	private String yonghuming;	private String xingming;	private String neirong;	private String fasongren;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }	public String getXingming() {
        return xingming;
    }
    public void setXingming(String xingming) {
        this.xingming = xingming == null ? null : xingming.trim();
    }	public String getNeirong() {
        return neirong;
    }
    public void setNeirong(String neirong) {
        this.neirong = neirong == null ? null : neirong.trim();
    }	public String getFasongren() {
        return fasongren;
    }
    public void setFasongren(String fasongren) {
        this.fasongren = fasongren == null ? null : fasongren.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
