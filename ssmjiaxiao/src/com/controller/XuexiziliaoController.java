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

import com.entity.Xuexiziliao;
import com.server.XuexiziliaoServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class XuexiziliaoController {
	@Resource
	private XuexiziliaoServer xuexiziliaoService;


   
	@RequestMapping("addXuexiziliao.do")
	public String addXuexiziliao(HttpServletRequest request,Xuexiziliao xuexiziliao,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		xuexiziliao.setAddtime(time.toString().substring(0, 19));
		xuexiziliaoService.add(xuexiziliao);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "xuexiziliaoList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:xuexiziliaoList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateXuexiziliao.do")
	public String doUpdateXuexiziliao(int id,ModelMap map,Xuexiziliao xuexiziliao){
		xuexiziliao=xuexiziliaoService.getById(id);
		map.put("xuexiziliao", xuexiziliao);
		return "xuexiziliao_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("xuexiziliaoDetail.do")
	public String xuexiziliaoDetail(int id,ModelMap map,Xuexiziliao xuexiziliao){
		xuexiziliao=xuexiziliaoService.getById(id);
		map.put("xuexiziliao", xuexiziliao);
		return "xuexiziliao_detail";
	}
//	前台详细
	@RequestMapping("xxzlDetail.do")
	public String xxzlDetail(int id,ModelMap map,Xuexiziliao xuexiziliao){
		xuexiziliao=xuexiziliaoService.getById(id);
		map.put("xuexiziliao", xuexiziliao);
		return "xuexiziliaodetail";
	}
//	
	@RequestMapping("updateXuexiziliao.do")
	public String updateXuexiziliao(int id,ModelMap map,Xuexiziliao xuexiziliao,HttpServletRequest request,HttpSession session){
		xuexiziliaoService.update(xuexiziliao);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:xuexiziliaoList.do";
	}

//	分页查询
	@RequestMapping("xuexiziliaoList.do")
	public String xuexiziliaoList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuexiziliao xuexiziliao, String ziliaomingcheng, String shumian, String shipin, String wenjian, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(ziliaomingcheng==null||ziliaomingcheng.equals("")){pmap.put("ziliaomingcheng", null);}else{pmap.put("ziliaomingcheng", ziliaomingcheng);}		if(shumian==null||shumian.equals("")){pmap.put("shumian", null);}else{pmap.put("shumian", shumian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=xuexiziliaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuexiziliao> list=xuexiziliaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuexiziliao_list";
	}
	
	
	
	@RequestMapping("xxzlList.do")
	public String xxzlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Xuexiziliao xuexiziliao, String ziliaomingcheng, String shumian, String shipin, String wenjian, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(ziliaomingcheng==null||ziliaomingcheng.equals("")){pmap.put("ziliaomingcheng", null);}else{pmap.put("ziliaomingcheng", ziliaomingcheng);}		if(shumian==null||shumian.equals("")){pmap.put("shumian", null);}else{pmap.put("shumian", shumian);}		if(shipin==null||shipin.equals("")){pmap.put("shipin", null);}else{pmap.put("shipin", shipin);}		if(wenjian==null||wenjian.equals("")){pmap.put("wenjian", null);}else{pmap.put("wenjian", wenjian);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=xuexiziliaoService.getCount(pmap);
		pageBean.setTotal(total);
		List<Xuexiziliao> list=xuexiziliaoService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "xuexiziliaolist";
	}
	
	@RequestMapping("deleteXuexiziliao.do")
	public String deleteXuexiziliao(int id,HttpServletRequest request){
		xuexiziliaoService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:xuexiziliaoList.do";
	}
	
	
}
