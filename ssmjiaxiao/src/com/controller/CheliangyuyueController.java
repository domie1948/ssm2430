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

import com.entity.Cheliangyuyue;
import com.server.CheliangyuyueServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class CheliangyuyueController {
	@Resource
	private CheliangyuyueServer cheliangyuyueService;


   
	@RequestMapping("addCheliangyuyue.do")
	public String addCheliangyuyue(HttpServletRequest request,Cheliangyuyue cheliangyuyue,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		String sql="";
		sql="select id from cheliangyuyue where 1=1  and chepaihao='"+cheliangyuyue.getChepaihao()+"'";
		db dbo = new db();
		ResultSet rs=null;
		rs=dbo.executeQuery(sql);
		int tt=0;
		while(rs.next()){

				tt++;
		}

		if(tt>=4)
		{
			
			session.setAttribute("backxx", "已约满！操作失败");
			session.setAttribute("backurl", request.getHeader("Referer"));
			
			//session.setAttribute("backurl", "cheliangyuyueList.do");
			
			return "redirect:postback.jsp";
			//return "redirect:cheliangyuyueList.do";
		}
		cheliangyuyue.setAddtime(time.toString().substring(0, 19));
		cheliangyuyueService.add(cheliangyuyue);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "cheliangyuyueList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:cheliangyuyueList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateCheliangyuyue.do")
	public String doUpdateCheliangyuyue(int id,ModelMap map,Cheliangyuyue cheliangyuyue){
		cheliangyuyue=cheliangyuyueService.getById(id);
		map.put("cheliangyuyue", cheliangyuyue);
		return "cheliangyuyue_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("cheliangyuyueDetail.do")
	public String cheliangyuyueDetail(int id,ModelMap map,Cheliangyuyue cheliangyuyue){
		cheliangyuyue=cheliangyuyueService.getById(id);
		map.put("cheliangyuyue", cheliangyuyue);
		return "cheliangyuyue_detail";
	}
//	前台详细
	@RequestMapping("clyyDetail.do")
	public String clyyDetail(int id,ModelMap map,Cheliangyuyue cheliangyuyue){
		cheliangyuyue=cheliangyuyueService.getById(id);
		map.put("cheliangyuyue", cheliangyuyue);
		return "cheliangyuyuedetail";
	}
//	
	@RequestMapping("updateCheliangyuyue.do")
	public String updateCheliangyuyue(int id,ModelMap map,Cheliangyuyue cheliangyuyue,HttpServletRequest request,HttpSession session){
		cheliangyuyueService.update(cheliangyuyue);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:cheliangyuyueList.do";
	}

//	分页查询
	@RequestMapping("cheliangyuyueList.do")
	public String cheliangyuyueList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangyuyue cheliangyuyue, String chepaihao, String pinpaixinghao, String keyuyueshiduan, String yuyueriqi1,String yuyueriqi2, String yuyueren, String xingming, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}		if(pinpaixinghao==null||pinpaixinghao.equals("")){pmap.put("pinpaixinghao", null);}else{pmap.put("pinpaixinghao", pinpaixinghao);}		if(keyuyueshiduan==null||keyuyueshiduan.equals("")){pmap.put("keyuyueshiduan", null);}else{pmap.put("keyuyueshiduan", keyuyueshiduan);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		
		int total=cheliangyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangyuyue> list=cheliangyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangyuyue_list";
	}
	
	@RequestMapping("cheliangyuyueList2.do")
	public String cheliangyuyueList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangyuyue cheliangyuyue, String chepaihao, String pinpaixinghao, String keyuyueshiduan, String yuyueriqi1,String yuyueriqi2, String yuyueren, String xingming, String lianxidianhua, String issh,HttpServletRequest request){
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
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}		if(pinpaixinghao==null||pinpaixinghao.equals("")){pmap.put("pinpaixinghao", null);}else{pmap.put("pinpaixinghao", pinpaixinghao);}		if(keyuyueshiduan==null||keyuyueshiduan.equals("")){pmap.put("keyuyueshiduan", null);}else{pmap.put("keyuyueshiduan", keyuyueshiduan);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		
		
		int total=cheliangyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangyuyue> list=cheliangyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangyuyue_list2";
	}	
	
	@RequestMapping("clyyList.do")
	public String clyyList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Cheliangyuyue cheliangyuyue, String chepaihao, String pinpaixinghao, String keyuyueshiduan, String yuyueriqi1,String yuyueriqi2, String yuyueren, String xingming, String lianxidianhua, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(chepaihao==null||chepaihao.equals("")){pmap.put("chepaihao", null);}else{pmap.put("chepaihao", chepaihao);}		if(pinpaixinghao==null||pinpaixinghao.equals("")){pmap.put("pinpaixinghao", null);}else{pmap.put("pinpaixinghao", pinpaixinghao);}		if(keyuyueshiduan==null||keyuyueshiduan.equals("")){pmap.put("keyuyueshiduan", null);}else{pmap.put("keyuyueshiduan", keyuyueshiduan);}		if(yuyueriqi1==null||yuyueriqi1.equals("")){pmap.put("yuyueriqi1", null);}else{pmap.put("yuyueriqi1", yuyueriqi1);}		if(yuyueriqi2==null||yuyueriqi2.equals("")){pmap.put("yuyueriqi2", null);}else{pmap.put("yuyueriqi2", yuyueriqi2);}		if(yuyueren==null||yuyueren.equals("")){pmap.put("yuyueren", null);}else{pmap.put("yuyueren", yuyueren);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		
		int total=cheliangyuyueService.getCount(pmap);
		pageBean.setTotal(total);
		List<Cheliangyuyue> list=cheliangyuyueService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "cheliangyuyuelist";
	}
	
	@RequestMapping("deleteCheliangyuyue.do")
	public String deleteCheliangyuyue(int id,HttpServletRequest request){
		cheliangyuyueService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:cheliangyuyueList.do";
	}
	
	
}
