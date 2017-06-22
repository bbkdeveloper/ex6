package com.choa.ex6;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.file.FileDTO;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController { 
	
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){}
	
	
	//****************************다중 파일 업로드 - 파라미터 이름이 같을 때****************************//
	
	//@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
	public void sameMultiFileUpload(MultipartFile [] f1){
		for(int i=0;i<f1.length;i++){
			System.out.println("f"+i+"_oriname"+f1[i].getOriginalFilename());
		}
	}
	
	
	@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
	public void sameMultiFileUpload(SameMultiFileDTO sameMultiFileDTO){
		for(int i=0;i<sameMultiFileDTO.getF1().length;i++){
			System.out.println("f"+i+"_oriname"+sameMultiFileDTO.getF1()[i].getOriginalFilename());
		}
	}
	
	
	//@RequestMapping(value="sameMultiFileUpload", method=RequestMethod.POST)
	public void sameMultiFileUpload(MultipartHttpServletRequest request){
		List<MultipartFile> ar = request.getFiles("f1");
		
		for(MultipartFile f:ar){
			System.out.println("f_oriname : "+f.getOriginalFilename());
		}
	}
	
	
	
	
	
	
	
	
	//****************************다중 파일 업로드 - 파라미터 이름이 다를 때****************************//
	//@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultiFileDTO multiFileDTO){
		System.out.println("multiDTO_f1_oriname : "+ multiFileDTO.getF1().getOriginalFilename());
		System.out.println("multiDTO_f2_oriname : "+ multiFileDTO.getF2().getOriginalFilename());
	}
	
	
	
	//@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultipartFile f1, MultipartFile f2, MultiFileDTO multiFileDTO){
		System.out.println("multiDTO_f1_oriname : "+ f1.getOriginalFilename());
		System.out.println("multiDTO_f2_oriname : "+ f2.getOriginalFilename());
	}
	
	
	@RequestMapping(value="multiFileUpload", method=RequestMethod.POST)
	public void multiFileUpload(MultipartHttpServletRequest request){
		MultipartFile f1 = request.getFile("f1");
		MultipartFile f2 = request.getFile("f2");
		System.out.println("multiDTO_f1_oriname : "+ f1.getOriginalFilename());
		System.out.println("multiDTO_f2_oriname : "+ f2.getOriginalFilename());
	}
	
	
	
	
	
	
	
	//****************************단일 파일 업로드****************************//
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){
		//1번째 : multipartservletRequest
		//여러개의 파일업로드를 하려면, 파라미터 이름만 가져오면 되므로 다른 추가가 없다
		
	}
	
	
	public void fildUpload(MultipartFile f1){
		//2번째 : multipartFile로 받으면 변수명과 동일하게 받아준다
		//여러개의 파일업로드를 하려면, 매개변수로 multipartFile f2를 추가해야한다.
	}
	
	
	public void fileUpload(FileDTO fileDTO){
		//3번째 : DTO사용
		//여러개의 파일업로드를 하려면, fileDTO에서 private MultipartFile f1이 한개만 일치하고 f2는 일치하지 않아서 f2추가를 따로 해야한다
	}

}
