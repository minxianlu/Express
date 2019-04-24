package com.express.project.express.order.domain;

/**
 * @author mxl
 * @title: OrderDTO
 * @projectName Express
 * @description: TODO
 * @date 2019/4/2415:04
 */
public class OrderDTO extends Order {

    /** 发送省份 字符型*/
    private String sendProvinceStr;
    /** 发送城市 字符型*/
    private String sendCityStr;
    /** 接收城市 字符型*/
    private String receiveProvinceStr;
    /** 客户类型 字符型*/
    private String customerTypeStr;
    /** 发送车站 字符型*/
    private String sendStationStr;
    /** 接收站 字符型*/
    private String receiveStationStr;
    /** 是否开票 字符型*/
    private String invoiceStr;
    /** 订单状态 字符型*/
    private String statusStr;


    public String getSendProvinceStr() {
        return sendProvinceStr;
    }

    public void setSendProvinceStr(String sendProvinceStr) {
        this.sendProvinceStr = sendProvinceStr;
    }

    public String getSendCityStr() {
        return sendCityStr;
    }

    public void setSendCityStr(String sendCityStr) {
        this.sendCityStr = sendCityStr;
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
}
