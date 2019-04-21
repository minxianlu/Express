package com.express.project.express.attachment.mapper;

import com.express.project.express.attachment.domain.Attachment;
import java.util.List;	

/**
 * 附件 数据层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface AttachmentMapper 
{
	/**
     * 查询附件信息
     * 
     * @param id 附件ID
     * @return 附件信息
     */
	public Attachment selectAttachmentById(Integer id);
	
	/**
     * 查询附件列表
     * 
     * @param attachment 附件信息
     * @return 附件集合
     */
	public List<Attachment> selectAttachmentList(Attachment attachment);
	
	/**
     * 新增附件
     * 
     * @param attachment 附件信息
     * @return 结果
     */
	public int insertAttachment(Attachment attachment);
	
	/**
     * 修改附件
     * 
     * @param attachment 附件信息
     * @return 结果
     */
	public int updateAttachment(Attachment attachment);
	
	/**
     * 删除附件
     * 
     * @param id 附件ID
     * @return 结果
     */
	public int deleteAttachmentById(Integer id);
	
	/**
     * 批量删除附件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteAttachmentByIds(String[] ids);
	
}