package com.express.project.express.freightRate.controller;

import java.util.ArrayList;
import java.util.List;

import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.weaver.loadtime.Aj;
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
 * 运价 信息操作处理
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

	@GetMapping("/query")
	public String query(ModelMap mmap){
        try {
            Station station = new Station();
            mmap.put("stationList",stationService.selectStationList(station));
        } catch (Exception e) {
            e.printStackTrace();
        }
	    return prefix+"/queryFreightRate";
	}
    /**
     * 查询运价
     */
    @PostMapping("/queryFreightRate")
    @ResponseBody
	public AjaxResult queryFreightRate(FreightRate  freightRate){
    	AjaxResult ajaxResult=null;
		try {
			List<FreightRate> result= freightRateService.queryFreightRate(freightRate);
			ajaxResult=AjaxResult.success();
			ajaxResult.put("result",result);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult=AjaxResult.error();
		}
		return ajaxResult;
    }
	/**
	 * 查询运价列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(FreightRate freightRate)
	{
		List<FreightRate> list=null;
		try {
			startPage();
			list = freightRateService.selectFreightRateList(freightRate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getDataTable(list);
	}
	
	
	/**
	 * 导出运价列表
	 */
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FreightRate freightRate)
    {
		try {
			List<FreightRate> list = freightRateService.selectFreightRateList(freightRate);
			ExcelUtil<FreightRate> util = new ExcelUtil<FreightRate>(FreightRate.class);
			return util.exportExcel(list, "freightRate");
		} catch (Exception e) {
			e.printStackTrace();
			return AjaxResult.error(e.toString());
		}


    }
	
	/**
	 * 新增运价
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap)
	{
		try {
			Station station = new Station();
			mmap.put("stationList",stationService.selectStationList(station));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prefix + "/add";
	}
	
	/**
	 * 新增保存运价
	 */
	@Log(title = "运价", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(FreightRate freightRate)
	{
		AjaxResult ajaxResult = null;
		try {
			freightRateService.insertFreightRate(freightRate);
			ajaxResult = AjaxResult.success("保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult = AjaxResult.error(e.getMessage());
		}
		return ajaxResult;
	}

	/**
	 * 修改运价
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{

		FreightRate freightRate = null;
		try {
			freightRate = freightRateService.selectFreightRateForDetail(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mmap.put("freightRate", freightRate);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存运价
	 */
	@RequiresPermissions("express:freightRate:edit")
	@Log(title = "运价", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(FreightRate freightRate)
	{
		AjaxResult ajaxResult = null;
		try {
			freightRateService.updateFreightRate(freightRate);
			ajaxResult = AjaxResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult = AjaxResult.error(e.getMessage());
		}
		return ajaxResult;
	}
	
	/**
	 * 删除运价
	 */
	@RequiresPermissions("express:freightRate:remove")
	@Log(title = "运价", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		AjaxResult ajaxResult = null;
		try {
			freightRateService.deleteFreightRateByIds(ids);
			ajaxResult = AjaxResult.success();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult = AjaxResult.error(e.toString());
		}
		return ajaxResult;
	}

	@GetMapping("/getStation")
	@ResponseBody
	public AjaxResult getStation(FreightRate freightRate) {
		AjaxResult ajaxResult=null;
		try {
			List<Station> resultList=freightRateService.selectStationByFreightRate(freightRate);
			ajaxResult=AjaxResult.success();
			ajaxResult.put("station",resultList);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxResult=AjaxResult.error(e.toString());
		}
		return ajaxResult;
	}

	
}
