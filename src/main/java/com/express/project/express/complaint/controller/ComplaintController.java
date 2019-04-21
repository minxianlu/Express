package com.express.project.express.complaint.controller;

import java.util.List;
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
import com.express.project.express.complaint.domain.Complaint;
import com.express.project.express.complaint.service.IComplaintService;
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.page.TableDataInfo;
import com.express.framework.web.domain.AjaxResult;
import com.express.common.utils.poi.ExcelUtil;

/**
 * 投诉建议 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/express/complaint")
public class ComplaintController extends BaseController
{
    private String prefix = "express/complaint";
	
	@Autowired
	private IComplaintService complaintService;
	
	@RequiresPermissions("express:complaint:view")
	@GetMapping()
	public String complaint()
	{
	    return prefix + "/complaint";
	}
	
	/**
	 * 查询投诉建议列表
	 */
	@RequiresPermissions("express:complaint:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Complaint complaint)
	{
		startPage();
        List<Complaint> list = complaintService.selectComplaintList(complaint);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出投诉建议列表
	 */
	@RequiresPermissions("express:complaint:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Complaint complaint)
    {
    	List<Complaint> list = complaintService.selectComplaintList(complaint);
        ExcelUtil<Complaint> util = new ExcelUtil<Complaint>(Complaint.class);
        return util.exportExcel(list, "complaint");
    }
	
	/**
	 * 新增投诉建议
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存投诉建议
	 */
	@RequiresPermissions("express:complaint:add")
	@Log(title = "投诉建议", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Complaint complaint)
	{		
		return toAjax(complaintService.insertComplaint(complaint));
	}

	/**
	 * 修改投诉建议
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Complaint complaint = complaintService.selectComplaintById(id);
		mmap.put("complaint", complaint);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存投诉建议
	 */
	@RequiresPermissions("express:complaint:edit")
	@Log(title = "投诉建议", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Complaint complaint)
	{		
		return toAjax(complaintService.updateComplaint(complaint));
	}
	
	/**
	 * 删除投诉建议
	 */
	@RequiresPermissions("express:complaint:remove")
	@Log(title = "投诉建议", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(complaintService.deleteComplaintByIds(ids));
	}
	
}
