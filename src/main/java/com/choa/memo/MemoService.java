package com.choa.memo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.util.ListInfo;

@Service
public class MemoService {

	@Autowired
	private MemoDAO memoDAO;
	
	//list
		public List<MemoDTO> memoList(ListInfo listInfo)throws Exception{
			int result = memoDAO.boardCount(listInfo);
			listInfo.makePage(result);
			listInfo.makeRow();		
			
			return memoDAO.memoList(listInfo);
		}

		//view
		public MemoDTO memoView(int num)throws Exception{
			
			return memoDAO.memoView(num);
		}
		
		//insert
		public int memoWrite(MemoDTO memoDTO){
			
			return memoDAO.memoWrite(memoDTO);
		}
		//update
		public int memoUpdate(MemoDTO memoDTO){
			
			return memoDAO.memoUpdate(memoDTO);
		}
		//delete
		public int memoDelete(int num){
			
			return memoDAO.memoDelete(num);
		}
}
