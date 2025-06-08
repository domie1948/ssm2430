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

import com.entity.Baomingxinxi;
import com.server.BaomingxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class BaomingxinxiController {
	@Resource
	private BaomingxinxiServer baomingxinxiService;


   
	@RequestMapping("addBaomingxinxi.do")
	public String addBaomingxinxi(HttpServletRequest request,Baomingxinxi baomingxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		baomingxinxi.setAddtime(time.toString().substring(0, 19));
		baomingxinxiService.add(baomingxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "baomingxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:baomingxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateBaomingxinxi.do")
	public String doUpdateBaomingxinxi(int id,ModelMap map,Baomingxinxi baomingxinxi){
		baomingxinxi=baomingxinxiService.getById(id);
		map.put("baomingxinxi", baomingxinxi);
		return "baomingxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("baomingxinxiDetail.do")
	public String baomingxinxiDetail(int id,ModelMap map,Baomingxinxi baomingxinxi){
		baomingxinxi=baomingxinxiService.getById(id);
		map.put("baomingxinxi", baomingxinxi);
		return "baomingxinxi_detail";
	}
//	前台详细
	@RequestMapping("bmxxDetail.do")
	public String bmxxDetail(int id,ModelMap map,Baomingxinxi baomingxinxi){
		baomingxinxi=baomingxinxiService.getById(id);
		map.put("baomingxinxi", baomingxinxi);
		return "baomingxinxidetail";
	}
//	
	@RequestMapping("updateBaomingxinxi.do")
	public String updateBaomingxinxi(int id,ModelMap map,Baomingxinxi baomingxinxi,HttpServletRequest request,HttpSession session){
		baomingxinxiService.update(baomingxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:baomingxinxiList.do";
	}

//	分页查询
	@RequestMapping("baomingxinxiList.do")
	public String baomingxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baomingxinxi baomingxinxi, String gonghao, String jiaolianxingming, String xingbie, String yonghuming, String xueyuanxingming, String lianxidianhua, String shenfenzhenghao, String issh){
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
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzhenghao==null||shenfenzhenghao.equals("")){pmap.put("shenfenzhenghao", null);}else{pmap.put("shenfenzhenghao", shenfenzhenghao);}
		
		int total=baomingxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baomingxinxi> list=baomingxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baomingxinxi_list";
	}
	
	@RequestMapping("baomingxinxiList2.do")
	public String baomingxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baomingxinxi baomingxinxi, String gonghao, String jiaolianxingming, String xingbie, String yonghuming, String xueyuanxingming, String lianxidianhua, String shenfenzhenghao, String issh,HttpServletRequest request){
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
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}
		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}
		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzhenghao==null||shenfenzhenghao.equals("")){pmap.put("shenfenzhenghao", null);}else{pmap.put("shenfenzhenghao", shenfenzhenghao);}
		
		
		int total=baomingxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baomingxinxi> list=baomingxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baomingxinxi_list2";
	}
	
	
	@RequestMapping("baomingxinxiList3.do")
	public String baomingxinxiList3(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baomingxinxi baomingxinxi, String gonghao, String jiaolianxingming, String xingbie, String yonghuming, String xueyuanxingming, String lianxidianhua, String shenfenzhenghao, String issh,HttpServletRequest request){
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
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzhenghao==null||shenfenzhenghao.equals("")){pmap.put("shenfenzhenghao", null);}else{pmap.put("shenfenzhenghao", shenfenzhenghao);}
		
		
		int total=baomingxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baomingxinxi> list=baomingxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baomingxinxi_list3";
	}
	
	
	@RequestMapping("bmxxList.do")
	public String bmxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Baomingxinxi baomingxinxi, String gonghao, String jiaolianxingming, String xingbie, String yonghuming, String xueyuanxingming, String lianxidianhua, String shenfenzhenghao, String issh){
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
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}
		if(xueyuanxingming==null||xueyuanxingming.equals("")){pmap.put("xueyuanxingming", null);}else{pmap.put("xueyuanxingming", xueyuanxingming);}
		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}
		if(shenfenzhenghao==null||shenfenzhenghao.equals("")){pmap.put("shenfenzhenghao", null);}else{pmap.put("shenfenzhenghao", shenfenzhenghao);}
		
		int total=baomingxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Baomingxinxi> list=baomingxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "baomingxinxilist";
	}
	
	@RequestMapping("deleteBaomingxinxi.do")
	public String deleteBaomingxinxi(int id,HttpServletRequest request){
		baomingxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:baomingxinxiList.do";
	}
	
	
}
