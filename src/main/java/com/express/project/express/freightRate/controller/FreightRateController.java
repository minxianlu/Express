package com.express.project.express.freightRate.controller;

import java.util.List;

import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.express.framework.aspectj.lang.annotation.Log;
import com.express.framework.aspectj.lang.enums.BusinessType;
import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.express.freightRate.service.IFreightRateService;
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.page.TableDataInfo;
import com.express.framework.web.domain.AjaxResult;
import com.express.common.utils.poi.ExcelUtil;

/**
 * 运价因子 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/express/freightRate")
public class FreightRateController extends BaseController
{
    private String prefix = "express/freightRate";
	
	@Autowired
	private IFreightRateService freightRateService;
	@Autowired
	private IStationService stationService;
	
	@RequiresPermissions("express:freightRate:view")
	@GetMapping()
	public String freightRate()
	{
	    return prefix + "/freightRate";
	}
	
	/**
	 * 查询运价因子列表
	 */
	@RequiresPermissions("express:freightRate:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FreightRate freightRate)
	{
		startPage();
        List<FreightRate> list = freightRateService.selectFreightRateList(freightRate);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出运价因子列表
	 */
	@RequiresPermissions("express:freightRate:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FreightRate freightRate)
    {
    	List<FreightRate> list = freightRateService.selectFreightRateList(freightRate);
        ExcelUtil<FreightRate> util = new ExcelUtil<FreightRate>(FreightRate.class);
        return util.exportExcel(list, "freightRate");
    }
	
	/**
	 * 新增运价因子
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
        Station station=new Station();
		mmap.put("stationList",stationService.selectStationList(station));
		return prefix + "/add";
	}
	
	/**
	 * 新增保存运价因子
	 */
	@RequiresPermissions("express:freightRate:add")
	@Log(title = "运价因子", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FreightRate freightRate)
	{		
		return toAjax(freightRateService.insertFreightRate(freightRate));
	}

	/**
	 * 修改运价因子
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		FreightRate freightRate = freightRateService.selectFreightRateById(id);
		mmap.put("freightRate", freightRate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存运价因子
	 */
	@RequiresPermissions("express:freightRate:edit")
	@Log(title = "运价因子", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FreightRate freightRate)
	{		
		return toAjax(freightRateService.updateFreightRate(freightRate));
	}
	
	/**
	 * 删除运价因子
	 */
	@RequiresPermissions("express:freightRate:remove")
	@Log(title = "运价因子", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(freightRateService.deleteFreightRateByIds(ids));
	}
	
}
