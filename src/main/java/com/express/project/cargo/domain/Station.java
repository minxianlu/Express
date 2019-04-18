package com.express.project.cargo.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 车站表 ex_station
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class Station extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键Id
 */
	private Integer id;
	/** 站台名称
 */
	private String stationName;
	/** 创建人 */
	private String createBy;
	/** 修改人 */
	private String updateBy;
	/** 创建时间 */
	private Date createTime;
	/** 修改时间 */
	private Date updateTime;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setStationName(String stationName) 
	{
		this.stationName = stationName;
	}

	public String getStationName() 
	{
		return stationName;
	}
	public void setCreateBy(String createBy) 
	{
		this.createBy = createBy;
	}

	public String getCreateBy() 
	{
		return createBy;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setCreateTime(Date createTime) 
	{
		this.createTime = createTime;
	}

	public Date getCreateTime() 
	{
		return createTime;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}


}
