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

import com.entity.Jiaolianxinxi;
import com.server.JiaolianxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class JiaolianxinxiController {
	@Resource
	private JiaolianxinxiServer jiaolianxinxiService;


   
	@RequestMapping("addJiaolianxinxi.do")
	public String addJiaolianxinxi(HttpServletRequest request,Jiaolianxinxi jiaolianxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		jiaolianxinxi.setAddtime(time.toString().substring(0, 19));
		jiaolianxinxiService.add(jiaolianxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "jiaolianxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:jiaolianxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateJiaolianxinxi.do")
	public String doUpdateJiaolianxinxi(int id,ModelMap map,Jiaolianxinxi jiaolianxinxi){
		jiaolianxinxi=jiaolianxinxiService.getById(id);
		map.put("jiaolianxinxi", jiaolianxinxi);
		return "jiaolianxinxi_updt";
	}
	
	@RequestMapping("doUpdateJiaolianxinxi2.do")
	public String doUpdateJiaolianxinxi2(ModelMap map,Jiaolianxinxi jiaolianxinxi,HttpServletRequest request){
		jiaolianxinxi=jiaolianxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("jiaolianxinxi", jiaolianxinxi);
		return "jiaolianxinxi_updt2";
	}
	
@RequestMapping("updateJiaolianxinxi2.do")
	public String updateJiaolianxinxi2(int id,ModelMap map,Jiaolianxinxi jiaolianxinxi){
		jiaolianxinxiService.update(jiaolianxinxi);
		return "redirect:doUpdateJiaolianxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("jiaolianxinxiDetail.do")
	public String jiaolianxinxiDetail(int id,ModelMap map,Jiaolianxinxi jiaolianxinxi){
		jiaolianxinxi=jiaolianxinxiService.getById(id);
		map.put("jiaolianxinxi", jiaolianxinxi);
		return "jiaolianxinxi_detail";
	}
//	前台详细
	@RequestMapping("jlxxDetail.do")
	public String jlxxDetail(int id,ModelMap map,Jiaolianxinxi jiaolianxinxi){
		jiaolianxinxi=jiaolianxinxiService.getById(id);
		map.put("jiaolianxinxi", jiaolianxinxi);
		return "jiaolianxinxidetail";
	}
//	
	@RequestMapping("updateJiaolianxinxi.do")
	public String updateJiaolianxinxi(int id,ModelMap map,Jiaolianxinxi jiaolianxinxi,HttpServletRequest request,HttpSession session){
		jiaolianxinxiService.update(jiaolianxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:jiaolianxinxiList.do";
	}

//	分页查询
	@RequestMapping("jiaolianxinxiList.do")
	public String jiaolianxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaolianxinxi jiaolianxinxi, String gonghao, String mima, String jiaolianxingming, String xingbie, String zhaopian, String chushengriqi1,String chushengriqi2, String jiaoling, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(chushengriqi1==null||chushengriqi1.equals("")){pmap.put("chushengriqi1", null);}else{pmap.put("chushengriqi1", chushengriqi1);}		if(chushengriqi2==null||chushengriqi2.equals("")){pmap.put("chushengriqi2", null);}else{pmap.put("chushengriqi2", chushengriqi2);}		if(jiaoling==null||jiaoling.equals("")){pmap.put("jiaoling", null);}else{pmap.put("jiaoling", jiaoling);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=jiaolianxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaolianxinxi> list=jiaolianxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaolianxinxi_list";
	}
	
	
	
	@RequestMapping("jlxxList.do")
	public String jlxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Jiaolianxinxi jiaolianxinxi, String gonghao, String mima, String jiaolianxingming, String xingbie, String zhaopian, String chushengriqi1,String chushengriqi2, String jiaoling, String jianjie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(gonghao==null||gonghao.equals("")){pmap.put("gonghao", null);}else{pmap.put("gonghao", gonghao);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(jiaolianxingming==null||jiaolianxingming.equals("")){pmap.put("jiaolianxingming", null);}else{pmap.put("jiaolianxingming", jiaolianxingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(zhaopian==null||zhaopian.equals("")){pmap.put("zhaopian", null);}else{pmap.put("zhaopian", zhaopian);}		if(chushengriqi1==null||chushengriqi1.equals("")){pmap.put("chushengriqi1", null);}else{pmap.put("chushengriqi1", chushengriqi1);}		if(chushengriqi2==null||chushengriqi2.equals("")){pmap.put("chushengriqi2", null);}else{pmap.put("chushengriqi2", chushengriqi2);}		if(jiaoling==null||jiaoling.equals("")){pmap.put("jiaoling", null);}else{pmap.put("jiaoling", jiaoling);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		
		int total=jiaolianxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Jiaolianxinxi> list=jiaolianxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "jiaolianxinxilist";
	}
	
	@RequestMapping("deleteJiaolianxinxi.do")
	public String deleteJiaolianxinxi(int id,HttpServletRequest request){
		jiaolianxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:jiaolianxinxiList.do";
	}
	
	@RequestMapping("quchongJiaolianxinxi.do")
	public void quchongJiaolianxinxi(Jiaolianxinxi jiaolianxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("gonghao", jiaolianxinxi.getGonghao());
		   System.out.println("gonghao==="+jiaolianxinxi.getGonghao());
		   System.out.println("gonghao222==="+jiaolianxinxiService.quchongJiaolianxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(jiaolianxinxiService.quchongJiaolianxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "工号可以用！");
				  
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
