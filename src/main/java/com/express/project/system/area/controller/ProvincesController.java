package com.express.project.system.area.controller;

import java.util.List;

import com.express.project.system.area.domain.Provinces;
import com.express.project.system.area.service.IProvincesService;
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
 * 省份 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/area/provinces")
public class ProvincesController extends BaseController
{
    private String prefix = "area/provinces";
	
	@Autowired
	private IProvincesService provincesService;
	
	@RequiresPermissions("area:provinces:view")
	@GetMapping()
	public String provinces()
	{
	    return prefix + "/provinces";
	}
	
	/**
	 * 查询省份列表
	 */
	@RequiresPermissions("area:provinces:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Provinces provinces)
	{
		startPage();
        List<Provinces> list = provincesService.selectProvincesList(provinces);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出省份列表
	 */
	@RequiresPermissions("area:provinces:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Provinces provinces)
    {
    	List<Provinces> list = provincesService.selectProvincesList(provinces);
        ExcelUtil<Provinces> util = new ExcelUtil<Provinces>(Provinces.class);
        return util.exportExcel(list, "provinces");
    }
	
	/**
	 * 新增省份
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存省份
	 */
	@RequiresPermissions("area:provinces:add")
	@Log(title = "省份", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Provinces provinces)
	{		
		return toAjax(provincesService.insertProvinces(provinces));
	}

	/**
	 * 修改省份
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Provinces provinces = provincesService.selectProvincesById(id);
		mmap.put("provinces", provinces);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存省份
	 */
	@RequiresPermissions("area:provinces:edit")
	@Log(title = "省份", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Provinces provinces)
	{		
		return toAjax(provincesService.updateProvinces(provinces));
	}
	
	/**
	 * 删除省份
	 */
	@RequiresPermissions("area:provinces:remove")
	@Log(title = "省份", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(provincesService.deleteProvincesByIds(ids));
	}
	
}
