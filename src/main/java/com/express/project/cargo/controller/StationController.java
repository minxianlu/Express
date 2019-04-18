package com.express.project.cargo.controller;

import java.util.List;

import com.express.project.cargo.domain.Station;
import com.express.project.cargo.service.IStationService;
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
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.page.TableDataInfo;
import com.express.framework.web.domain.AjaxResult;
import com.express.common.utils.poi.ExcelUtil;

/**
 * 车站 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/cargo/station")
public class StationController extends BaseController
{
    private String prefix = "cargo/station";
	
	@Autowired
	private IStationService stationService;
	
	@RequiresPermissions("cargo:station:view")
	@GetMapping()
	public String station()
	{
	    return prefix + "/station";
	}
	
	/**
	 * 查询车站列表
	 */
	@RequiresPermissions("cargo:station:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Station station)
	{
		startPage();
        List<Station> list = stationService.selectStationList(station);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出车站列表
	 */
	@RequiresPermissions("cargo:station:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Station station)
    {
    	List<Station> list = stationService.selectStationList(station);
        ExcelUtil<Station> util = new ExcelUtil<Station>(Station.class);
        return util.exportExcel(list, "station");
    }
	
	/**
	 * 新增车站
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车站
	 */
	@RequiresPermissions("cargo:station:add")
	@Log(title = "车站", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Station station)
	{		
		return toAjax(stationService.insertStation(station));
	}

	/**
	 * 修改车站
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Station station = stationService.selectStationById(id);
		mmap.put("station", station);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车站
	 */
	@RequiresPermissions("cargo:station:edit")
	@Log(title = "车站", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Station station)
	{		
		return toAjax(stationService.updateStation(station));
	}
	
	/**
	 * 删除车站
	 */
	@RequiresPermissions("cargo:station:remove")
	@Log(title = "车站", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(stationService.deleteStationByIds(ids));
	}
	
}
