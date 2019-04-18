package com.express.project.cargo.controller;

import java.util.List;

import com.express.project.cargo.domain.Cargo;
import com.express.project.cargo.service.ICargoService;
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
 * 货物 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/cargo/cargo")
public class CargoController extends BaseController
{
    private String prefix = "cargo";
	
	@Autowired
	private ICargoService cargoService;
	
	@RequiresPermissions("cargo:cargo:view")
	@GetMapping()
	public String cargo()
	{
//	    System.out.println(prefix + "/cargo");
		return prefix + "/cargo";
	}
	
	/**
	 * 查询货物列表
	 */
	@RequiresPermissions("cargo:cargo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Cargo cargo)
	{
		startPage();
        List<Cargo> list = cargoService.selectCargoList(cargo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出货物列表
	 */
	@RequiresPermissions("cargo:cargo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Cargo cargo)
    {
    	List<Cargo> list = cargoService.selectCargoList(cargo);
        ExcelUtil<Cargo> util = new ExcelUtil<Cargo>(Cargo.class);
        return util.exportExcel(list, "cargo");
    }
	
	/**
	 * 新增货物
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存货物
	 */
	@RequiresPermissions("cargo:cargo:add")
	@Log(title = "货物", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Cargo cargo)
	{		
		return toAjax(cargoService.insertCargo(cargo));
	}

	/**
	 * 修改货物
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Cargo cargo = cargoService.selectCargoById(id);
		mmap.put("cargo", cargo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存货物
	 */
	@RequiresPermissions("cargo:cargo:edit")
	@Log(title = "货物", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Cargo cargo)
	{		
		return toAjax(cargoService.updateCargo(cargo));
	}
	
	/**
	 * 删除货物
	 */
	@RequiresPermissions("cargo:cargo:remove")
	@Log(title = "货物", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(cargoService.deleteCargoByIds(ids));
	}
	
}
