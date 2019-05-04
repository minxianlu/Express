package com.express.project.express.orderDress.controller;

import java.util.*;

import com.express.common.utils.security.ShiroUtils;
import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.system.area.domain.Cities;
import com.express.project.system.area.domain.Provinces;
import com.express.project.system.area.service.ICitiesService;
import com.express.project.system.area.service.IProvincesService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
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
import com.express.project.express.orderDress.domain.OrderDress;
import com.express.project.express.orderDress.service.IOrderDressService;
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.page.TableDataInfo;
import com.express.framework.web.domain.AjaxResult;
import com.express.common.utils.poi.ExcelUtil;

/**
 * 订单地址 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/express/orderDress")
public class OrderDressController extends BaseController
{
    private String prefix = "express/orderDress";
	
	@Autowired
	private IOrderDressService orderDressService;
	@Autowired
	private IProvincesService provincesService;
	@Autowired
	private ICitiesService citiesService;
	
	@RequiresPermissions("express:orderDress:view")
	@GetMapping()
	public String orderDress()
	{
	    return prefix + "/orderDress";
	}
	
	/**
	 * 查询订单地址列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(OrderDress orderDress)
	{
        List<OrderDress> list=new ArrayList<>();
        try {
            startPage();
            list = orderDressService.selectOrderDressList(orderDress);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return getDataTable(list);
	}

	/**
	 * 查询订单地址
	 */
	@GetMapping("/query")
	public String query()
	{
		return prefix + "/queryDress";
	}

	/**
	 * 查询订单结果
	 */
	@PostMapping("/queryDress")
	@ResponseBody
	public AjaxResult queryDress(String orderNo,String sendPhone,String receivePhone)
	{
		AjaxResult ajaxResult=null;
		try {
			Map<String,String> paramsMap=new HashMap<>(5);
			paramsMap.put("orderNo",orderNo);
			paramsMap.put("sendPhone",sendPhone);
			paramsMap.put("receivePhone",receivePhone);
			List<OrderDress> result= orderDressService.queryDress(paramsMap);
			ajaxResult=AjaxResult.success();
			ajaxResult.put("result",result);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult=AjaxResult.error();
		}
		return ajaxResult;
	}
	
	/**
	 * 新增订单地址
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		mmap.put("cityList",citiesService.selectCitiesList(new Cities()));
		mmap.put("proList",provincesService.selectProvincesList(new Provinces()));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存订单地址
	 */
	@Log(title = "订单地址", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(OrderDress orderDress)
	{
		AjaxResult ajaxResult=null;
		try {
			orderDressService.insertOrderDress(orderDress);
			ajaxResult=AjaxResult.success();
		}catch (Exception e){
			e.printStackTrace();
			ajaxResult=AjaxResult.error();
		}
		return ajaxResult;
	}

	/**
	 * 修改订单地址
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		OrderDress orderDress = orderDressService.selectOrderDressById(id);
		mmap.put("orderDress", orderDress);
//		mmap.put("cityList",citiesService.selectCitiesList(new Cities()));
//		mmap.put("proList",provincesService.selectProvincesList(new Provinces()));
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存订单地址
	 */
	@Log(title = "订单地址", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(OrderDress orderDress)
	{
		AjaxResult ajaxResult=new AjaxResult();
		try {
			String[] cityIds = orderDress.getCityId().split(",");
			orderDress.setCityId(cityIds[cityIds.length-1]);
			orderDress.setUpdateTime(new Date());
			orderDress.setUpdateBy(ShiroUtils.getLoginName());
			orderDressService.insertOrderDress(orderDress);
			ajaxResult=AjaxResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult=AjaxResult.error();
		}
		return ajaxResult;

	}
	
	/**
	 * 删除订单地址
	 */
	@Log(title = "订单地址", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(orderDressService.deleteOrderDressByIds(ids));
	}
	
}
