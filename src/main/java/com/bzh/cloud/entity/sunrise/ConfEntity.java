package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

/**
 * ConfEntity entity. @author MyEclipse Persistence Tools
 */

public class ConfEntity extends Model<ConfEntity> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields
	@TableId
	private String entityName;
	private String primaryField;
	private String createUrl;
	private String updateUrl;
	private String deleteUrl;
	private String querySql;
	private String title;
	
	@TableField(exist=false)
	private List<ConfFields> fields;

	// Constructors

	/** default constructor */
	public ConfEntity() {
	}

	public String getEntityName() {
		return this.entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getPrimaryField() {
		return this.primaryField;
	}

	public void setPrimaryField(String primaryField) {
		this.primaryField = primaryField;
	}

	public String getCreateUrl() {
		return this.createUrl;
	}

	public void setCreateUrl(String createUrl) {
		this.createUrl = createUrl;
	}

	public String getUpdateUrl() {
		return this.updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getDeleteUrl() {
		return this.deleteUrl;
	}

	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return entityName;
	}

	public List<ConfFields> getFields() {
		return fields;
	}

	public void setFields(List<ConfFields> fields) {
		this.fields = fields;
	}

	public String getQuerySql() {
		return querySql;
	}

	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}
