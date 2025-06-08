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

import com.entity.Qixieyuyue;
import com.server.QixieyuyueServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QixieyuyueController {
	@Resource
	private QixieyuyueServer qixieyuyueService;


   
	@RequestMapping("addQixieyuyue.do")
	public String addQixieyuyue(HttpServletRequest request,Qixieyuyue qixieyuyue,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qixieyuyue.setAddtime(time.toString().substring(0, 19));
		qixieyuyueService.add(qixieyuyue);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qixieyuyueList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qixieyuyueList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQixieyuyue.do")
	public String doUpdateQixieyuyue(int id,ModelMap map,Qixieyuyue qixieyuyue){
		qixieyuyue=qixieyuyueService.getById(id);
		map.put("qixieyuyue", qixieyuyue);
		return "qixieyuyue_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("qixieyuyueDetail.do")
	public String qixieyuyueDetail(int id,ModelMap map,Qixieyuyue qixieyuyue){
		qixieyuyue=qixieyuyueService.getById(id);
		map.put("qixieyuyue", qixieyuyue);
		return "qixieyuyue_detail";
	}
//	前台详细
	@RequestMapping("qxyyDetail.do")
	public String qxyyDetail(int id,ModelMap map,Qixieyuyue qixieyuyue){
		qixieyuyue=qixieyuyueService.getById(id);
		map.put("qixieyuyue", qixieyuyue);
		return "qixieyuyuedetail";
	}
//	
	@RequestMapping("updateQixieyuyue.do")
	public String updateQixieyuyue(int id,ModelMap map,Qixieyuyue qixieyuyue,HttpServletRequest request,HttpSession session){
		qixieyuyueService.update(qixieyuyue);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qixieyuyueList.do";
	}

//	分页查询
	@RequestMapping("qixieyuyueList.do")
	public String qixieyuyueList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qixieyuyue qixieyuyue, String bianhao, String qixiemingcheng, String shijianduan, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(qixiemingcheng==null||qixiemingcheng.equals("")){pmap.put("qixiemingcheng", null);}else{pmap.put("qixiemingcheng", qixiemingcheng);}		if(shijianduan==null||shijianduan.equals("")){pmap.put("shijianduan", null);}else{pmap.put("shijianduan", shijianduan);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=qixieyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qixieyuyue> list=qixieyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qixieyuyue_list";
	}
	
	@RequestMapping("qixieyuyueList2.do")
	public String qixieyuyueList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qixieyuyue qixieyuyue, String bianhao, String qixiemingcheng, String shijianduan, String yonghuming, String issh,HttpServletRequest request){
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
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(qixiemingcheng==null||qixiemingcheng.equals("")){pmap.put("qixiemingcheng", null);}else{pmap.put("qixiemingcheng", qixiemingcheng);}		if(shijianduan==null||shijianduan.equals("")){pmap.put("shijianduan", null);}else{pmap.put("shijianduan", shijianduan);}		
		
		int total=qixieyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qixieyuyue> list=qixieyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qixieyuyue_list2";
	}	
	
	@RequestMapping("qxyyList.do")
	public String qxyyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qixieyuyue qixieyuyue, String bianhao, String qixiemingcheng, String shijianduan, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(qixiemingcheng==null||qixiemingcheng.equals("")){pmap.put("qixiemingcheng", null);}else{pmap.put("qixiemingcheng", qixiemingcheng);}		if(shijianduan==null||shijianduan.equals("")){pmap.put("shijianduan", null);}else{pmap.put("shijianduan", shijianduan);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=qixieyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qixieyuyue> list=qixieyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qixieyuyuelist";
	}
	
	@RequestMapping("deleteQixieyuyue.do")
	public String deleteQixieyuyue(int id,HttpServletRequest request){
		qixieyuyueService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qixieyuyueList.do";
	}
	
	
}
