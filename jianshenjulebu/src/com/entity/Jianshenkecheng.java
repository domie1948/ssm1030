package com.entity;

public class Jianshenkecheng {
    private Integer id;
	private String bianhao;	private String kechengmingcheng;	private String shangkeshijian;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getBianhao() {
        return bianhao;
    }
    public void setBianhao(String bianhao) {
        this.bianhao = bianhao == null ? null : bianhao.trim();
    }	public String getKechengmingcheng() {
        return kechengmingcheng;
    }
    public void setKechengmingcheng(String kechengmingcheng) {
        this.kechengmingcheng = kechengmingcheng == null ? null : kechengmingcheng.trim();
    }	public String getShangkeshijian() {
        return shangkeshijian;
    }
    public void setShangkeshijian(String shangkeshijian) {
        this.shangkeshijian = shangkeshijian == null ? null : shangkeshijian.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
