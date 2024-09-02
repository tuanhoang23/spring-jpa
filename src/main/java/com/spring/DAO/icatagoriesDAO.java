package com.spring.DAO;

import java.util.ArrayList;

import com.spring.model.catagoriesModel;




public interface icatagoriesDAO extends genericDAO<catagoriesModel>  {

	ArrayList<catagoriesModel> findAll();
	Long save(catagoriesModel catagorySave);
	void update(catagoriesModel catagoryUpdate);
	void delete(long ids);
	catagoriesModel findOne(long id);
	catagoriesModel findOneByCode(String code);
}
