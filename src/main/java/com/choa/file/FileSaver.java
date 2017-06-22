package com.choa.file;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileSaver {

	//파일들이 byte배열들로 저장해있는걸 받아오기위한 byte[] fileData
	public String fileSave(String realPath, byte[] fileData, String oriName)throws Exception{
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		String fileName = UUID.randomUUID().toString()+"_"+oriName;
		//실제 업로드 폴더에 저장되는 fileName
		
		File taget = new File(f, fileName);
		//realPath를 file f가 가지고 있으므로, 경로에 f로 넣어도 됨
		
		FileCopyUtils.copy(fileData, taget);
		//byte[] fileData를 가져와서 taget에 저장
		
		return fileName;
	}
	
	
	 
	public String filesave(String realPath, MultipartFile m)throws Exception{
		
		System.out.println(realPath);
		File f = new File(realPath);
		
		if(!f.exists()){
			f.mkdirs();		//f가 없다면, f의파일을 만들어주세요->mkdirs()
		}
		
		//1번
		//String fileName = UUID.randomUUID().toString()+"_"+m.getOriginalFilename();
		
		//2번 중복을 피해서 시간으로 설정
		Calendar ca = Calendar.getInstance();	//현재시간을 받아오기
		String fileName = ca.getTimeInMillis()+"_"+m.getOriginalFilename();
		
		File target = new File(f, fileName);		//경로는 f, file의 name은 fileName
		m.transferTo(target);					//m의 정보를 target에 옮기겠다?.... 
		
		return fileName;
	}
}
