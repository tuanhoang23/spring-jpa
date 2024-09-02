package com.spring.DAO.impl;

import java.util.ArrayList;

import com.spring.DAO.icatagoriesDAO;
import com.spring.mapper.catagoryMapper;
import com.spring.model.catagoriesModel;



public class catagoriesDAO extends abstractDAO<catagoriesModel> implements icatagoriesDAO {
	
	@Override
	public ArrayList<catagoriesModel> findAll() {
		String sql = "SELECT * FROM catagories";
		
		return query(sql, new catagoryMapper());
	}

	@Override
	public Long save(catagoriesModel catagorySave) {
		StringBuilder sql = new StringBuilder("INSERT INTO catagories (name,create_at,modifile_at,createby,modifileby,code)");
		sql.append("VALUES(?,?,?,?,?,?)");
		return insert(sql.toString(),catagorySave.getName(),catagorySave.getCreateAt(),catagorySave.getModifileAt(),
				catagorySave.getCreateBy(),catagorySave.getModifileBy(),catagorySave.getCode());
	}

	@Override
	public catagoriesModel findOne(long id) {
		String sql = "SELECT * FROM catagories WHERE id = ?";
		ArrayList<catagoriesModel> catagory = query(sql,new catagoryMapper(),id);
		return catagory.isEmpty() ? null : catagory.get(0);
	}

	@Override
	public catagoriesModel findOneByCode(String code) {
		String sql = "SELECT * FROM catagories WHERE code = ?";
		ArrayList<catagoriesModel> catagory = query(sql,new catagoryMapper(),code);
		return catagory.isEmpty() ? null : catagory.get(0);
	}

	@Override
	public void update(catagoriesModel catagoryupdate) {
		StringBuilder sql = new StringBuilder("UPDATE catagories SET name=?, create_at=?, modifile_at=?, createby=?, modifileby=?, code=? WHERE id=? ");
		update(sql.toString(),catagoryupdate.getName(),catagoryupdate.getCreateAt(),catagoryupdate.getModifileAt(),catagoryupdate.getCreateBy(),catagoryupdate.getModifileBy(),catagoryupdate.getCode(),catagoryupdate.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE FROM catagories WHERE id = ?";
		delete(sql,id);
		
	}
	
}
