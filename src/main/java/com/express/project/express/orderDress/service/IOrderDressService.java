package com.express.project.express.orderDress.service;

import com.express.common.exception.BusinessException;
import com.express.project.express.orderDress.domain.OrderDress;
import java.util.List;

/**
 * 订单地址 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IOrderDressService 
{
	/**
     * 查询订单地址信息
     * 
     * @param id 订单地址ID
     * @return 订单地址信息
     */
	 OrderDress selectOrderDressById(Integer id);
	
	/**
     * 查询订单地址列表
     * 
     * @param orderDress 订单地址信息
     * @return 订单地址集合
     */
	 List<OrderDress> selectOrderDressList(OrderDress orderDress);
	
	/**
     * 新增订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	 void insertOrderDress(OrderDress orderDress)throws BusinessException;
	
	/**
     * 修改订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	 int updateOrderDress(OrderDress orderDress);
		
	/**
     * 删除订单地址信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteOrderDressByIds(String ids);
	
}
