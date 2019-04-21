package com.express.project.express.attachment.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 附件表 attachment
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class Attachment extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 附件编码 */
	private String attNo;
	/** 附件名称 */
	private String attName;
	/** 附件服务器地址 */
	private String attUrl;
	/** 文件路径 */
	private String attPath;
	/** 附件类型 */
	private String attType;
	/** 附件大小 */
	private String attSize;


	public void setAttNo(String attNo)
	{
		this.attNo = attNo;
	}

	public String getAttNo() 
	{
		return attNo;
	}
	public void setAttName(String attName) 
	{
		this.attName = attName;
	}

	public String getAttName() 
	{
		return attName;
	}
	public void setAttUrl(String attUrl) 
	{
		this.attUrl = attUrl;
	}

	public String getAttUrl() 
	{
		return attUrl;
	}
	public void setAttPath(String attPath) 
	{
		this.attPath = attPath;
	}

	public String getAttPath() 
	{
		return attPath;
	}
	public void setAttType(String attType) 
	{
		this.attType = attType;
	}

	public String getAttType() 
	{
		return attType;
	}
	public void setAttSize(String attSize) 
	{
		this.attSize = attSize;
	}

	public String getAttSize() 
	{
		return attSize;
	}


}
