package com.express.project.express.order.service;

import java.util.*;

import com.express.common.exception.BusinessException;
import com.express.common.utils.MapDataUtil;
import com.express.common.utils.StringUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.common.ExpressConstant;
import com.express.project.express.cargo.domain.Cargo;
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
import com.express.project.system.role.domain.Role;
import com.express.project.system.role.service.IRoleService;
import com.express.project.system.user.mapper.UserMapper;
import com.express.project.system.user.mapper.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.order.mapper.OrderMapper;
import com.express.project.express.order.domain.Order;
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
public class OrderServiceImpl implements IOrderService {
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
    @Autowired
    private UserMapper userMapper;


    /**
     * 查询订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    @Override
    public Order selectOrderById(Integer id) {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询订单列表
     *
     * @param order 订单信息
     * @return 订单集合
     */
    @Override
    public List<Order> selectOrderList(Order order) throws Exception {
        //城市编码集合
        List<String> cityIdList = new ArrayList<>();
        //省份编码集合
        List<String> proIdList = new ArrayList<>();
        //货物编码集合
        List<String> cargoNoList = new ArrayList<>();
        //车站Id集合
        List<Integer> stationIdList = new ArrayList<>();
        //字典类型集合
        List<String> dictTypeList = new ArrayList<>();
        dictTypeList.add(ExpressConstant.EX_CUSTOMER_TYPE);
        dictTypeList.add(ExpressConstant.EX_SERVICE_MODE);
        dictTypeList.add(ExpressConstant.EX_ORDER_STATUS);

        String userName=ShiroUtils.getUserName();

        List<Role> roleList= userMapper.selectUserByLoginName(ShiroUtils.getLoginName()).getRoles();
        for (Role role : roleList) {
            if("1".equals(role.getDataScope())){
                if(StringUtils.isNotEmpty(order.getCreateBy())){
                    order.setCreateBy("");
                }
            }else{
                order.setCreateBy(userName);
            }
        }

        List<Order> resultList = orderMapper.selectOrderList(order);
        for (Order order1 : resultList) {
            //拼装城市编码集合
            cityIdList.add(order1.getSendCity());
            cityIdList.add(order1.getReceiveCity());
            //拼装省份编码集合
            proIdList.add(order1.getSendProvince() + "");
            proIdList.add(order1.getReceiveProvince() + "");
            //拼装货物编码集合
            cargoNoList.add(order1.getOrderNo());
            //拼装车站编码集合
            stationIdList.add(order1.getSendStation());
            stationIdList.add(order1.getReceiveStation());
        }
        //省份转换
        Map<String, Provinces> proMap = provincesService.getProvinceMapByProvinceIds(proIdList);
        //城市转换
        Map<String, Cities> cityMap = citiesService.getCityMapByCityIds(cityIdList);
        //车站转换
        Map<String, Station> stationMap = stationService.getStationMapByIds(stationIdList);
        //字典数据转换
        Map<String, DictData> dictDataMap = dictDataService.getDictDataMapByDictType(dictTypeList);

        //货物转换（暂时没用）
        List<Cargo> cargoList = null;
        Map<String, Cargo> cargoMap = new HashMap<>(16);
        if (cargoNoList.size() > 0) {
            cargoList = cargoService.selectCargoByOrderNoList(cargoNoList);
            cargoMap = MapDataUtil.listToMap("cargoNo", cargoList);
        }

        for (Order order1 : resultList) {
            if (proMap.containsKey(order1.getSendProvince() + "")) {
                order1.setSendProvinceStr(proMap.get(order1.getSendProvince() + "").getProvince());
            }
            if (cityMap.containsKey(order1.getSendCity())) {
                order1.setSendCityStr(cityMap.get(order1.getSendCity()).getCity());
            }
            if (stationMap.containsKey(order1.getSendStation() + "")) {
                order1.setSendStationStr(stationMap.get(order1.getSendStation() + "").getStationName());
            }
            if (stationMap.containsKey(order1.getReceiveStation() + "")) {
                order1.setReceiveStationStr(stationMap.get(order1.getReceiveStation() + "").getStationName());
            }
            if (cityMap.containsKey(order1.getReceiveCity())) {
                order1.setReceiveCityStr(cityMap.get(order1.getReceiveCity()).getCity());
            }
            if (proMap.containsKey(order1.getReceiveProvince() + "")) {
                order1.setReceiveProvinceStr(proMap.get(order1.getReceiveProvince() + "").getProvince());
            }
            if (dictDataMap.containsKey(ExpressConstant.EX_CUSTOMER_TYPE + (order1.getCustomerType()))) {
                order1.setCustomerTypeStr(dictDataMap.get(ExpressConstant.EX_CUSTOMER_TYPE + (order1.getCustomerType())).getDictLabel());
            }
            if (dictDataMap.containsKey(ExpressConstant.EX_ORDER_STATUS + (order1.getStatus()))) {
                order1.setStatusStr(dictDataMap.get(ExpressConstant.EX_ORDER_STATUS + (order1.getStatus())).getDictLabel());
            }
            if (dictDataMap.containsKey(ExpressConstant.EX_SERVICE_MODE + (order1.getServiceMode()))) {
                order1.setServiceModeStr(dictDataMap.get(ExpressConstant.EX_SERVICE_MODE + (order1.getServiceMode())).getDictLabel());
            }
            order1.setInvoiceStr(order1.getInvoice() == 0 ? "否" : "是");
            order1.setOrderFlagStr(order1.getOrderFlag() == 0 ? "完结" : "未完结");
            order1.setStatusStr(getOrderStatus(order1.getStatus()));
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
    public void insertOrder(Order order) throws Exception {
        order.setCreateBy(ShiroUtils.getUserName());
        order.setCreateTime(new Date());
        order.setStatus(Integer.parseInt(ExpressConstant.ORDER_NOT_RECEIVED));
        order.setOrderFlag(Integer.parseInt(ExpressConstant.ORDER_FLAG));
        orderMapper.insertOrder(order);

        OrderDress orderDress = new OrderDress();
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
    public void updateOrder(Order order, Cargo cargo) throws Exception {
        if (StringUtils.isEmpty(order.getOrderNo())) {
            throw new BusinessException("订单编号为空");
        }
        order.setUpdateBy(ShiroUtils.getUserName());
        order.setUpdateTime(new Date());
        cargo.setCargoNo(order.getOrderNo());
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
    public int deleteOrderByIds(String ids) {
        return orderMapper.deleteOrderByIds(Convert.toStrArray(ids));
    }


    /**
     * 查询订单信息
     *
     * @param id 订单ID
     * @return 订单信息
     */
    @Override
    public Order selectOrderByIdForDetail(Integer id) throws Exception {
        Order order = new Order();
        order.setId(id);
        List<Order> list = this.selectOrderList(order);
        return list.get(0);
    }

    @Override
    public void signFor(Order order) throws Exception {
        orderMapper.updateOrder(order);
    }

    public String getOrderStatus(Integer status) {
        String s = status + "";
        String result = "";
        switch (s) {
            case ExpressConstant.ORDER_LOSE:
                result = "丢失";
                break;
            case ExpressConstant.ORDER_FLAG_END:
                result = "归档";
                break;
            case ExpressConstant.ORDER_NOT_RECEIVED:
                result = "未签收";
                break;
            case ExpressConstant.ORDER_RECEIVED:
                result = "已签收";
                break;
            default:
                result = s;
        }
        return result;
    }

}
