package com.express.project.express.order.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 订单表 ex_order
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public class Order extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 订单编号 */
	private String orderNo;
	/** 发货日期 */
	private Date sendTime;
	/** 发送省份 */
	private Integer sendProvince;
	/** 发送城市 */
	private String sendCity;
	/** 接收省份 */
	private Integer receiveProvince;
	/** 接收城市 */
	private String receiveCity;
	/** 发送车站 */
	private Integer sendStation;
	/** 接收车站 */
	private Integer receiveStation;
	/** 客户编码 */
	private String customerNo;
	/** 客户类型 */
	private Integer customerType;
	/** 发货人名称 */
	private String sendName;
	/** 发货联系人 */
	private String sendContacts;
	/** 发货人电话 */
	private String sendPhone;
	/** 收货人名称 */
	private String receiveName;
	/** 收货联系人 */
	private String receiveContacts;
	/** 接收人电话 */
	private String receivePhone;
	/** 服务方式 */
	private Integer serviceMode;
	/** 送货里程 */
	private Double pickUpMileage;
	/** 送货里程 */
	private Double deliveryMileage;
	/** 取货地址 */
	private String pickUpDress;
	/** 送货地址 */
	private String deliveryDress;
	/** 货物Id */
	private Integer cargoId;
	/** 货物编号 */
	private String cargoNo;
	/** 是否开具发票 */
	private Integer invoice;
	/** 状态 */
	private Integer status;

	public void setOrderNo(String orderNo)
	{
		this.orderNo = orderNo;
	}

	public String getOrderNo() 
	{
		return orderNo;
	}
	public void setSendTime(Date sendTime) 
	{
		this.sendTime = sendTime;
	}

	public Date getSendTime() 
	{
		return sendTime;
	}
	public void setSendProvince(Integer sendProvince)
	{
		this.sendProvince = sendProvince;
	}

	public Integer getSendProvince()
	{
		return sendProvince;
	}
	public void setSendCity(String sendCity) 
	{
		this.sendCity = sendCity;
	}

	public String getSendCity() 
	{
		return sendCity;
	}
	public void setReceiveProvince(Integer receiveProvince)
	{
		this.receiveProvince = receiveProvince;
	}

	public Integer getReceiveProvince()
	{
		return receiveProvince;
	}
	public void setReceiveCity(String receiveCity) 
	{
		this.receiveCity = receiveCity;
	}

	public String getReceiveCity() 
	{
		return receiveCity;
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
	public void setCustomerNo(String customerNo) 
	{
		this.customerNo = customerNo;
	}

	public String getCustomerNo() 
	{
		return customerNo;
	}
	public void setCustomerType(Integer customerType) 
	{
		this.customerType = customerType;
	}

	public Integer getCustomerType() 
	{
		return customerType;
	}
	public void setSendName(String sendName) 
	{
		this.sendName = sendName;
	}

	public String getSendName() 
	{
		return sendName;
	}
	public void setSendContacts(String sendContacts) 
	{
		this.sendContacts = sendContacts;
	}

	public String getSendContacts() 
	{
		return sendContacts;
	}
	public void setSendPhone(String sendPhone) 
	{
		this.sendPhone = sendPhone;
	}

	public String getSendPhone() 
	{
		return sendPhone;
	}
	public void setReceiveName(String receiveName) 
	{
		this.receiveName = receiveName;
	}

	public String getReceiveName() 
	{
		return receiveName;
	}
	public void setReceiveContacts(String receiveContacts) 
	{
		this.receiveContacts = receiveContacts;
	}

	public String getReceiveContacts() 
	{
		return receiveContacts;
	}
	public void setReceivePhone(String receivePhone) 
	{
		this.receivePhone = receivePhone;
	}

	public String getReceivePhone() 
	{
		return receivePhone;
	}
	public void setServiceMode(Integer serviceMode) 
	{
		this.serviceMode = serviceMode;
	}

	public Integer getServiceMode() 
	{
		return serviceMode;
	}
	public void setPickUpMileage(Double pickUpMileage) 
	{
		this.pickUpMileage = pickUpMileage;
	}

	public Double getPickUpMileage() 
	{
		return pickUpMileage;
	}
	public void setDeliveryMileage(Double deliveryMileage) 
	{
		this.deliveryMileage = deliveryMileage;
	}

	public Double getDeliveryMileage() 
	{
		return deliveryMileage;
	}
	public void setPickUpDress(String pickUpDress) 
	{
		this.pickUpDress = pickUpDress;
	}

	public String getPickUpDress() 
	{
		return pickUpDress;
	}
	public void setDeliveryDress(String deliveryDress) 
	{
		this.deliveryDress = deliveryDress;
	}

	public String getDeliveryDress() 
	{
		return deliveryDress;
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
	public void setInvoice(Integer invoice)
	{
//		if(invoice instanceof  String){
//			this.invoice="on".equalsIgnoreCase(String.valueOf(invoice))?1:0;
//		}else{
//			String t=String.valueOf(invoice);
//			this.invoice = Integer.parseInt(t);
//		}
		this.invoice=invoice;

	}

	public Integer getInvoice() 
	{
		return invoice;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status=status;

	}
}
