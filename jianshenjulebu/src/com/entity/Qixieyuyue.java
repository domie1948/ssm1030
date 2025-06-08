package com.entity;

public class Qixieyuyue {
    private Integer id;
	private String bianhao;	private String qixiemingcheng;	private String shijianduan;	private String yonghuming;	private String issh;	
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
    }	public String getQixiemingcheng() {
        return qixiemingcheng;
    }
    public void setQixiemingcheng(String qixiemingcheng) {
        this.qixiemingcheng = qixiemingcheng == null ? null : qixiemingcheng.trim();
    }	public String getShijianduan() {
        return shijianduan;
    }
    public void setShijianduan(String shijianduan) {
        this.shijianduan = shijianduan == null ? null : shijianduan.trim();
    }	public String getYonghuming() {
        return yonghuming;
    }
    public void setYonghuming(String yonghuming) {
        this.yonghuming = yonghuming == null ? null : yonghuming.trim();
    }	public String getIssh() {
        return issh;
    }
    public void setIssh(String issh) {
        this.issh = issh == null ? null : issh.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
