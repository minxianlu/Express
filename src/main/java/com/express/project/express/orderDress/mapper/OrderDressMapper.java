package com.express.project.express.orderDress.mapper;

import com.express.project.express.orderDress.domain.OrderDress;
import java.util.List;	

/**
 * 订单地址 数据层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface OrderDressMapper 
{
	/**
     * 查询订单地址信息
     * 
     * @param id 订单地址ID
     * @return 订单地址信息
     */
	public OrderDress selectOrderDressById(Integer id);
	
	/**
     * 查询订单地址列表
     * 
     * @param orderDress 订单地址信息
     * @return 订单地址集合
     */
	public List<OrderDress> selectOrderDressList(OrderDress orderDress);
	
	/**
     * 新增订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	public int insertOrderDress(OrderDress orderDress);
	
	/**
     * 修改订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	public int updateOrderDress(OrderDress orderDress);
	
	/**
     * 删除订单地址
     * 
     * @param id 订单地址ID
     * @return 结果
     */
	public int deleteOrderDressById(Integer id);
	
	/**
     * 批量删除订单地址
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteOrderDressByIds(String[] ids);
	
}