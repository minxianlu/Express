package com.express.project.express.order.service;

import com.express.common.exception.BusinessException;
import com.express.project.express.cargo.domain.Cargo;
import com.express.project.express.order.domain.Order;
import java.util.List;

/**
 * 订单 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IOrderService 
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
	 List<Order> selectOrderList(Order order)throws Exception;
	
	/**
     * 新增订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	 void insertOrder(Order order)throws Exception;
	
	/**
     * 修改订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	 void updateOrder(Order order, Cargo cargo)throws  Exception;
		
	/**
     * 删除订单信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteOrderByIds(String ids);
	
}
