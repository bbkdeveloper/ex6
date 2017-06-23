package com.choa.file;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.choa.util.SEDTO;

@Service
public class FileService {

	
	//seUpload
	public String seUpload(SEDTO sedto, HttpSession session)throws Exception{
		//
		String file_result="";
		if(sedto.getFiledata() !=null && sedto.getFiledata().getOriginalFilename() != null && !sedto.getFiledata().getOriginalFilename().equals("")){
			FileSaver fileSaver = new FileSaver();
			String defaultPath = session.getServletContext().getRealPath("resources/upload");
			String realName = fileSaver.filesave(defaultPath, sedto.getFiledata());
			
			file_result = "&bNewLine=true&sFileName="+sedto.getFiledata().getOriginalFilename()+"&sFileURL=/ex6/resources/upload/"+realName;
		}else{
			file_result="&errstr=error";
		}
		return "redirect:"+sedto.getCallback()+"?callback_func="+sedto.getCallback_func()+file_result;
	}
	
	
	
	//delete
	public Boolean fileDelete(String fileName, HttpSession session)throws Exception{
		String realPath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realPath, fileName);
		boolean result = f.delete();
		
		return result;
		
	}
	
	

	
	//파일에 저장하는 코드를 입력 - DAO를 안가기 때문에
	
	public String fileSave(MultipartFile m, HttpSession session)throws Exception{
		FileSaver fileSaver = new FileSaver();
		String fileName =  fileSaver.filesave(session.getServletContext().getRealPath("resources/upload"), m);
		
		return fileName;
	}
	
	
}
