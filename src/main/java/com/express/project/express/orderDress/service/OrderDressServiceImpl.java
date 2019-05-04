package com.express.project.express.orderDress.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.express.common.exception.BusinessException;
import com.express.common.utils.StringUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.domain.Provinces;
import com.express.project.system.area.service.ICitiesService;
import com.express.project.system.area.service.IProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.orderDress.mapper.OrderDressMapper;
import com.express.project.express.orderDress.domain.OrderDress;
import com.express.project.express.orderDress.service.IOrderDressService;
import com.express.common.utils.text.Convert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	@Autowired
	private IProvincesService provinceService;
	@Autowired
	private ICitiesService citiesService;

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
	public List<OrderDress> selectOrderDressList(OrderDress orderDress)throws Exception
	{

		List<String> cityList=new ArrayList<>();

		List<String> proList=new ArrayList<>();

		List<OrderDress> list=orderDressMapper.selectVoList(orderDress);
		for (OrderDress dress : list) {
			proList.add(dress.getProvinceId()+"");

			cityList.add(dress.getCityId());
		}
		Map<String,Cities> cityMap=citiesService.getCityMapByCityIds(cityList);

		Map<String,Provinces> proMap=provinceService.getProvinceMapByProvinceIds(proList);

		for (OrderDress dress : list) {
			if(cityMap.containsKey(dress.getCityId())){
				dress.setCityStr(cityMap.get(dress.getCityId()).getCity());
			}
			if(proMap.containsKey(dress.getProvinceId()+"")){
				dress.setProvinceStr(proMap.get(dress.getProvinceId()+"").getProvince());
			}
		}

	    return list;
	}
	
    /**
     * 新增订单地址
     * 
     * @param orderDress 订单地址信息
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertOrderDress(OrderDress orderDress)throws BusinessException
	{
		orderDress.setCreateBy(ShiroUtils.getUserName());
		orderDress.setCreateTime(new Date());
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
		orderDress.setUpdateBy(ShiroUtils.getUserName());
		orderDress.setUpdateTime(new Date());
		return orderDressMapper.updateOrderDress(orderDress);
	}

	/**
     * 删除订单地址对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int deleteOrderDressByIds(String ids)
	{
		return orderDressMapper.deleteOrderDressByIds(Convert.toStrArray(ids));
	}


	@Override
	public List<OrderDress> queryDress(Map<String, String> params) throws Exception {
		List<OrderDress> result= orderDressMapper.queryDress(params);

		List<String> proList=new ArrayList<>();

		List<String> cityList=new ArrayList<>();

		for (OrderDress orderDress : result) {
			proList.add(orderDress.getProvinceId()+"");
			cityList.add(orderDress.getCityId());
		}

		Map<String, Provinces> proMap=provinceService.getProvinceMapByProvinceIds(proList);

		Map<String, Cities> cityMap=citiesService.getCityMapByCityIds(cityList);

		for (OrderDress orderDress : result) {
			if(proMap.containsKey(orderDress.getProvinceId()+"")){
				orderDress.setProvinceStr(proMap.get(orderDress.getProvinceId()+"").getProvince());
			}
			if(cityMap.containsKey(orderDress.getCityId())){
				orderDress.setCityStr(cityMap.get(orderDress.getCityId()).getCity());
			}
			if(StringUtils.isEmpty(orderDress.getRemark())){
				orderDress.setRemark("无");
			}
			if(StringUtils.isEmpty(orderDress.getDress())){
				orderDress.setDress("无");
			}
		}
		return result;
	}
}
