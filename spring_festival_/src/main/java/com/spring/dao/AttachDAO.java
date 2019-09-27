package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import com.spring.dto.AttachVO;

public interface AttachDAO {
	public List<AttachVO> selectAttachesByUnqId(int unqId) throws SQLException;
	
	public AttachVO selectAttachByAno(int ano) throws SQLException;
	
	public void insertAttach(AttachVO attach) throws SQLException;
	
	public void deleteAttach(int ano) throws SQLException;
	
	public void deleteAllAttach(int unqId) throws SQLException;

}
