package com.express.project.express.freightRate.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 运价因子表 ex_freight_rate
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class FreightRate extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 发送站Id */
	private Integer sendStation;
	/** 接收站Id */
	private Integer receiveStation;

	/** 运价号 */
	private Integer serviceMode;
	/** 状态 */
	private Integer status;
	/** 价格*/
	private String price;
	/** 查询重量*/
	private String weight;


	/** 发送站 字符型 */
	private String sendStationStr;
	/** 接收站 字符型 */
	private String receiveStationStr;
	/** 服务方式 字符型 */
	private String serviceModeStr;
	/** 价格因子 */
	private Float priceFactor;
	/** 状态 字符型 */
	private String statusStr;

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

	public Integer getServiceMode() {
		return serviceMode;
	}

	public void setServiceMode(Integer serviceMode) {
		this.serviceMode = serviceMode;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getServiceModeStr() {
		return serviceModeStr;
	}

	public void setServiceModeStr(String serviceModeStr) {
		this.serviceModeStr = serviceModeStr;
	}

	public String getSendStationStr() {
		return sendStationStr;
	}

	public void setSendStationStr(String sendStationStr) {
		this.sendStationStr = sendStationStr;
	}

	public String getReceiveStationStr() {
		return receiveStationStr;
	}

	public void setReceiveStationStr(String receiveStationStr) {
		this.receiveStationStr = receiveStationStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
}
