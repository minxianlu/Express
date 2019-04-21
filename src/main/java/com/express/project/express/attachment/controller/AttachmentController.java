package com.express.project.express.attachment.controller;

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
import com.express.project.express.attachment.domain.Attachment;
import com.express.project.express.attachment.service.IAttachmentService;
import com.express.framework.web.controller.BaseController;
import com.express.framework.web.page.TableDataInfo;
import com.express.framework.web.domain.AjaxResult;
import com.express.common.utils.poi.ExcelUtil;

/**
 * 附件 信息操作处理
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/express/attachment")
public class AttachmentController extends BaseController
{
    private String prefix = "express/attachment";
	
	@Autowired
	private IAttachmentService attachmentService;
	
	@RequiresPermissions("express:attachment:view")
	@GetMapping()
	public String attachment()
	{
	    return prefix + "/attachment";
	}
	
	/**
	 * 查询附件列表
	 */
	@RequiresPermissions("express:attachment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Attachment attachment)
	{
		startPage();
        List<Attachment> list = attachmentService.selectAttachmentList(attachment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出附件列表
	 */
	@RequiresPermissions("express:attachment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Attachment attachment)
    {
    	List<Attachment> list = attachmentService.selectAttachmentList(attachment);
        ExcelUtil<Attachment> util = new ExcelUtil<Attachment>(Attachment.class);
        return util.exportExcel(list, "attachment");
    }
	
	/**
	 * 新增附件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存附件
	 */
	@RequiresPermissions("express:attachment:add")
	@Log(title = "附件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Attachment attachment)
	{		
		return toAjax(attachmentService.insertAttachment(attachment));
	}

	/**
	 * 修改附件
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, ModelMap mmap)
	{
		Attachment attachment = attachmentService.selectAttachmentById(id);
		mmap.put("attachment", attachment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存附件
	 */
	@RequiresPermissions("express:attachment:edit")
	@Log(title = "附件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Attachment attachment)
	{		
		return toAjax(attachmentService.updateAttachment(attachment));
	}
	
	/**
	 * 删除附件
	 */
	@RequiresPermissions("express:attachment:remove")
	@Log(title = "附件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(attachmentService.deleteAttachmentByIds(ids));
	}
	
}
