package com.express.project.express.order.controller;

import java.util.List;

import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.service.ICitiesService;
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
	
	@RequiresPermissions("express:order:view")
	@GetMapping()
	public String order()
	{
	    return prefix + "/order";
	}
	
	/**
	 * 查询订单列表
	 */
	@RequiresPermissions("express:order:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Order order)
	{
		startPage();
        List<Order> list = orderService.selectOrderList(order);
		return getDataTable(list);
	}

	/**
	 * 通过省份查询城市，暂时没想多什么好的方法通过shiro来实现二级联动
	 */
	@RequiresPermissions("express:order:list")
	@PostMapping("/getCityByProvinceId")
	@ResponseBody
	public List<Cities> getCityByProvinceId(String provinceId){
		Cities city=new Cities();
		city.setProvinceid(provinceId);
		List<Cities> list=citiesService.selectCitiesList(city);
		return list;
	}

	/**
	 * 导出订单列表
	 */
	@RequiresPermissions("express:order:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Order order)
    {
    	List<Order> list = orderService.selectOrderList(order);
        ExcelUtil<Order> util = new ExcelUtil<Order>(Order.class);
        return util.exportExcel(list, "order");
    }
	
	/**
	 * 新增订单
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("station",stationService.selectStationList(new Station()));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存订单
	 */
	@RequiresPermissions("express:order:add")
	@Log(title = "订单", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Order order)
	{
		AjaxResult ajaxResult=null;
		try {
			orderService.insertOrder(order);
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
		Order order = orderService.selectOrderById(id);
		mmap.put("order", order);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单
	 */
	@RequiresPermissions("express:order:edit")
	@Log(title = "订单", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Order order)
	{		
		return toAjax(orderService.updateOrder(order));
	}
	
	/**
	 * 删除订单
	 */
	@RequiresPermissions("express:order:remove")
	@Log(title = "订单", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(orderService.deleteOrderByIds(ids));
	}
	
}