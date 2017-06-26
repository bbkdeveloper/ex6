package com.choa.memo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.util.ListInfo;


@Repository
public class MemoDAO {

	@Autowired
	private SqlSession sqlSession;
	private static final String NAMESPACE="MemoMapper.";
	
	
	//list
	public List<MemoDTO> memoList(ListInfo listInfo)throws Exception{
		
		return sqlSession.selectList(NAMESPACE+"list", listInfo);
	}

	//view
	public MemoDTO memoView(int num)throws Exception{
		
		return sqlSession.selectOne(NAMESPACE+"view", num);
	}
	
	//insert
	public int memoWrite(MemoDTO memoDTO){
		
		return sqlSession.insert(NAMESPACE+"write", memoDTO);
	}
	//update
	public int memoUpdate(MemoDTO memoDTO){
		
		return sqlSession.update(NAMESPACE+"update", memoDTO);
	}
	//delete
	public int memoDelete(int num){
		
		return sqlSession.delete(NAMESPACE+"delete", num);
	}
	
	//count
	public int boardCount(ListInfo listInfo) throws Exception {
		return sqlSession.selectOne(NAMESPACE+"count", listInfo);
	}
}
