package com.fr.jsp.admin.model.service;

import static com.fr.jdbc.common.JDBCTemplate.close;
import static com.fr.jdbc.common.JDBCTemplate.commit;
import static com.fr.jdbc.common.JDBCTemplate.getConnection;
import static com.fr.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.fr.jsp.admin.model.dao.FaqBoardDao;
import com.fr.jsp.board.model.vo.FaqBoard;

public class FaqBoardService {
	private Connection con;
	private FaqBoardDao fbDao;
	
	public FaqBoardService() {
		super();
		con = getConnection();
		fbDao = new FaqBoardDao();
	}
	// Connection close Method
	public void closeCon(){
		close(con);
	}
	// FAQ 게시판 리스트
	public ArrayList<FaqBoard> admin_faqBoardAllList() {
		ArrayList<FaqBoard> admin_faqBoardAllList = fbDao.admin_faqBoardAllList(con);
		return admin_faqBoardAllList;
	}
	// FAQ 등록
	public void admin_insertFAQBoard(FaqBoard faqBoard) {
		int insertFAQBoardCount = fbDao.admin_insertFAQBoard(con, faqBoard);
		if(insertFAQBoardCount>0) commit(con);
		else rollback(con);
		
	}
	// FAQ 수정
	public void admin_updateFAQBoard(FaqBoard faqBoard) {
		int updateFAQBoardCount = fbDao.admin_updateFAQBoard(con, faqBoard);
		if(updateFAQBoardCount>0) commit(con);
		else rollback(con);
		
	}
	// FAQ 삭제
	public void admin_deleteFAQBoard(String faqNum) {
		int deleteFAQBoardCount = fbDao.admin_deleteFAQBoard(con, faqNum);
		if(deleteFAQBoardCount>0) commit(con);
		else rollback(con);
	}

}
