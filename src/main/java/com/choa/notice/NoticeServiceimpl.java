package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.board.BoardDTO;
import com.choa.board.BoardService;
import com.choa.util.ListInfo;
import com.choa.util.PageMaker;
import com.choa.util.RowMaker;

//NoticeService noticeService = new NoticeService(); 와 같은뜻의 @Service
//xml에 넣는 bean과 같은 코드
@Service
public class NoticeServiceimpl implements BoardService {

	@Inject
	private NoticeDAOimpl noticeDAOimpl;
	//inject를 사용해서 주입하기 때문에, Constructor방법이나 setter가 필요없다
	
	//Constructor방법
/*	public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO; 
	}
*/	
	//setter방법
	/*	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	*/
	
	@Override
	public List<BoardDTO> boardList(ListInfo listInfo) throws Exception {
		int result = noticeDAOimpl.boardCount(listInfo);
		listInfo.makePage(result);
		listInfo.makeRow();				//startRow&lastRow만들어줌
		
		return noticeDAOimpl.boardList(listInfo);
	}


	@Override
	public BoardDTO boardView(int num) throws Exception {
		BoardDTO boardDTO = noticeDAOimpl.boardView(num);
		return boardDTO;
	}


	@Override
	public int boardWrite(BoardDTO boardDTO) throws Exception {
		return noticeDAOimpl.boardWrite(boardDTO);
		
	}


	@Override
	public int boardUpdate(BoardDTO boardDTO) throws Exception {
		return noticeDAOimpl.boardUpdate(boardDTO);
	}


	@Override
	public int boardDelete(int num) throws Exception {
		return noticeDAOimpl.boardDelete(num);
		
	}

}
