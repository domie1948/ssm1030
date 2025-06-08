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

import com.entity.Jiaolianyuyue;
import com.server.JiaolianyuyueServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiaolianyuyueController {
	@Resource
	private JiaolianyuyueServer jiaolianyuyueService;


   
	@RequestMapping("addJiaolianyuyue.do")
	public String addJiaolianyuyue(HttpServletRequest request,Jiaolianyuyue jiaolianyuyue,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiaolianyuyue.setAddtime(time.toString().substring(0, 19));
		jiaolianyuyueService.add(jiaolianyuyue);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiaolianyuyueList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiaolianyuyueList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiaolianyuyue.do")
	public String doUpdateJiaolianyuyue(int id,ModelMap map,Jiaolianyuyue jiaolianyuyue){
		jiaolianyuyue=jiaolianyuyueService.getById(id);
		map.put("jiaolianyuyue", jiaolianyuyue);
		return "jiaolianyuyue_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("jiaolianyuyueDetail.do")
	public String jiaolianyuyueDetail(int id,ModelMap map,Jiaolianyuyue jiaolianyuyue){
		jiaolianyuyue=jiaolianyuyueService.getById(id);
		map.put("jiaolianyuyue", jiaolianyuyue);
		return "jiaolianyuyue_detail";
	}
//	前台详细
	@RequestMapping("jlyyDetail.do")
	public String jlyyDetail(int id,ModelMap map,Jiaolianyuyue jiaolianyuyue){
		jiaolianyuyue=jiaolianyuyueService.getById(id);
		map.put("jiaolianyuyue", jiaolianyuyue);
		return "jiaolianyuyuedetail";
	}
//	
	@RequestMapping("updateJiaolianyuyue.do")
	public String updateJiaolianyuyue(int id,ModelMap map,Jiaolianyuyue jiaolianyuyue,HttpServletRequest request,HttpSession session){
		jiaolianyuyueService.update(jiaolianyuyue);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiaolianyuyueList.do";
	}

//	分页查询
	@RequestMapping("jiaolianyuyueList.do")
	public String jiaolianyuyueList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaolianyuyue jiaolianyuyue, String jiaolianbianhao, String jiaolianxingming, String xingbie, String zhuanchang, String dianhua, String dizhi, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiaolianbianhao==null||jiaolianbianhao.equals("")){pmap.put("jiaolianbianhao", null);}else{pmap.put("jiaolianbianhao", jiaolianbianhao);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhuanchang==null||zhuanchang.equals("")){pmap.put("zhuanchang", null);}else{pmap.put("zhuanchang", zhuanchang);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=jiaolianyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaolianyuyue> list=jiaolianyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaolianyuyue_list";
	}
	
	@RequestMapping("jiaolianyuyueList2.do")
	public String jiaolianyuyueList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaolianyuyue jiaolianyuyue, String jiaolianbianhao, String jiaolianxingming, String xingbie, String zhuanchang, String dianhua, String dizhi, String yonghuming, String issh,HttpServletRequest request){
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
		if(jiaolianbianhao==null||jiaolianbianhao.equals("")){pmap.put("jiaolianbianhao", null);}else{pmap.put("jiaolianbianhao", jiaolianbianhao);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhuanchang==null||zhuanchang.equals("")){pmap.put("zhuanchang", null);}else{pmap.put("zhuanchang", zhuanchang);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		
		
		int total=jiaolianyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaolianyuyue> list=jiaolianyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaolianyuyue_list2";
	}	
	
	@RequestMapping("jlyyList.do")
	public String jlyyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaolianyuyue jiaolianyuyue, String jiaolianbianhao, String jiaolianxingming, String xingbie, String zhuanchang, String dianhua, String dizhi, String yonghuming, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(jiaolianbianhao==null||jiaolianbianhao.equals("")){pmap.put("jiaolianbianhao", null);}else{pmap.put("jiaolianbianhao", jiaolianbianhao);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhuanchang==null||zhuanchang.equals("")){pmap.put("zhuanchang", null);}else{pmap.put("zhuanchang", zhuanchang);}		if(dianhua==null||dianhua.equals("")){pmap.put("dianhua", null);}else{pmap.put("dianhua", dianhua);}		if(dizhi==null||dizhi.equals("")){pmap.put("dizhi", null);}else{pmap.put("dizhi", dizhi);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=jiaolianyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaolianyuyue> list=jiaolianyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaolianyuyuelist";
	}
	
	@RequestMapping("deleteJiaolianyuyue.do")
	public String deleteJiaolianyuyue(int id,HttpServletRequest request){
		jiaolianyuyueService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiaolianyuyueList.do";
	}
	
	
}
