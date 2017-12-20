package com.smbms.controller;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entity.User;


@Controller
public class UserController {
	
		public static Logger logger=Logger.getLogger(UserController.class);
		
		@RequestMapping("/toIndex.do")
		public ModelAndView show(){
			logger.info("Spring mvc");
			return new ModelAndView("index");
		}
		
		@RequestMapping("/toIndex1.do")
		public ModelAndView welcome(@RequestParam(value="name",required=false) String name){
			logger.info("Spring mvc" + name);
			return new ModelAndView("index","num",name);
		}
		
		@RequestMapping("/toIndex12.do")
		public ModelAndView show(String name){
			logger.info("Spring mvc" + name);
			return new ModelAndView("index","num",name);
		}
		
		@RequestMapping("/save.do")
		public ModelAndView save(){
			return new ModelAndView("reg");
		}
		
		@RequestMapping("/save1.do")
		public ModelAndView save1(@Valid User user,BindingResult rs){
		ModelAndView mv = new ModelAndView();
			if(rs.hasErrors()){
				mv.addObject("user",user);
				mv.addObject("msg", "信息不合法重新注册");
				mv.setViewName("reg");
				return mv;
			}else{
				mv.addObject("user",user);
				mv.setViewName("reg");
				return mv;
			}
			
		}
		
		
		@RequestMapping("/Springsave.do")
		public ModelAndView Springsave(@ModelAttribute(value="user") User user){
			return new ModelAndView("SpringReg");
		}
		
		@RequestMapping("/save2.do")
		public ModelAndView save2(@Valid User user,BindingResult rs){
			ModelAndView mv = new ModelAndView();
				if(rs.hasErrors()){
					mv.addObject("user",user);
					mv.addObject("msg", "信息不合法重新注册");
					mv.setViewName("SpringReg");
					return mv;
				}else{
					mv.addObject("user",user);
					mv.setViewName("index");
					return mv;
				}				
			}
		//上传
		@RequestMapping("/file.do")
		public ModelAndView file(){
			return new ModelAndView("ud");
		}
		
	     //上传
	    @RequestMapping("/doUpload.do")
	    public ModelAndView doUpload(MultipartFile mf,HttpServletRequest res) throws Exception{
	          String fname=mf.getOriginalFilename(); //获取文件名
	          logger.debug("文件名称"+fname);
	          //对文件名进行处理(例如:生成随机文件名)
	          String ext=FilenameUtils.getExtension(fname);  //获取后缀名  
	          String saveName=System.currentTimeMillis()+"."+ext;//生成随机文件名
	          //指定物理存储位置
	           String Path=res.getServletContext().getRealPath("upload");
	           logger.debug("存储路径:"+Path);
	           File file=new File(Path+"/"+saveName); //实现上传
	           logger.debug("文件"+file);
	            mf.transferTo(file);
	           // FileUtils.copyInputStreamToFile(mf.getInputStream(),file);
	        return new ModelAndView("index");
	    }
	    
	    
	    
	    //下载
	    @RequestMapping("/toDownload.do")
	    	public String ToDownload(){
	    	return "download";
	    }
	    
	    	//下载
	    @RequestMapping("/doDownload.do")
	    public void dowmload(String fileName,HttpServletRequest request,HttpServletResponse response)throws Exception{
	    //拿到文件所在的位置
	    	String filePath=request.getServletContext().getRealPath("/upload/"+fileName);
	    //通过文件路径构造一个输入流
	    	FileInputStream fis = new  FileInputStream(filePath);
	    	//通过response对象 设置输出文件相关参数--字符编码  、文件类型、文档头等
	    	response.setHeader("content-disposition", "attchment="+fileName);
	    	response.setCharacterEncoding("utf-8");
	    	response.setContentType("application/octet-stream");//任意二进制文件
	    	response.setContentLength(fis.available());
	    	byte [] by=new byte[1024*4];//设置一个缓冲容器
	    	int line=0;
	    	while((line=fis.read(by))!=-1){//循环读写
	    		response.getOutputStream().write(by, 0,by.length);
	    		response.getOutputStream().flush();//刷新
	    	}
	    	response.getOutputStream().close();
	    	fis.close();
	    }
}