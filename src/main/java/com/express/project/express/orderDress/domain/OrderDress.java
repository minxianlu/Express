package com.express.project.express.orderDress.domain;


import com.express.framework.web.domain.BaseEntity;

/**
 * 订单地址表 ex_order_dress
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class OrderDress extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键Id */
	private Integer id;
	/** 订单Id */
	private Integer orderId;
	/** 订单编号 */
	private String orderNo;
	/** 省份编码 */
	private Integer provinceId;
	/** 城市编码 */
	private String cityId;
	/** 地址 */
	private String dress;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setOrderId(Integer orderId) 
	{
		this.orderId = orderId;
	}

	public Integer getOrderId() 
	{
		return orderId;
	}
	public void setOrderNo(String orderNo) 
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
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



}
