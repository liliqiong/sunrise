package com.bzh.cloud.entity.sunrise;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;

public class ConfFields extends Model<ConfFields> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private String entityName;
	private Integer columnIndex;
	private String fieldName;
	private String fieldType;
	private String fieldText;
	private String hidden;
	private String renderer;
	private Integer width;
	private String datasql;

	// Constructors

	/** default constructor */
	public ConfFields() {
	}

	
	public String getEntityName() {
		return entityName;
	}


	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}


	public Integer getColumnIndex() {
		return columnIndex;
	}


	public void setColumnIndex(Integer columnIndex) {
		this.columnIndex = columnIndex;
	}


	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getFieldText() {
		return this.fieldText;
	}

	public void setFieldText(String fieldText) {
		this.fieldText = fieldText;
	}

	public String getHidden() {
		return this.hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getRenderer() {
		return this.renderer;
	}

	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	public Integer getWidth() {
		return this.width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getDatasql() {
		return this.datasql;
	}

	public void setDatasql(String datasql) {
		this.datasql = datasql;
	}

	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}

}
