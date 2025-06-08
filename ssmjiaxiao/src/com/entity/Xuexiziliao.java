package com.entity;

public class Xuexiziliao {
    private Integer id;
	private String ziliaomingcheng;	private String shumian;	private String shipin;	private String wenjian;	private String jianjie;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getZiliaomingcheng() {
        return ziliaomingcheng;
    }
    public void setZiliaomingcheng(String ziliaomingcheng) {
        this.ziliaomingcheng = ziliaomingcheng == null ? null : ziliaomingcheng.trim();
    }	public String getShumian() {
        return shumian;
    }
    public void setShumian(String shumian) {
        this.shumian = shumian == null ? null : shumian.trim();
    }	public String getShipin() {
        return shipin;
    }
    public void setShipin(String shipin) {
        this.shipin = shipin == null ? null : shipin.trim();
    }	public String getWenjian() {
        return wenjian;
    }
    public void setWenjian(String wenjian) {
        this.wenjian = wenjian == null ? null : wenjian.trim();
    }	public String getJianjie() {
        return jianjie;
    }
    public void setJianjie(String jianjie) {
        this.jianjie = jianjie == null ? null : jianjie.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
