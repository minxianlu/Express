package com.express.project.express.order.service;

import java.util.Date;
import java.util.List;

import com.express.common.constant.ExpressConstants;
import com.express.common.exception.BusinessException;
import com.express.common.utils.StringUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.express.cargo.domain.Cargo;
import com.express.project.express.cargo.service.CargoServiceImpl;
import com.express.project.express.cargo.service.ICargoService;
import com.express.project.express.orderDress.domain.OrderDress;
import com.express.project.express.orderDress.service.IOrderDressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.order.mapper.OrderMapper;
import com.express.project.express.order.domain.Order;
import com.express.project.express.order.service.IOrderService;
import com.express.common.utils.text.Convert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Service
public class OrderServiceImpl implements IOrderService 
{
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private IOrderDressService orderDressService;
	@Autowired
	private ICargoService cargoService;

	/**
     * 查询订单信息
     * 
     * @param id 订单ID
     * @return 订单信息
     */
    @Override
	public Order selectOrderById(Integer id)
	{
	    return orderMapper.selectOrderById(id);
	}
	
	/**
     * 查询订单列表
     * 
     * @param order 订单信息
     * @return 订单集合
     */
	@Override
	public List<Order> selectOrderList(Order order)
	{
	    return orderMapper.selectOrderList(order);
	}
	
    /**
     * 新增订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertOrder(Order order) throws Exception
	{
		order.setCreateBy(ShiroUtils.getLoginName());
		order.setCreateTime(new Date());
		order.setStatus(ExpressConstants.ORDER_STATUS);

		orderMapper.insertOrder(order);

		OrderDress orderDress=new OrderDress();
		orderDress.setOrderId(order.getId());
		orderDress.setOrderNo(order.getOrderNo());
		orderDress.setProvinceId(order.getSendPriovince());
		orderDress.setCityId(order.getSendCity());

		orderDressService.insertOrderDress(orderDress);

	}
	
	/**
     * 修改订单
     * 
     * @param order 订单信息
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateOrder(Order order, Cargo cargo)throws Exception
	{
		if(StringUtils.isEmpty(order.getOrderNo())){
			throw new BusinessException("订单编号为空");
		}
		cargoService.deleteCargoByOrderNo(order.getOrderNo());
		 orderMapper.updateOrder(order);
	}

	/**
     * 删除订单对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteOrderByIds(String ids)
	{
		return orderMapper.deleteOrderByIds(Convert.toStrArray(ids));
	}
	
}
