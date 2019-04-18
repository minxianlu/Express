package com.express.project.cargo.domain;


import com.express.framework.web.domain.BaseEntity;

import java.util.Date;

/**
 * 货物表 ex_cargo
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
public class Cargo extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 主键Id */
	private Integer id;
	/** 货物编号 */
	private String cargoNo;
	/** 发货日期 */
	private Date sendTime;
	/** 发送省份 */
	private Integer sendPriovince;
	/** 发送城市 */
	private String sendCity;
	/** 接收省份 */
	private Integer receivePriovince;
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
	/** 货物名称1 */
	private String cargoName1;
	/** 包装1 */
	private String pack1;
	/** 数量1 */
	private Integer num1;
	/** 总重1 */
	private Double weight1;
	/** 保价1 */
	private Double insurance1;
	/** 计费重量1 */
	private Double billingWeight1;
	/** 单个最大重量1 */
	private Double singleMaxWeight1;
	/** 长1 */
	private Double length1;
	/** 宽1 */
	private Double width1;
	/** 高1 */
	private Double height1;
	/** 体积1 */
	private Double volume1;
	/** 货物名称2 */
	private String cargoName2;
	/** 包装2 */
	private String pack2;
	/** 数量2 */
	private Integer num2;
	/** 总重2 */
	private Double weight2;
	/** 保价2 */
	private Double insurance2;
	/** 计费总重2 */
	private Double billingWeight2;
	/** 单个最大重量2 */
	private Double singleMaxWeight2;
	/** 长2 */
	private Double length2;
	/** 宽2 */
	private Double width2;
	/** 高2 */
	private Double height2;
	/** 体积2 */
	private Double volume2;
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
	/** 商议事项 */
	private String remark;
	/** 是否开具发票 */
	private Integer invoice;
	/** 状态；0-丢失；1-未签收；2-已签收；关联字典表 */
	private Integer status;
	/** 创建人 */
	private String createBy;
	/** 更新人 */
	private String updateBy;
	/** 创建时间 */
	private Date createDate;
	/** 更新时间 */
	private Date updateDate;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setCargoNo(String cargoNo) 
	{
		this.cargoNo = cargoNo;
	}

	public String getCargoNo() 
	{
		return cargoNo;
	}
	public void setSendTime(Date sendTime) 
	{
		this.sendTime = sendTime;
	}

	public Date getSendTime() 
	{
		return sendTime;
	}
	public void setSendPriovince(Integer sendPriovince) 
	{
		this.sendPriovince = sendPriovince;
	}

	public Integer getSendPriovince() 
	{
		return sendPriovince;
	}
	public void setSendCity(String sendCity) 
	{
		this.sendCity = sendCity;
	}

	public String getSendCity() 
	{
		return sendCity;
	}
	public void setReceivePriovince(Integer receivePriovince) 
	{
		this.receivePriovince = receivePriovince;
	}

	public Integer getReceivePriovince() 
	{
		return receivePriovince;
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
	public void setCargoName1(String cargoName1) 
	{
		this.cargoName1 = cargoName1;
	}

	public String getCargoName1() 
	{
		return cargoName1;
	}
	public void setPack1(String pack1) 
	{
		this.pack1 = pack1;
	}

	public String getPack1() 
	{
		return pack1;
	}
	public void setNum1(Integer num1) 
	{
		this.num1 = num1;
	}

	public Integer getNum1() 
	{
		return num1;
	}
	public void setWeight1(Double weight1) 
	{
		this.weight1 = weight1;
	}

	public Double getWeight1() 
	{
		return weight1;
	}
	public void setInsurance1(Double insurance1) 
	{
		this.insurance1 = insurance1;
	}

	public Double getInsurance1() 
	{
		return insurance1;
	}
	public void setBillingWeight1(Double billingWeight1) 
	{
		this.billingWeight1 = billingWeight1;
	}

	public Double getBillingWeight1() 
	{
		return billingWeight1;
	}
	public void setSingleMaxWeight1(Double singleMaxWeight1) 
	{
		this.singleMaxWeight1 = singleMaxWeight1;
	}

	public Double getSingleMaxWeight1() 
	{
		return singleMaxWeight1;
	}
	public void setLength1(Double length1) 
	{
		this.length1 = length1;
	}

	public Double getLength1() 
	{
		return length1;
	}
	public void setWidth1(Double width1) 
	{
		this.width1 = width1;
	}

	public Double getWidth1() 
	{
		return width1;
	}
	public void setHeight1(Double height1) 
	{
		this.height1 = height1;
	}

	public Double getHeight1() 
	{
		return height1;
	}
	public void setVolume1(Double volume1) 
	{
		this.volume1 = volume1;
	}

	public Double getVolume1() 
	{
		return volume1;
	}
	public void setCargoName2(String cargoName2) 
	{
		this.cargoName2 = cargoName2;
	}

	public String getCargoName2() 
	{
		return cargoName2;
	}
	public void setPack2(String pack2) 
	{
		this.pack2 = pack2;
	}

	public String getPack2() 
	{
		return pack2;
	}
	public void setNum2(Integer num2) 
	{
		this.num2 = num2;
	}

	public Integer getNum2() 
	{
		return num2;
	}
	public void setWeight2(Double weight2) 
	{
		this.weight2 = weight2;
	}

	public Double getWeight2() 
	{
		return weight2;
	}
	public void setInsurance2(Double insurance2) 
	{
		this.insurance2 = insurance2;
	}

	public Double getInsurance2() 
	{
		return insurance2;
	}
	public void setBillingWeight2(Double billingWeight2) 
	{
		this.billingWeight2 = billingWeight2;
	}

	public Double getBillingWeight2() 
	{
		return billingWeight2;
	}
	public void setSingleMaxWeight2(Double singleMaxWeight2) 
	{
		this.singleMaxWeight2 = singleMaxWeight2;
	}

	public Double getSingleMaxWeight2() 
	{
		return singleMaxWeight2;
	}
	public void setLength2(Double length2) 
	{
		this.length2 = length2;
	}

	public Double getLength2() 
	{
		return length2;
	}
	public void setWidth2(Double width2) 
	{
		this.width2 = width2;
	}

	public Double getWidth2() 
	{
		return width2;
	}
	public void setHeight2(Double height2) 
	{
		this.height2 = height2;
	}

	public Double getHeight2() 
	{
		return height2;
	}
	public void setVolume2(Double volume2) 
	{
		this.volume2 = volume2;
	}

	public Double getVolume2() 
	{
		return volume2;
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
	public void setRemark(String remark) 
	{
		this.remark = remark;
	}

	public String getRemark() 
	{
		return remark;
	}
	public void setInvoice(Integer invoice) 
	{
		this.invoice = invoice;
	}

	public Integer getInvoice() 
	{
		return invoice;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
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
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}

	public Date getCreateDate() 
	{
		return createDate;
	}
	public void setUpdateDate(Date updateDate) 
	{
		this.updateDate = updateDate;
	}

	public Date getUpdateDate() 
	{
		return updateDate;
	}


}
