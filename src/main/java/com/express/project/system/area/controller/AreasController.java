package com.express.project.system.area.controller;

import java.util.List;

import com.express.common.utils.poi.ExcelUtil;
import com.express.project.system.area.domain.Areas;
import com.express.project.system.area.service.IAreasService;
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

/**
 * 区县 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/area/areas")
public class AreasController extends BaseController
{
    private String prefix = "area/areas";
	
	@Autowired
	private IAreasService areasService;
	
	@RequiresPermissions("area:areas:view")
	@GetMapping()
	public String areas()
	{
	    return prefix + "/areas";
	}
	
	/**
	 * 查询区县列表
	 */
	@RequiresPermissions("area:areas:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Areas areas)
	{
		startPage();
        List<Areas> list = areasService.selectAreasList(areas);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出区县列表
	 */
	@RequiresPermissions("area:areas:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Areas areas)
    {
    	List<Areas> list = areasService.selectAreasList(areas);
        ExcelUtil<Areas> util = new ExcelUtil<Areas>(Areas.class);
        return util.exportExcel(list, "areas");
    }
	
	/**
	 * 新增区县
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存区县
	 */
	@RequiresPermissions("area:areas:add")
	@Log(title = "区县", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Areas areas)
	{		
		return toAjax(areasService.insertAreas(areas));
	}

	/**
	 * 修改区县
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Areas areas = areasService.selectAreasById(id);
		mmap.put("areas", areas);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存区县
	 */
	@RequiresPermissions("area:areas:edit")
	@Log(title = "区县", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Areas areas)
	{		
		return toAjax(areasService.updateAreas(areas));
	}
	
	/**
	 * 删除区县
	 */
	@RequiresPermissions("area:areas:remove")
	@Log(title = "区县", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(areasService.deleteAreasByIds(ids));
	}
	
}
