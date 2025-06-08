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

import com.entity.Yuyuejiaolian;
import com.server.YuyuejiaolianServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class YuyuejiaolianController {
	@Resource
	private YuyuejiaolianServer yuyuejiaolianService;


   
	@RequestMapping("addYuyuejiaolian.do")
	public String addYuyuejiaolian(HttpServletRequest request,Yuyuejiaolian yuyuejiaolian,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		yuyuejiaolian.setAddtime(time.toString().substring(0, 19));
		yuyuejiaolianService.add(yuyuejiaolian);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "yuyuejiaolianList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:yuyuejiaolianList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateYuyuejiaolian.do")
	public String doUpdateYuyuejiaolian(int id,ModelMap map,Yuyuejiaolian yuyuejiaolian){
		yuyuejiaolian=yuyuejiaolianService.getById(id);
		map.put("yuyuejiaolian", yuyuejiaolian);
		return "yuyuejiaolian_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("yuyuejiaolianDetail.do")
	public String yuyuejiaolianDetail(int id,ModelMap map,Yuyuejiaolian yuyuejiaolian){
		yuyuejiaolian=yuyuejiaolianService.getById(id);
		map.put("yuyuejiaolian", yuyuejiaolian);
		return "yuyuejiaolian_detail";
	}
//	前台详细
	@RequestMapping("yyjlDetail.do")
	public String yyjlDetail(int id,ModelMap map,Yuyuejiaolian yuyuejiaolian){
		yuyuejiaolian=yuyuejiaolianService.getById(id);
		map.put("yuyuejiaolian", yuyuejiaolian);
		return "yuyuejiaoliandetail";
	}
//	
	@RequestMapping("updateYuyuejiaolian.do")
	public String updateYuyuejiaolian(int id,ModelMap map,Yuyuejiaolian yuyuejiaolian,HttpServletRequest request,HttpSession session){
		yuyuejiaolianService.update(yuyuejiaolian);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:yuyuejiaolianList.do";
	}

//	分页查询
	@RequestMapping("yuyuejiaolianList.do")
	public String yuyuejiaolianList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejiaolian yuyuejiaolian, String gonghao, String jiaolianxingming, String xingbie, String yuyueren, String yuyueriqi1,String yuyueriqi2, String xueyuanxingming, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}
		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}
		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=yuyuejiaolianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejiaolian> list=yuyuejiaolianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejiaolian_list";
	}
	
	@RequestMapping("yuyuejiaolianList2.do")
	public String yuyuejiaolianList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejiaolian yuyuejiaolian, String gonghao, String jiaolianxingming, String xingbie, String yuyueren, String yuyueriqi1,String yuyueriqi2, String xueyuanxingming, String lianxidianhua, String issh,HttpServletRequest request){
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
		
		pmap.put("yuyueren", (String)request.getSession().getAttribute("username"));
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}
		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		
		int total=yuyuejiaolianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejiaolian> list=yuyuejiaolianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejiaolian_list2";
	}
	
	
	@RequestMapping("yuyuejiaolianList3.do")
	public String yuyuejiaolianList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejiaolian yuyuejiaolian, String gonghao, String jiaolianxingming, String xingbie, String yuyueren, String yuyueriqi1,String yuyueriqi2, String xueyuanxingming, String lianxidianhua, String issh,HttpServletRequest request){
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
		
		pmap.put("gonghao", (String)request.getSession().getAttribute("username"));
		//if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}
		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		
		int total=yuyuejiaolianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejiaolian> list=yuyuejiaolianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejiaolian_list3";
	}
	
	
	@RequestMapping("yyjlList.do")
	public String yyjlList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Yuyuejiaolian yuyuejiaolian, String gonghao, String jiaolianxingming, String xingbie, String yuyueren, String yuyueriqi1,String yuyueriqi2, String xueyuanxingming, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}
		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}
		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		
		int total=yuyuejiaolianService.getCount(pmap);
		pageBean.setTotal(total);
		List<Yuyuejiaolian> list=yuyuejiaolianService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "yuyuejiaolianlist";
	}
	
	@RequestMapping("deleteYuyuejiaolian.do")
	public String deleteYuyuejiaolian(int id,HttpServletRequest request){
		yuyuejiaolianService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:yuyuejiaolianList.do";
	}
	
	
}
