package com.express.project.express.order.mapper;

import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.express.order.domain.Order;
import java.util.List;	

/**
 * 订单 数据层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface OrderMapper 
{
	/**
     * 查询订单信息
     * 
     * @param id 订单ID
     * @return 订单信息
     */
	 Order selectOrderById(Integer id);
	
	/**
     * 查询订单列表
     * 
     * @param order 订单信息
     * @return 订单集合
     */
	 List<Order> selectOrderList(Order order);
	
	/**
     * 新增订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	 int insertOrder(Order order);
	
	/**
     * 修改订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	 int updateOrder(Order order);
	
	/**
     * 删除订单
     * 
     * @param id 订单ID
     * @return 结果
     */
	 int deleteOrderById(Integer id);
	
	/**
     * 批量删除订单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteOrderByIds(String[] ids);

}