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
	private String initValid;
	private String hidden;
	private String renderer;
	private Integer width;
	private String dataSql;
	private String allowBlank;
	private String checkSql;

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



	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getAllowBlank() {
		return allowBlank;
	}


	public void setAllowBlank(String allowBlank) {
		this.allowBlank = allowBlank;
	}


	public String getDataSql() {
		return dataSql;
	}


	public void setDataSql(String dataSql) {
		this.dataSql = dataSql;
	}


	public String getCheckSql() {
		return checkSql;
	}


	public void setCheckSql(String checkSql) {
		this.checkSql = checkSql;
	}


	public String getInitValid() {
		return initValid;
	}


	public void setInitValid(String initValid) {
		this.initValid = initValid;
	}


	@Override
	public String toString() {
		return "ConfFields [entityName=" + entityName + ", columnIndex="
				+ columnIndex + ", fieldName=" + fieldName + ", fieldType="
				+ fieldType + ", fieldText=" + fieldText + ", initValid="
				+ initValid + ", hidden=" + hidden + ", renderer=" + renderer
				+ ", width=" + width + ", dataSql=" + dataSql + ", allowBlank="
				+ allowBlank + ", checkSql=" + checkSql + "]";
	}
	
	
	
}
