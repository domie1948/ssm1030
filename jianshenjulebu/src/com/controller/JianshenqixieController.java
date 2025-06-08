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

import com.entity.Jianshenqixie;
import com.server.JianshenqixieServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JianshenqixieController {
	@Resource
	private JianshenqixieServer jianshenqixieService;


   
	@RequestMapping("addJianshenqixie.do")
	public String addJianshenqixie(HttpServletRequest request,Jianshenqixie jianshenqixie,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jianshenqixie.setAddtime(time.toString().substring(0, 19));
		jianshenqixieService.add(jianshenqixie);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jianshenqixieList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jianshenqixieList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJianshenqixie.do")
	public String doUpdateJianshenqixie(int id,ModelMap map,Jianshenqixie jianshenqixie){
		jianshenqixie=jianshenqixieService.getById(id);
		map.put("jianshenqixie", jianshenqixie);
		return "jianshenqixie_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jianshenqixieDetail.do")
	public String jianshenqixieDetail(int id,ModelMap map,Jianshenqixie jianshenqixie){
		jianshenqixie=jianshenqixieService.getById(id);
		map.put("jianshenqixie", jianshenqixie);
		return "jianshenqixie_detail";
	}
//	前台详细
	@RequestMapping("jsqxDetail.do")
	public String jsqxDetail(int id,ModelMap map,Jianshenqixie jianshenqixie){
		jianshenqixie=jianshenqixieService.getById(id);
		map.put("jianshenqixie", jianshenqixie);
		return "jianshenqixiedetail";
	}
//	
	@RequestMapping("updateJianshenqixie.do")
	public String updateJianshenqixie(int id,ModelMap map,Jianshenqixie jianshenqixie,HttpServletRequest request,HttpSession session){
		jianshenqixieService.update(jianshenqixie);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jianshenqixieList.do";
	}

//	分页查询
	@RequestMapping("jianshenqixieList.do")
	public String jianshenqixieList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianshenqixie jianshenqixie, String bianhao, String qixiemingcheng, String shijianduan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(qixiemingcheng==null||qixiemingcheng.equals("")){pmap.put("qixiemingcheng", null);}else{pmap.put("qixiemingcheng", qixiemingcheng);}		if(shijianduan==null||shijianduan.equals("")){pmap.put("shijianduan", null);}else{pmap.put("shijianduan", shijianduan);}		
		int total=jianshenqixieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianshenqixie> list=jianshenqixieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianshenqixie_list";
	}
	
	
	
	@RequestMapping("jsqxList.do")
	public String jsqxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianshenqixie jianshenqixie, String bianhao, String qixiemingcheng, String shijianduan){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(qixiemingcheng==null||qixiemingcheng.equals("")){pmap.put("qixiemingcheng", null);}else{pmap.put("qixiemingcheng", qixiemingcheng);}		if(shijianduan==null||shijianduan.equals("")){pmap.put("shijianduan", null);}else{pmap.put("shijianduan", shijianduan);}		
		int total=jianshenqixieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianshenqixie> list=jianshenqixieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianshenqixielist";
	}
	
	@RequestMapping("deleteJianshenqixie.do")
	public String deleteJianshenqixie(int id,HttpServletRequest request){
		jianshenqixieService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jianshenqixieList.do";
	}
	
	@RequestMapping("quchongJianshenqixie.do")
	public void quchongJianshenqixie(Jianshenqixie jianshenqixie,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", jianshenqixie.getBianhao());
		   System.out.println("bianhao==="+jianshenqixie.getBianhao());
		   System.out.println("bianhao222==="+jianshenqixieService.quchongJianshenqixie(map));
		   JSONObject obj=new JSONObject();
		   if(jianshenqixieService.quchongJianshenqixie(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "编号可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
