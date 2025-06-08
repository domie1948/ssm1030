package com.entity;

public class Jianshenjiaolian {
    private Integer id;
	private String jiaolianbianhao;	private String jiaolianxingming;	private String xingbie;	private String zhuanchang;	private String zhaopian;	private String dianhua;	private String dizhi;	
    private String addtime;

    

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
	
	public String getJiaolianbianhao() {
        return jiaolianbianhao;
    }
    public void setJiaolianbianhao(String jiaolianbianhao) {
        this.jiaolianbianhao = jiaolianbianhao == null ? null : jiaolianbianhao.trim();
    }	public String getJiaolianxingming() {
        return jiaolianxingming;
    }
    public void setJiaolianxingming(String jiaolianxingming) {
        this.jiaolianxingming = jiaolianxingming == null ? null : jiaolianxingming.trim();
    }	public String getXingbie() {
        return xingbie;
    }
    public void setXingbie(String xingbie) {
        this.xingbie = xingbie == null ? null : xingbie.trim();
    }	public String getZhuanchang() {
        return zhuanchang;
    }
    public void setZhuanchang(String zhuanchang) {
        this.zhuanchang = zhuanchang == null ? null : zhuanchang.trim();
    }	public String getZhaopian() {
        return zhaopian;
    }
    public void setZhaopian(String zhaopian) {
        this.zhaopian = zhaopian == null ? null : zhaopian.trim();
    }	public String getDianhua() {
        return dianhua;
    }
    public void setDianhua(String dianhua) {
        this.dianhua = dianhua == null ? null : dianhua.trim();
    }	public String getDizhi() {
        return dizhi;
    }
    public void setDizhi(String dizhi) {
        this.dizhi = dizhi == null ? null : dizhi.trim();
    }	
	
	
    public String getAddtime() {
        return addtime;
    }
    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
    }
}
//   设置字段信息
