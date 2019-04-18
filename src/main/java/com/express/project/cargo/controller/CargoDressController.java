package com.express.project.cargo.controller;

import java.util.List;

import com.express.project.cargo.domain.CargoDress;
import com.express.project.cargo.service.ICargoDressService;
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
 * 货物地址 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/cargo/cargoDress")
public class CargoDressController extends BaseController
{
    private String prefix = "cargo/cargoDress";
	
	@Autowired
	private ICargoDressService cargoDressService;
	
	@RequiresPermissions("cargo:cargoDress:view")
	@GetMapping()
	public String cargoDress()
	{
	    return prefix + "/cargoDress";
	}
	
	/**
	 * 查询货物地址列表
	 */
	@RequiresPermissions("cargo:cargoDress:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(CargoDress cargoDress)
	{
		startPage();
        List<CargoDress> list = cargoDressService.selectCargoDressList(cargoDress);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出货物地址列表
	 */
	@RequiresPermissions("cargo:cargoDress:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CargoDress cargoDress)
    {
    	List<CargoDress> list = cargoDressService.selectCargoDressList(cargoDress);
        ExcelUtil<CargoDress> util = new ExcelUtil<CargoDress>(CargoDress.class);
        return util.exportExcel(list, "cargoDress");
    }
	
	/**
	 * 新增货物地址
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存货物地址
	 */
	@RequiresPermissions("cargo:cargoDress:add")
	@Log(title = "货物地址", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(CargoDress cargoDress)
	{		
		return toAjax(cargoDressService.insertCargoDress(cargoDress));
	}

	/**
	 * 修改货物地址
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		CargoDress cargoDress = cargoDressService.selectCargoDressById(id);
		mmap.put("cargoDress", cargoDress);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存货物地址
	 */
	@RequiresPermissions("cargo:cargoDress:edit")
	@Log(title = "货物地址", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(CargoDress cargoDress)
	{		
		return toAjax(cargoDressService.updateCargoDress(cargoDress));
	}
	
	/**
	 * 删除货物地址
	 */
	@RequiresPermissions("cargo:cargoDress:remove")
	@Log(title = "货物地址", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cargoDressService.deleteCargoDressByIds(ids));
	}
	
}
