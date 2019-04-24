package com.express.project.express.order.service;

import java.util.*;

import com.express.common.constant.ExpressConstants;
import com.express.common.exception.BusinessException;
import com.express.common.utils.MapDataUtil;
import com.express.common.utils.StringUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.express.cargo.domain.Cargo;
import com.express.project.express.cargo.service.CargoServiceImpl;
import com.express.project.express.cargo.service.ICargoService;
import com.express.project.express.orderDress.domain.OrderDress;
import com.express.project.express.orderDress.service.IOrderDressService;
import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.domain.Provinces;
import com.express.project.system.area.service.ICitiesService;
import com.express.project.system.area.service.IProvincesService;
import com.express.project.system.dict.domain.DictData;
import com.express.project.system.dict.service.IDictDataService;
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
	@Autowired
	private IProvincesService provincesService;
	@Autowired
	private ICitiesService citiesService;
	@Autowired
	private IDictDataService dictDataService;
	@Autowired
	private IStationService stationService;

	//客户类型
	private final String EX_CUSTOMER_TYPE="ex_customer_type";
	//订单状态
	private final String EX_ORDER_STATUS="ex_order_status";
	//服务方式
	private final String EX_SERVICE_MODE="ex_service_mode";

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
	public List<Order> selectOrderList(Order order)throws Exception
	{
		//城市编码集合
		List<String> cityIdList=new ArrayList<>();
		//省份编码集合
		List<String> proIdList=new ArrayList<>();
		//货物编码集合
		List<String> cargoNoList=new ArrayList<>();
		//车站Id集合
		List<Integer> stationIdList=new ArrayList<>();
		//字典类型集合
		List<String> dictTypeList=new ArrayList<>();
		dictTypeList.add(EX_CUSTOMER_TYPE);
		dictTypeList.add(EX_SERVICE_MODE);
		dictTypeList.add(EX_ORDER_STATUS);

		List<Order> resultList=orderMapper.selectOrderList(order);
		for (Order order1 : resultList) {
			cityIdList.add(order1.getSendCity());
			cityIdList.add(order1.getReceiveCity());

			proIdList.add(order1.getSendProvince()+"");
			proIdList.add(order1.getReceiveProvince()+"");

			cargoNoList.add(order1.getCargoNo());

			stationIdList.add(order1.getSendStation());
			stationIdList.add(order1.getReceiveStation());
		}
		//省份转换
		List<Provinces> provincesList=null;
		Map<String,Provinces> proMap=new HashMap<>(16);
		if(proIdList.size()>0){
			provincesList=provincesService.selectProvinceByProvinceIds(proIdList);
			proMap=MapDataUtil.listToMap("provinceid",provincesList);
		}
		//城市转换
		List<Cities> cityList=null;
		Map<String,Cities> cityMap=new HashMap<>(16);
		if(cityIdList.size()>0){
			cityList=citiesService.selectCityByCityIds(cityIdList);
			cityMap=MapDataUtil.listToMap("cityid",cityList);
		}
		//货物转换
		List<Cargo> cargoList=null;
		Map<String,Cargo> cargoMap=new HashMap<>(16);
		if(cargoNoList.size()>0){
			cargoList=cargoService.selectCargoByOrderNoList(cargoNoList);
			cargoMap=MapDataUtil.listToMap("cargoNo",cargoList);
		}

		List<Station> stationList=null;
		Map<String,Station> stationMap=new HashMap<>(16);
		if(stationIdList.size()>0){
			stationList=stationService.selectStationByIds(stationIdList);
			stationMap=MapDataUtil.listToMap("id",stationList);
		}

		List<DictData> dictDataList=null;
		Map<String,DictData> dictDataMap=new HashMap<>(16);
		if(dictTypeList.size()>0){
			dictDataList=dictDataService.selectDictDataByDictTypeList(dictTypeList);
			for (DictData dict : dictDataList) {
				dictDataMap.put(dict.getDictType()+dict.getDictValue(),dict);
			}
		}

		for (Order order1 : resultList) {
			order1.setSendProvinceStr(proMap.get(order1.getSendProvince()).getProvince());
			order1.setSendCityStr(cityMap.get(order1.getSendCity()).getCity());
			order1.setSendStationStr(stationMap.get(order1.getSendStation()).getStationName());

			order1.setReceiveStationStr(stationMap.get(order1.getReceiveStation()).getStationName());
			order1.setReceiveCity(cityMap.get(order1.getReceiveCity()).getCity());
			order1.setReceiveProvinceStr(proMap.get(order1.getReceiveProvince()).getProvince());

			order1.setInvoiceStr(order1.getInvoice()==0?"否":"是");

			order1.setCustomerTypeStr(dictDataMap.get(EX_CUSTOMER_TYPE+(order1.getCustomerType())).getDictLabel());
			order1.setStatusStr(dictDataMap.get(EX_ORDER_STATUS+(order1.getStatus())).getDictLabel());
			order1.setServiceModeStr(dictDataMap.get(EX_SERVICE_MODE+(order1.getServiceMode())).getDictLabel());
		}

	    return resultList;
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
		order.setCreateBy(ShiroUtils.getUserName());
		order.setCreateTime(new Date());
		order.setStatus(ExpressConstants.ORDER_STATUS);

		orderMapper.insertOrder(order);

		OrderDress orderDress=new OrderDress();
		orderDress.setOrderId(order.getId());
		orderDress.setOrderNo(order.getOrderNo());
		orderDress.setProvinceId(order.getSendProvince());
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
		cargoService.insertCargo(cargo);
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
