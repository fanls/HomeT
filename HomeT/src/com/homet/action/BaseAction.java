package com.homet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport {
	
	/**
	 * ��listת����json�ַ�
	 * @param list
	 * @return json�ַ�
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public String printJSON(List list) throws Exception{
		JsonConfig jsonConfig = new JsonConfig();
		jsonConfig.setExcludes( new String[]{ "handler","hibernateLazyInitializer" } );  
		jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);    	
    	this.printJSON(jsonArray.toString());
    	return jsonArray.toString();
	}
	
	/**
	 * ��������ı����ͻ���
	 * @param obj
	 */
	public void printJSON(Object obj) {
		PrintWriter write = null;
		try {
			HttpServletResponse response = this.getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			write = response.getWriter();
			write.print(obj);
		} catch (IOException e) {
			write = null;
			e.printStackTrace();
		} finally {
			write.close();
		}
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
}
