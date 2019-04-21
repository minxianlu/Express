package com.express.project.express.attachment.service;

import com.express.project.express.attachment.domain.Attachment;
import java.util.List;

/**
 * 附件 服务层
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
public interface IAttachmentService 
{
	/**
     * 查询附件信息
     * 
     * @param id 附件ID
     * @return 附件信息
     */
	 Attachment selectAttachmentById(Integer id);
	
	/**
     * 查询附件列表
     * 
     * @param attachment 附件信息
     * @return 附件集合
     */
	 List<Attachment> selectAttachmentList(Attachment attachment);
	
	/**
     * 新增附件
     * 
     * @param attachment 附件信息
     * @return 结果
     */
	 int insertAttachment(Attachment attachment);
	
	/**
     * 修改附件
     * 
     * @param attachment 附件信息
     * @return 结果
     */
	 int updateAttachment(Attachment attachment);
		
	/**
     * 删除附件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	 int deleteAttachmentByIds(String ids);
	
}
