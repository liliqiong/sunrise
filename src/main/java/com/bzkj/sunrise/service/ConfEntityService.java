package com.bzkj.sunrise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzkj.sunrise.dao.ConfEntityDao;
import com.bzkj.sunrise.dao.ConfFieldsDao;
import com.bzkj.sunrise.entity.ConfEntity;
import com.bzkj.sunrise.entity.ConfFields;

@Service
public class ConfEntityService {
	
	@Autowired
	ConfEntityDao confEntityDao;
	
	@Autowired
	ConfFieldsDao confFieldsDao;
	
	public ConfEntity queryEntity(String entityName){
		ConfEntity e=confEntityDao.selectById(entityName);
		List<ConfFields> fs=confFieldsDao.findByentityName(entityName);
		e.setFields(fs);
		return e;
	}

}
