package com.choa.ex6;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.choa.memo.MemoDTO;
import com.choa.memo.MemoService;
import com.choa.util.ListInfo;

//모든 메서드가 responsebody라고 Annotation이 생기면 RestController로
@Controller
@RequestMapping(value="/memo/**")
public class MemoController {

	@Autowired
	private MemoService memoService;
	
	//memoList페이지로 이동만 시켜주면 되는 memoList
	@RequestMapping(value="memoList")
	public void memoList(){
		
	}
	
	@RequestMapping(value="getMemoList/{curPage}/{find}/{search}")
	@ResponseBody
	public List<MemoDTO> memoList(ListInfo listInfo, int curPage, @PathVariable("find")String find, @PathVariable("search")String search)throws Exception{
		//돌아가는걸 view가 아니라 body로 보내겟다는 @ResponseBody
		//ajax의 data로 바로 들어간다
		List<MemoDTO> list =  memoService.memoList(listInfo);
		listInfo.setCurPage(curPage);
		listInfo.setFind(find);
		listInfo.setSearch(search);
		//JSON형식으로 만들자
		/*JSONArray ar = new JSONArray();
		for(MemoDTO m : list){
			JSONObject obj = new JSONObject();
			obj.put("num", m.getNum()+"");
			obj.put("writer", m.getWriter()+"");
			obj.put("contents", m.getContents()+"");
			obj.put("date", m.getReg_date()+"");
			ar.add(obj);
		}
		model.addAttribute("list", ar.toJSONString());
		//문자열로 변환되서 list로 저장
		*/
		
		return list;
	}
	
	
	@RequestMapping(value="memoView/{num}")
	@ResponseBody
	public MemoDTO memoView(@PathVariable("num") int num)throws Exception{
		//@PathVariable 은 path에 num을 넣고 메서드로 넘어온다
		MemoDTO memoDTO = memoService.memoView(num);
		
		return memoDTO;
		//알아서 json형태로 바꿔준다
	}
	
	@RequestMapping(value="memoWrite", method=RequestMethod.POST)
	public List<MemoDTO> memoWrite(MemoDTO memoDTO, Model model)throws Exception{
	
		int result = memoService.memoWrite(memoDTO);
		ListInfo listInfo = new ListInfo();
		listInfo.setCurPage(1);

		
		List<MemoDTO> list =  memoService.memoList(listInfo);
		model.addAttribute("list", list);
	
		return  list;
	}
	
	public void memoUpdate(){
		
	}
	
	public void memoDelete(){
		
	}
	
}
