package com.bzh.cloud.service.sunrise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bzh.cloud.dao.sunrise.ConfEntityDao;
import com.bzh.cloud.dao.sunrise.ConfFieldsDao;
import com.bzh.cloud.entity.sunrise.ConfEntity;
import com.bzh.cloud.entity.sunrise.ConfFields;

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
