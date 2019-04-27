package com.express.project.express.order.domain;


import com.express.framework.aspectj.lang.annotation.Excel;
import com.express.framework.web.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	@Excel(name = "订单编号")
	private String orderNo;
	/** 发货日期 */
	@Excel(name = "发货日期")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sendTime;

	/** 发送省份 字符型*/
	@Excel(name = "发送省份")
	private String sendProvinceStr;
	@Excel(name = "发送城市")
	private String sendCityStr;
	/** 接收省份 字符型*/
	@Excel(name = "接收省份")
	private String receiveProvinceStr;
	@Excel(name = "接收城市")


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
	@Excel(name = "客户编码")
	private String customerNo;
	/** 客户类型 */
	private Integer customerType;
	/** 发货人名称 */
	@Excel(name = "发货人名称")
	private String sendName;
	/** 发货联系人 */
	@Excel(name = "发货联系人")
	private String sendContacts;
	/** 发货人电话 */
	@Excel(name = "发货人电话")
	private String sendPhone;
	/** 收货人名称 */
	@Excel(name = "收货人名称")
	private String receiveName;
	/** 收货联系人 */
	@Excel(name = "收货联系人")
	private String receiveContacts;
	/** 接收人电话 */
	@Excel(name = "接收人电话")
	private String receivePhone;
	/** 服务方式 */
	private Integer serviceMode;
	/** 送货里程 */
	@Excel(name = "送货里程")
	private Double pickUpMileage;
	/** 送货里程 */
	@Excel(name = "送货里程")
	private Double deliveryMileage;
	/** 取货地址 */
	@Excel(name = "取货地址")
	private String pickUpDress;
	/** 送货地址 */
	@Excel(name = "送货地址")
	private String deliveryDress;
	/** 货物Id */
	private Integer cargoId;
	/** 货物编号 */
	private String cargoNo;
	/** 是否开具发票 */
	private Integer invoice;
	/** 状态 */
	private Integer status;


	private String receiveCityStr;
	/** 客户类型 字符型*/
	@Excel(name = "客户类型")
	private String customerTypeStr;
	/** 发送车站 字符型*/
	@Excel(name = "发送车站")
	private String sendStationStr;
	/** 接收站 字符型*/
	@Excel(name = "接收站")
	private String receiveStationStr;
	/** 是否开票 字符型*/
	@Excel(name = "是否开票")
	private String invoiceStr;
	/** 订单状态 字符型*/
	@Excel(name = "订单状态")
	private String statusStr;
	/** 服务类型 字符型*/
	@Excel(name = "服务类型")
	private String serviceModeStr;


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


	public String getSendProvinceStr() {
		return sendProvinceStr;
	}

	public void setSendProvinceStr(String sendProvinceStr) {
		this.sendProvinceStr = sendProvinceStr;
	}

	public String getReceiveProvinceStr() {
		return receiveProvinceStr;
	}

	public void setReceiveProvinceStr(String receiveProvinceStr) {
		this.receiveProvinceStr = receiveProvinceStr;
	}

	public String getCustomerTypeStr() {
		return customerTypeStr;
	}

	public void setCustomerTypeStr(String customerTypeStr) {
		this.customerTypeStr = customerTypeStr;
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

	public String getInvoiceStr() {
		return invoiceStr;
	}

	public void setInvoiceStr(String invoiceStr) {
		this.invoiceStr = invoiceStr;
	}

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	public String getServiceModeStr() {
		return serviceModeStr;
	}

	public void setServiceModeStr(String serviceModeStr) {
		this.serviceModeStr = serviceModeStr;
	}

	public String getSendCityStr() {
		return sendCityStr;
	}

	public void setSendCityStr(String sendCityStr) {
		this.sendCityStr = sendCityStr;
	}

	public String getReceiveCityStr() {
		return receiveCityStr;
	}

	public void setReceiveCityStr(String receiveCityStr) {
		this.receiveCityStr = receiveCityStr;
	}
}
