package com.express.project.cargo.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 货物地址表 ex_cargo_dress
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class CargoDress extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键Id */
	private Integer id;
	/** 货物Id */
	private Integer cargoId;
	/** 货物编号 */
	private String cargoNo;
	/** 省份编码 */
	private Integer provinceId;
	/** 城市编码 */
	private String cityId;
	/** 地址 */
	private String dress;
	/** 修改人 */
	private String updateBy;
	/** 修改时间 */
	private Date updateTime;
	/** 备注 */
	private String remark;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCargoId(Integer cargoId) 
	{
		this.cargoId = cargoId;
	}

	public Integer getCargoId() 
	{
		return cargoId;
	}
	public void setCargoNo(String cargoNo) 
	{
		this.cargoNo = cargoNo;
	}

	public String getCargoNo() 
	{
		return cargoNo;
	}
	public void setProvinceId(Integer provinceId) 
	{
		this.provinceId = provinceId;
	}

	public Integer getProvinceId() 
	{
		return provinceId;
	}
	public void setCityId(String cityId) 
	{
		this.cityId = cityId;
	}

	public String getCityId() 
	{
		return cityId;
	}
	public void setDress(String dress) 
	{
		this.dress = dress;
	}

	public String getDress() 
	{
		return dress;
	}
	public void setUpdateBy(String updateBy) 
	{
		this.updateBy = updateBy;
	}

	public String getUpdateBy() 
	{
		return updateBy;
	}
	public void setUpdateTime(Date updateTime) 
	{
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() 
	{
		return updateTime;
	}
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}


}
