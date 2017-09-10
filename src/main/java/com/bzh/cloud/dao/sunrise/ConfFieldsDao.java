package com.bzh.cloud.dao.sunrise;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bzh.cloud.entity.sunrise.ConfFields;

public interface ConfFieldsDao extends BaseMapper<ConfFields>{
	
	@Select("select * from conf_fields where entity_name=#{entity_nam} order by column_index")
	public List<ConfFields> findByentityName(String entityName);

}
