package com.express.project.express.complaint.service;

import java.util.Date;
import java.util.List;

import com.express.common.utils.bean.BeanUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.common.ExpressConstant;
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
		List<Complaint> list=complaintMapper.selectComplaintList(complaint);
		for (Complaint complaint1 : list) {
			if(complaint1.getStatus()!=null){
				complaint1.setStatusStr(getComplaintStatus(complaint1.getStatus()));
			}
		}
	    return list;
	}
	
    /**
     * 新增投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	@Override
	public void insertComplaint(Complaint complaint)
	{
		complaint.setCreateBy(ShiroUtils.getLoginName());
		complaint.setCreateTime(new Date());
		complaint.setStatus(Integer.parseInt(ExpressConstant.COMPLAINT_STATUS_NOT));
		complaintMapper.insertComplaint(complaint);
	}
	
	/**
     * 修改投诉建议
     * 
     * @param complaint 投诉建议信息
     * @return 结果
     */
	@Override
	public void updateComplaint(Complaint complaint)
	{
		complaintMapper.updateComplaint(complaint);
	}

	/**
     * 删除投诉建议对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public void deleteComplaintByIds(String ids)throws Exception
	{
		Complaint complaint=new Complaint();
		complaint.setStatus(Integer.parseInt(ExpressConstant.COMPLAINT_STATUS_DEL));
		String[] s=Convert.toStrArray(ids);
		complaint.setId(Integer.parseInt(s[0]));
		complaintMapper.updateComplaint(complaint);
	}

	public String getComplaintStatus(Integer s){
		String status=s+"";
		String result="";
		switch (status){
			case ExpressConstant.COMPLAINT_STATUS_NOT:result="未处理";break;
			case ExpressConstant.COMPLAINT_STATUS_YEAR:result="已处理";break;
			case ExpressConstant.COMPLAINT_STATUS_DEL:result="已撤销";break;
			default:result=status;break;
		}
		return result;


	}
	
}
