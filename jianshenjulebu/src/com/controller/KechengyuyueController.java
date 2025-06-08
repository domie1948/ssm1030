package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Kechengyuyue;
import com.server.KechengyuyueServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class KechengyuyueController {
	@Resource
	private KechengyuyueServer kechengyuyueService;


   
	@RequestMapping("addKechengyuyue.do")
	public String addKechengyuyue(HttpServletRequest request,Kechengyuyue kechengyuyue,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		kechengyuyue.setAddtime(time.toString().substring(0, 19));
		kechengyuyueService.add(kechengyuyue);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "kechengyuyueList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:kechengyuyueList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateKechengyuyue.do")
	public String doUpdateKechengyuyue(int id,ModelMap map,Kechengyuyue kechengyuyue){
		kechengyuyue=kechengyuyueService.getById(id);
		map.put("kechengyuyue", kechengyuyue);
		return "kechengyuyue_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("kechengyuyueDetail.do")
	public String kechengyuyueDetail(int id,ModelMap map,Kechengyuyue kechengyuyue){
		kechengyuyue=kechengyuyueService.getById(id);
		map.put("kechengyuyue", kechengyuyue);
		return "kechengyuyue_detail";
	}
//	前台详细
	@RequestMapping("kcyyDetail.do")
	public String kcyyDetail(int id,ModelMap map,Kechengyuyue kechengyuyue){
		kechengyuyue=kechengyuyueService.getById(id);
		map.put("kechengyuyue", kechengyuyue);
		return "kechengyuyuedetail";
	}
//	
	@RequestMapping("updateKechengyuyue.do")
	public String updateKechengyuyue(int id,ModelMap map,Kechengyuyue kechengyuyue,HttpServletRequest request,HttpSession session){
		kechengyuyueService.update(kechengyuyue);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:kechengyuyueList.do";
	}

//	分页查询
	@RequestMapping("kechengyuyueList.do")
	public String kechengyuyueList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kechengyuyue kechengyuyue, String bianhao, String kechengmingcheng, String shangkeshijian, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(shangkeshijian==null||shangkeshijian.equals("")){pmap.put("shangkeshijian", null);}else{pmap.put("shangkeshijian", shangkeshijian);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=kechengyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kechengyuyue> list=kechengyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kechengyuyue_list";
	}
	
	@RequestMapping("kechengyuyueList2.do")
	public String kechengyuyueList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kechengyuyue kechengyuyue, String bianhao, String kechengmingcheng, String shangkeshijian, String yonghuming, String issh,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(shangkeshijian==null||shangkeshijian.equals("")){pmap.put("shangkeshijian", null);}else{pmap.put("shangkeshijian", shangkeshijian);}		
		
		int total=kechengyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kechengyuyue> list=kechengyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kechengyuyue_list2";
	}	
	
	@RequestMapping("kcyyList.do")
	public String kcyyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Kechengyuyue kechengyuyue, String bianhao, String kechengmingcheng, String shangkeshijian, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(shangkeshijian==null||shangkeshijian.equals("")){pmap.put("shangkeshijian", null);}else{pmap.put("shangkeshijian", shangkeshijian);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=kechengyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Kechengyuyue> list=kechengyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "kechengyuyuelist";
	}
	
	@RequestMapping("deleteKechengyuyue.do")
	public String deleteKechengyuyue(int id,HttpServletRequest request){
		kechengyuyueService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:kechengyuyueList.do";
	}
	
	
}
