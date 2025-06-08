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

import com.entity.Jianshenjiaolian;
import com.server.JianshenjiaolianServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JianshenjiaolianController {
	@Resource
	private JianshenjiaolianServer jianshenjiaolianService;


   
	@RequestMapping("addJianshenjiaolian.do")
	public String addJianshenjiaolian(HttpServletRequest request,Jianshenjiaolian jianshenjiaolian,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jianshenjiaolian.setAddtime(time.toString().substring(0, 19));
		jianshenjiaolianService.add(jianshenjiaolian);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jianshenjiaolianList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jianshenjiaolianList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJianshenjiaolian.do")
	public String doUpdateJianshenjiaolian(int id,ModelMap map,Jianshenjiaolian jianshenjiaolian){
		jianshenjiaolian=jianshenjiaolianService.getById(id);
		map.put("jianshenjiaolian", jianshenjiaolian);
		return "jianshenjiaolian_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jianshenjiaolianDetail.do")
	public String jianshenjiaolianDetail(int id,ModelMap map,Jianshenjiaolian jianshenjiaolian){
		jianshenjiaolian=jianshenjiaolianService.getById(id);
		map.put("jianshenjiaolian", jianshenjiaolian);
		return "jianshenjiaolian_detail";
	}
//	前台详细
	@RequestMapping("jsjlDetail.do")
	public String jsjlDetail(int id,ModelMap map,Jianshenjiaolian jianshenjiaolian){
		jianshenjiaolian=jianshenjiaolianService.getById(id);
		map.put("jianshenjiaolian", jianshenjiaolian);
		return "jianshenjiaoliandetail";
	}
//	
	@RequestMapping("updateJianshenjiaolian.do")
	public String updateJianshenjiaolian(int id,ModelMap map,Jianshenjiaolian jianshenjiaolian,HttpServletRequest request,HttpSession session){
		jianshenjiaolianService.update(jianshenjiaolian);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jianshenjiaolianList.do";
	}

//	分页查询
	@RequestMapping("jianshenjiaolianList.do")
	public String jianshenjiaolianList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianshenjiaolian jianshenjiaolian, String jiaolianbianhao, String jiaolianxingming, String xingbie, String zhuanchang, String zhaopian, String dianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiaolianbianhao==null||jiaolianbianhao.equals("")){pmap.put("jiaolianbianhao", null);}else{pmap.put("jiaolianbianhao", jiaolianbianhao);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhuanchang==null||zhuanchang.equals("")){pmap.put("zhuanchang", null);}else{pmap.put("zhuanchang", zhuanchang);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=jianshenjiaolianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianshenjiaolian> list=jianshenjiaolianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianshenjiaolian_list";
	}
	
	
	
	@RequestMapping("jsjlList.do")
	public String jsjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jianshenjiaolian jianshenjiaolian, String jiaolianbianhao, String jiaolianxingming, String xingbie, String zhuanchang, String zhaopian, String dianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(jiaolianbianhao==null||jiaolianbianhao.equals("")){pmap.put("jiaolianbianhao", null);}else{pmap.put("jiaolianbianhao", jiaolianbianhao);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhuanchang==null||zhuanchang.equals("")){pmap.put("zhuanchang", null);}else{pmap.put("zhuanchang", zhuanchang);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=jianshenjiaolianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jianshenjiaolian> list=jianshenjiaolianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jianshenjiaolianlist";
	}
	
	@RequestMapping("deleteJianshenjiaolian.do")
	public String deleteJianshenjiaolian(int id,HttpServletRequest request){
		jianshenjiaolianService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jianshenjiaolianList.do";
	}
	
	@RequestMapping("quchongJianshenjiaolian.do")
	public void quchongJianshenjiaolian(Jianshenjiaolian jianshenjiaolian,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("jiaolianbianhao", jianshenjiaolian.getJiaolianbianhao());
		   System.out.println("jiaolianbianhao==="+jianshenjiaolian.getJiaolianbianhao());
		   System.out.println("jiaolianbianhao222==="+jianshenjiaolianService.quchongJianshenjiaolian(map));
		   JSONObject obj=new JSONObject();
		   if(jianshenjiaolianService.quchongJianshenjiaolian(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "教练编号可以用！");
				  
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
