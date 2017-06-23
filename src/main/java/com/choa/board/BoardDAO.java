package com.choa.board;

import java.util.List;

import com.choa.util.ListInfo;
import com.choa.util.RowMaker;

public interface BoardDAO {

	
	//list
	public List<BoardDTO> boardList(ListInfo listInfo)throws Exception;
	
	//View
	public BoardDTO boardView(int num)throws Exception;
	
	//Write
	public int boardWrite(BoardDTO boardDTO)throws Exception;
	
	//Update
	public int boardUpdate(BoardDTO boardDTO)throws Exception;
	
	//Delete
	public int boardDelete(int num)throws Exception;
	
	//Count
	public int boardCount(ListInfo listInfo) throws Exception;
	
	//hit
	public void boardHit(int num)throws Exception;

	
}
