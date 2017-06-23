package com.choa.ex6;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.choa.file.FileDTO;
import com.choa.file.FileService;
import com.choa.file.MultiFileDTO;
import com.choa.file.SameMultiFileDTO;
import com.choa.util.SEDTO;

@Controller
@RequestMapping(value="/file/**")
public class FileController { 
	
	@RequestMapping(value="fileUpload", method=RequestMethod.GET)
	public void fileUpload(){}
	
	
	@RequestMapping(value="seUpload", method=RequestMethod.POST)
	public String seUpload(SEDTO sedto, HttpSession session)throws Exception{
		
		/*//callback
		String callback = sedto.getCallback();
		//callback_func
		String callback_func = sedto.getCallback_func();
		//OriName
		String original_Name = sedto.getFiledata().getOriginalFilename();
		//Default Path
		String defalutPath = session.getServletContext().getRealPath("resources/upload");
		
		//경로만 잇는 f
		File f = new File(defalutPath);
		
		//디렉토리가 존재하지 않을 경우 디렉토리 생성
		if(!f.exists()){
			f.mkdirs();
		}
		
		//디렉토리에 저장할 파일명
		String realName = UUID.randomUUID().toString()+"_"+original_Name;
		
		//디렉터리에 저장
		sedto.getFiledata().transferTo(new File(f, realName));
		
		//
		String file_result = "&bNewLine=true&sFileName="+original_Name+"&sFileURL=/ex6/resources/upload/"+realName;
		
		return "redirect:"+callback+"?callback_func="+callback_func+file_result;		*/
		
		FileService fs = new FileService();
		return fs.seUpload(sedto, session);
	}
	
	
	
	
	
	//파일 다운로드
	//view페이지로 가지말고 그냥 다운로드가 되어야한다
	@RequestMapping(value="fileDown", method=RequestMethod.GET)
	public ModelAndView fileDown(String fileName, String oriName, HttpSession session){
		String realPath = session.getServletContext().getRealPath("resources/upload");
		File f = new File(realPath, fileName);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("download");
		mv.addObject("oriName", oriName);
		mv.addObject("downloadFile", f);
		
		return mv;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//@RequestMapping(value="seUpload", method=RequestMethod.POST)
	public void seUpload(MultipartHttpServletRequest request){
	Enumeration<Object> e =  request.getParameterNames();
		
		while(e.hasMoreElements()){
			System.out.println("e.next=="+e.nextElement());
		}
		Iterator<String> it = request.getFileNames();
		while(it.hasNext()){
			System.out.println("it.next=="+it.next());
			//fileupload할 때 parameterName이 출력
		}
	}
	
	
	
	//*********************** DB말고 진짜 폴더안의 파일 삭제 ************************//
	@RequestMapping(value="fileDelete", method=RequestMethod.GET)
	public void fileDelete(String fileName, HttpSession session)throws Exception{
		FileService fileService = new FileService();
		fileService.fileDelete(fileName, session);
	}
	
	
	
	
	
	//********************************************************//
	
	
	@RequestMapping(value="upload", method=RequestMethod.POST)
		public void upload(MultipartHttpServletRequest request){

		Iterator<String> it = request.getFileNames();
		//getParameterNames로 받게되면, 텍스트파일은 같이 받지를 못함
		
		ArrayList<MultipartFile> multi = new ArrayList<MultipartFile>();
		
		while(it.hasNext()){
			System.out.println("it.next="+it.next());
			MultipartFile m = request.getFile(it.next());
			multi.add(m);
		}
		for(MultipartFile m : multi){
			
			System.out.println("m.oriname="+m.getOriginalFilename());
		}
	}
	
	
	
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
	//@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public void fileUpload(MultipartHttpServletRequest request){
		//1번째 : multipartservletRequest
		//여러개의 파일업로드를 하려면, 파라미터 이름만 가져오면 되므로 다른 추가가 없다
		
	}
	
	@RequestMapping(value="fileUpload", method=RequestMethod.POST)
	public ModelAndView fildUpload(MultipartFile f1, HttpSession session)throws Exception{
		//2번째 : multipartFile로 받으면 변수명과 동일하게 받아준다
		//여러개의 파일업로드를 하려면, 매개변수로 multipartFile f2를 추가해야한다.
		
		FileService f = new FileService();
		String fileName = f.fileSave(f1, session);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("file/fileView");
		mv.addObject("fileName", fileName);
		mv.addObject("oriName", f1.getOriginalFilename());
		
		return mv;
	}
	
	
	public void fileUpload(FileDTO fileDTO){
		//3번째 : DTO사용
		//여러개의 파일업로드를 하려면, fileDTO에서 private MultipartFile f1이 한개만 일치하고 f2는 일치하지 않아서 f2추가를 따로 해야한다
	}

}
