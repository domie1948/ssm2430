package com.entity;

public class Cheliangxinxi {
    private Integer id;
	private String chepaihao;	private String pinpaixinghao;	private String shoucishangpaishijian;	private String zhaopian;	private String keyuyueshiduan;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getChepaihao() {
        return chepaihao;
    }
    public void setChepaihao(String chepaihao) {
        this.chepaihao = chepaihao == null ? null : chepaihao.trim();
    }	public String getPinpaixinghao() {
        return pinpaixinghao;
    }
    public void setPinpaixinghao(String pinpaixinghao) {
        this.pinpaixinghao = pinpaixinghao == null ? null : pinpaixinghao.trim();
    }	public String getShoucishangpaishijian() {
        return shoucishangpaishijian;
    }
    public void setShoucishangpaishijian(String shoucishangpaishijian) {
        this.shoucishangpaishijian = shoucishangpaishijian == null ? null : shoucishangpaishijian.trim();
    }	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian == null ? null : zhaopian.trim();
    }	public String getKeyuyueshiduan() {
        return keyuyueshiduan;
    }
    public void setKeyuyueshiduan(String keyuyueshiduan) {
        this.keyuyueshiduan = keyuyueshiduan == null ? null : keyuyueshiduan.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
