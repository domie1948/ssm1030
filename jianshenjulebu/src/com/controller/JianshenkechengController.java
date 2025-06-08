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

import com.entity.Jianshenkecheng;
import com.server.JianshenkechengServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JianshenkechengController {
	@Resource
	private JianshenkechengServer jianshenkechengService;


   
	@RequestMapping("addJianshenkecheng.do")
	public String addJianshenkecheng(HttpServletRequest request,Jianshenkecheng jianshenkecheng,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jianshenkecheng.setAddtime(time.toString().substring(0, 19));
		jianshenkechengService.add(jianshenkecheng);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jianshenkechengList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jianshenkechengList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJianshenkecheng.do")
	public String doUpdateJianshenkecheng(int id,ModelMap map,Jianshenkecheng jianshenkecheng){
		jianshenkecheng=jianshenkechengService.getById(id);
		map.put("jianshenkecheng", jianshenkecheng);
		return "jianshenkecheng_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jianshenkechengDetail.do")
	public String jianshenkechengDetail(int id,ModelMap map,Jianshenkecheng jianshenkecheng){
		jianshenkecheng=jianshenkechengService.getById(id);
		map.put("jianshenkecheng", jianshenkecheng);
		return "jianshenkecheng_detail";
	}
//	前台详细
	@RequestMapping("jskcDetail.do")
	public String jskcDetail(int id,ModelMap map,Jianshenkecheng jianshenkecheng){
		jianshenkecheng=jianshenkechengService.getById(id);
		map.put("jianshenkecheng", jianshenkecheng);
		return "jianshenkechengdetail";
	}
//	
	@RequestMapping("updateJianshenkecheng.do")
	public String updateJianshenkecheng(int id,ModelMap map,Jianshenkecheng jianshenkecheng,HttpServletRequest request,HttpSession session){
		jianshenkechengService.update(jianshenkecheng);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jianshenkechengList.do";
	}

//	分页查询
	@RequestMapping("jianshenkechengList.do")
	public String jianshenkechengList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianshenkecheng jianshenkecheng, String bianhao, String kechengmingcheng, String shangkeshijian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(shangkeshijian==null||shangkeshijian.equals("")){pmap.put("shangkeshijian", null);}else{pmap.put("shangkeshijian", shangkeshijian);}		
		int total=jianshenkechengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianshenkecheng> list=jianshenkechengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianshenkecheng_list";
	}
	
	
	
	@RequestMapping("jskcList.do")
	public String jskcList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianshenkecheng jianshenkecheng, String bianhao, String kechengmingcheng, String shangkeshijian){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(kechengmingcheng==null||kechengmingcheng.equals("")){pmap.put("kechengmingcheng", null);}else{pmap.put("kechengmingcheng", kechengmingcheng);}		if(shangkeshijian==null||shangkeshijian.equals("")){pmap.put("shangkeshijian", null);}else{pmap.put("shangkeshijian", shangkeshijian);}		
		int total=jianshenkechengService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianshenkecheng> list=jianshenkechengService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianshenkechenglist";
	}
	
	@RequestMapping("deleteJianshenkecheng.do")
	public String deleteJianshenkecheng(int id,HttpServletRequest request){
		jianshenkechengService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jianshenkechengList.do";
	}
	
	@RequestMapping("quchongJianshenkecheng.do")
	public void quchongJianshenkecheng(Jianshenkecheng jianshenkecheng,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("bianhao", jianshenkecheng.getBianhao());
		   System.out.println("bianhao==="+jianshenkecheng.getBianhao());
		   System.out.println("bianhao222==="+jianshenkechengService.quchongJianshenkecheng(map));
		   JSONObject obj=new JSONObject();
		   if(jianshenkechengService.quchongJianshenkecheng(map)!=null){
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
