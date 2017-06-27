package com.choa.ex6;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.board.BoardDTO;
import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeServiceimpl;
import com.choa.util.ListInfo;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject	//Data type으로 찾는다
	private NoticeServiceimpl noticeService;
	
	//NoticeList
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String noticeList(Model model, ListInfo listInfo)throws Exception{
		System.out.println("난 컨트롤러");
		List<BoardDTO> ar = noticeService.boardList(listInfo);
		System.out.println(ar.get(1000).getTitle());
		//throw new IndexOutOfBoundsException();
		//예외 객체타입을 하나를 만들어서 던져준다
		//try안에 객체를 만들어서 catch에서 받아주는건데 생략이 되어있...
		
		model.addAttribute("list", ar);
		model.addAttribute("board", "notice");
		
		model.addAttribute("listInfo", listInfo);
		return "board/boardList";
	}
	
	//NoticeView
	@RequestMapping(value="noticeView", method=RequestMethod.GET)
	public void noticeView(Integer num, Model model)throws Exception{
		if(num==null){
			num = 1;
		}
		BoardDTO boardDTO = noticeService.boardView(num);
		model.addAttribute("dto", boardDTO);
	}
	
	//NoticeWriteForm writeForm
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String noticeWrite(Model model)throws Exception{
		model.addAttribute("path", "Write");
		model.addAttribute("board", "Notice");
		
		return "board/BoardWrite";
		
	}
	
	//NoticeWrite
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String noticeWrite(BoardDTO boardDTO, RedirectAttributes rd)throws Exception{
		int result = noticeService.boardWrite(boardDTO);
		String message="FAIL";
		if(result==1){
			message="success";
		}
		
		rd.addFlashAttribute("message", message);		//RedirectAttributes Redirect방식
		//model.addAttribute("message", message);			//Model은 foward방식
		 
		return "redirect:/notice/noticeList";
		//return "notice/result";
		//return "redirect:/noticeList?curPage=2";		파라미터를 주고싶다면 여기서
	}
	
	//NoticeUpdateForm
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String noticeUpdate(Model model, int num)throws Exception{
		BoardDTO boardDTO = noticeService.boardView(num);
		model.addAttribute("dto", boardDTO);
		model.addAttribute("path", "Update");
		
		return "notice/noticeWrite";
	}
	
	//NoticeUpdate
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public String noticeUpdate(BoardDTO boardDTO, RedirectAttributes rd)throws Exception{
		int result = noticeService.boardUpdate(boardDTO);
		String message="FAIL";
		if(result==1){
			message="success";
		}
		
		rd.addFlashAttribute("message", message);		//RedirectAttributes Redirect방식
		//model.addAttribute("message", message);			//Model은 foward방식
		 
		return "redirect:/notice/noticeList";
		//return "notice/result";
		//return "redirect:/noticeList?curPage=2";		파라미터를 주고싶다면 여기서
	}
	
	//NoticeDelete
	@RequestMapping(value="noticeDelete", method=RequestMethod.GET)
	public String noticeDelete(int num, RedirectAttributes rd)throws Exception{
		int result = noticeService.boardDelete(num);
		String message="FAIL";
		if(result==1){
			message="Delete success";
		}
		rd.addFlashAttribute("message", message);
		
		return "redirect:/notice/noticeList";
		
	}
	
	
}
