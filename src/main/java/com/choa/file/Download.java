package com.choa.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//view객체의 역활을 해야하는 Download class
//Spring에서 제공하는 abstractView를 상속받아야한다
public class Download extends AbstractView {

	
	public Download() {
		setContentType("application/download:charset=UTF-8");
		//abstract view에서 나온 setContentType
		//charset : character Encoding
	
	}
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		File f = (File)model.get("downloadFile");
		String oriName = (String)model.get("oriName");
		response.setCharacterEncoding(getContentType());
		response.setContentLength((int)f.length());
		//너가 보내주는 data의 길이는 얼마? setcontentLength는 int type
		
		String fileName = URLEncoder.encode(f.getName(), "UTF-8");
		//File명을 꺼내오기, UTF-8을 셋팅해주는 URLEncoder 클래스
		
		fileName = fileName.substring(fileName.lastIndexOf("_"));
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		//파일을 2진데이터로 바꿔서 넣어라
		
		OutputStream out = response.getOutputStream();
		
		FileInputStream f1 = null;
		
		f1 = new FileInputStream(f);
		
		FileCopyUtils.copy(f1, out);
		
		f1.close();
		out.close();
		
		
	}
}
