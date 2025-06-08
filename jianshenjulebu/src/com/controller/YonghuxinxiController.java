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

import com.entity.Yonghuxinxi;
import com.server.YonghuxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YonghuxinxiController {
	@Resource
	private YonghuxinxiServer yonghuxinxiService;


   
	@RequestMapping("addYonghuxinxi.do")
	public String addYonghuxinxi(HttpServletRequest request,Yonghuxinxi yonghuxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yonghuxinxi.setAddtime(time.toString().substring(0, 19));
		yonghuxinxiService.add(yonghuxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yonghuxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yonghuxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYonghuxinxi.do")
	public String doUpdateYonghuxinxi(int id,ModelMap map,Yonghuxinxi yonghuxinxi){
		yonghuxinxi=yonghuxinxiService.getById(id);
		map.put("yonghuxinxi", yonghuxinxi);
		return "yonghuxinxi_updt";
	}
	
	@RequestMapping("doUpdateYonghuxinxi2.do")
	public String doUpdateYonghuxinxi2(ModelMap map,Yonghuxinxi yonghuxinxi,HttpServletRequest request){
		yonghuxinxi=yonghuxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("yonghuxinxi", yonghuxinxi);
		return "yonghuxinxi_updt2";
	}
	
@RequestMapping("updateYonghuxinxi2.do")
	public String updateYonghuxinxi2(int id,ModelMap map,Yonghuxinxi yonghuxinxi){
		yonghuxinxiService.update(yonghuxinxi);
		return "redirect:doUpdateYonghuxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("yonghuxinxiDetail.do")
	public String yonghuxinxiDetail(int id,ModelMap map,Yonghuxinxi yonghuxinxi){
		yonghuxinxi=yonghuxinxiService.getById(id);
		map.put("yonghuxinxi", yonghuxinxi);
		return "yonghuxinxi_detail";
	}
//	前台详细
	@RequestMapping("yhxxDetail.do")
	public String yhxxDetail(int id,ModelMap map,Yonghuxinxi yonghuxinxi){
		yonghuxinxi=yonghuxinxiService.getById(id);
		map.put("yonghuxinxi", yonghuxinxi);
		return "yonghuxinxidetail";
	}
//	
	@RequestMapping("updateYonghuxinxi.do")
	public String updateYonghuxinxi(int id,ModelMap map,Yonghuxinxi yonghuxinxi,HttpServletRequest request,HttpSession session){
		yonghuxinxiService.update(yonghuxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yonghuxinxiList.do";
	}

//	分页查询
	@RequestMapping("yonghuxinxiList.do")
	public String yonghuxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghuxinxi yonghuxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonghuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghuxinxi> list=yonghuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghuxinxi_list";
	}
	
	
	
	@RequestMapping("yhxxList.do")
	public String yhxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yonghuxinxi yonghuxinxi, String yonghuming, String mima, String xingming, String xingbie, String dianhua, String dizhi){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		int total=yonghuxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yonghuxinxi> list=yonghuxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yonghuxinxilist";
	}
	
	@RequestMapping("deleteYonghuxinxi.do")
	public String deleteYonghuxinxi(int id,HttpServletRequest request){
		yonghuxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yonghuxinxiList.do";
	}
	
	@RequestMapping("quchongYonghuxinxi.do")
	public void quchongYonghuxinxi(Yonghuxinxi yonghuxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", yonghuxinxi.getYonghuming());
		   System.out.println("yonghuming==="+yonghuxinxi.getYonghuming());
		   System.out.println("yonghuming222==="+yonghuxinxiService.quchongYonghuxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(yonghuxinxiService.quchongYonghuxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
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
