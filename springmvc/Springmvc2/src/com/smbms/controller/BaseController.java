package com.smbms.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class BaseController {
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder){
		System.out.println("welcome================");
		
		//Date.class 日期类型      new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true) 自定义的日期编辑器
		dataBinder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));//true 为空
	}
}
