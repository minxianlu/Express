package com.express.project.cargo.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 运价因子表 ex_freight_rate
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class FreightRate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键Id */
	private Integer id;
	/** 发送站Id */
	private Integer sendStation;
	/** 接收站Id */
	private Integer receiveStation;
	/** 价格因子 */
	private Float priceFactor;
	/** 运价号 */
	private Integer freightrateNum;
	/** 创建人 */
	private String createBy;
	/** 修改人 */
	private String updateBy;
	/** 创建时间 */
	private Date createTime;
	/** 更新时间 */
	private Date updateTime;
	/** 状态 */
	private Integer status;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setSendStation(Integer sendStation) 
	{
		this.sendStation = sendStation;
	}

	public Integer getSendStation() 
	{
		return sendStation;
	}
	public void setReceiveStation(Integer receiveStation) 
	{
		this.receiveStation = receiveStation;
	}

	public Integer getReceiveStation() 
	{
		return receiveStation;
	}
	public void setPriceFactor(Float priceFactor) 
	{
		this.priceFactor = priceFactor;
	}

	public Float getPriceFactor() 
	{
		return priceFactor;
	}
	public void setFreightrateNum(Integer freightrateNum) 
	{
		this.freightrateNum = freightrateNum;
	}

	public Integer getFreightrateNum() 
	{
		return freightrateNum;
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
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}


}
