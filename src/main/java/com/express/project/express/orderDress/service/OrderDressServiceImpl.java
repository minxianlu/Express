package com.express.project.express.orderDress.service;

import java.util.Date;
import java.util.List;

import com.express.common.exception.BusinessException;
import com.express.common.utils.security.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.orderDress.mapper.OrderDressMapper;
import com.express.project.express.orderDress.domain.OrderDress;
import com.express.project.express.orderDress.service.IOrderDressService;
import com.express.common.utils.text.Convert;

/**
 * 订单地址 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Service
public class OrderDressServiceImpl implements IOrderDressService 
{
	@Autowired
	private OrderDressMapper orderDressMapper;

	/**
     * 查询订单地址信息
     * 
     * @param id 订单地址ID
     * @return 订单地址信息
     */
    @Override
	public OrderDress selectOrderDressById(Integer id)
	{
	    return orderDressMapper.selectOrderDressById(id);
	}
	
	/**
     * 查询订单地址列表
     * 
     * @param orderDress 订单地址信息
     * @return 订单地址集合
     */
	@Override
	public List<OrderDress> selectOrderDressList(OrderDress orderDress)
	{
	    return orderDressMapper.selectOrderDressList(orderDress);
	}
	
    /**
     * 新增订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	@Override
	public void insertOrderDress(OrderDress orderDress)throws BusinessException
	{
		orderDress.setUpdateBy(ShiroUtils.getLoginName());
		orderDress.setUpdateTime(new Date());
		orderDressMapper.insertOrderDress(orderDress);
	}
	
	/**
     * 修改订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	@Override
	public int updateOrderDress(OrderDress orderDress)
	{
	    return orderDressMapper.updateOrderDress(orderDress);
	}

	/**
     * 删除订单地址对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrderDressByIds(String ids)
	{
		return orderDressMapper.deleteOrderDressByIds(Convert.toStrArray(ids));
	}
	
}
