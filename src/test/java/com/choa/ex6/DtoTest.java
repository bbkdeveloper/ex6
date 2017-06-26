package com.choa.ex6;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.board.BoardDTO;
import com.choa.memo.MemoDAO;
import com.choa.memo.MemoDTO;
import com.choa.notice.NoticeDAOimpl;

public class DtoTest extends MyAbstractTest{

	@Autowired
	private MemoDAO memoDAO;
	//private NoticeDAOimpl noticeDAOimpl;
	
	@Test
	public void test() throws Exception {
	/*	BoardDTO boardDTO= noticeDAOimpl.boardView(47);*/
		MemoDTO memoDTO = new MemoDTO();
		memoDTO.setWriter("ddd");
		memoDTO.setContents("dsd");
		int result = memoDAO.memoWrite(memoDTO);
		assertEquals(1, result);
		
	}

}
