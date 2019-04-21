package com.express.project.express.complaint.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.complaint.mapper.ComplaintMapper;
import com.express.project.express.complaint.domain.Complaint;
import com.express.project.express.complaint.service.IComplaintService;
import com.express.common.utils.text.Convert;

/**
 * 投诉建议 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Service
public class ComplaintServiceImpl implements IComplaintService 
{
	@Autowired
	private ComplaintMapper complaintMapper;

	/**
     * 查询投诉建议信息
     * 
     * @param id 投诉建议ID
     * @return 投诉建议信息
     */
    @Override
	public Complaint selectComplaintById(Integer id)
	{
	    return complaintMapper.selectComplaintById(id);
	}
	
	/**
     * 查询投诉建议列表
     * 
     * @param complaint 投诉建议信息
     * @return 投诉建议集合
     */
	@Override
	public List<Complaint> selectComplaintList(Complaint complaint)
	{
	    return complaintMapper.selectComplaintList(complaint);
	}
	
    /**
     * 新增投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	@Override
	public int insertComplaint(Complaint complaint)
	{
	    return complaintMapper.insertComplaint(complaint);
	}
	
	/**
     * 修改投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	@Override
	public int updateComplaint(Complaint complaint)
	{
	    return complaintMapper.updateComplaint(complaint);
	}

	/**
     * 删除投诉建议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteComplaintByIds(String ids)
	{
		return complaintMapper.deleteComplaintByIds(Convert.toStrArray(ids));
	}
	
}
