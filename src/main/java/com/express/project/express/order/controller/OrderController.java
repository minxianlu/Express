package com.express.project.express.order.controller;

import java.util.List;

import com.express.common.utils.DateUtils;
import com.express.project.common.ExpressConstant;
import com.express.project.express.cargo.domain.Cargo;
import com.express.project.express.cargo.service.ICargoService;
import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.service.ICitiesService;
import com.sun.jna.platform.win32.Secur32;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.express.framework.aspectj.lang.annotation.Log;
import com.express.framework.aspectj.lang.enums.BusinessType;
import com.express.project.express.order.domain.Order;
import com.express.project.express.order.service.IOrderService;
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.page.TableDataInfo;
import com.express.framework.web.domain.AjaxResult;
import com.express.common.utils.poi.ExcelUtil;

/**
 * 订单 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/express/order")
public class OrderController extends BaseController
{
    private String prefix = "express/order";
	
	@Autowired
	private IOrderService orderService;

	@Autowired
	private IStationService stationService;

	@Autowired
	private ICitiesService citiesService;
//    express:order:list
	@Autowired
	private ICargoService cargoService;
	
	@GetMapping()
	public String order()
	{
	    return prefix + "/order";
	}
	
	/**
	 * 查询订单列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Order order)
	{
		List<Order> list=null;
		try {
			startPage();
			list= orderService.selectOrderList(order);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDataTable(list);
	}

	@GetMapping("/detail/{orderId}")
	public String detail(@PathVariable("orderId") Integer orderId, ModelMap mmap)
	{
		try {
			Order order = orderService.selectOrderByIdForDetail(orderId);
			Cargo cargo=new Cargo();
			cargo.setCargoNo(order.getOrderNo());
			List<Cargo> cargoList=cargoService.selectCargoList(cargo);
			mmap.put("order",order );
			if(cargoList.size()>0){
				mmap.put("cargo",cargoList.get(0) );
			}else{
				mmap.put("cargo",new Cargo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "express/order/detail";
	}
	/**
	 * 导出订单列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Order order)
    {
		List<Order> list = null;
		try {
			list = orderService.selectOrderList(order);
			for (Order order1 : list) {
				String d=DateUtils.parseDateToStr("yyyy-MM-dd HH:mm:ss",order1.getSendTime());
				order1.setSendTimeStr(d);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        return util.exportExcel(list, "order");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		try {
			mmap.put("station",stationService.selectStationList(new Station()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/saveAdd")
	@ResponseBody
	public AjaxResult addSave(Order order, Cargo cargo)
	{
		AjaxResult ajaxResult=null;
		try {
			orderService.insertOrder(order);
			cargo.setCargoNo(order.getOrderNo());
			cargoService.insertCargo(cargo);
			ajaxResult=AjaxResult.success();
		}catch (Exception e){
			e.printStackTrace();
			ajaxResult=AjaxResult.error();
		}
		return ajaxResult;
	}

	/**
	 * 修改订单
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		try {
			Order order = orderService.selectOrderByIdForDetail(id);
			Cargo cargo=new Cargo();
			cargo.setCargoNo(order.getOrderNo());
			List<Cargo> cargoList=cargoService.selectCargoList(cargo);
			mmap.put("order",order );
			mmap.put("station",stationService.selectStationList(new Station()));
			if(cargoList.size()>0){
				mmap.put("cargo",cargoList.get(0) );
			}else{
				mmap.put("cargo",new Cargo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Order order,Cargo cargo)
	{
		AjaxResult ajaxResult=null;
		try {
			String[] receiverCity=order.getReceiveCity().split(",");
			order.setReceiveCity(receiverCity[receiverCity.length-1]);
			orderService.updateOrder(order,cargo);
			ajaxResult=AjaxResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult=AjaxResult.error(e.getMessage());
		}
		return ajaxResult;
	}
	
	/**
	 * 删除订单
	 */
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		

		return toAjax(orderService.deleteOrderByIds(ids));
	}
	/**
	 * 删除订单
	 */
	@PostMapping( "/signFor")
	@ResponseBody
	public AjaxResult signFor(String id)
	{
		try {
			Order order= new Order();
			order.setId(Integer.parseInt(id));
			order.setStatus(Integer.parseInt(ExpressConstant.ORDER_RECEIVED));
			orderService.signFor(order);
			return success();
		} catch (Exception e) {
			e.printStackTrace();
			return error(e.getMessage());
		}
	}

	
}
