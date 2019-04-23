package com.express.project.express.station.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.express.common.utils.StringUtils;
import com.express.common.utils.security.ShiroUtils;
import com.express.project.express.freightRate.domain.FreightRate;
import com.express.project.express.freightRate.service.IFreightRateService;
import org.apache.velocity.runtime.directive.Foreach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.station.mapper.StationMapper;
import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import com.express.common.utils.text.Convert;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 车站 服务层实现
 * 
 * @author Chenyb
 * @date 2019-04-20
 */
@Service
public class StationServiceImpl implements IStationService 
{
	@Autowired
	private StationMapper stationMapper;

	@Autowired
	private IFreightRateService freightRateService;

	/**
     * 查询车站信息
     * 
     * @param id 车站ID
     * @return 车站信息
     */
    @Override
	public Station selectStationById(Integer id)throws Exception
	{
		return stationMapper.selectStationById(id);
	}
	
	/**
     * 查询车站列表
     * 
     * @param station 车站信息
     * @return 车站集合
     */
	@Override
	public List<Station> selectStationList(Station station)throws Exception
	{
		return stationMapper.selectStationList(station);
	}
	
    /**
     * 新增车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void insertStation(Station station)throws Exception
	{

		if (StringUtils.isNotEmpty(station.getStationName())) {
			List<Station> list=stationMapper.selectStationList(station);
			if(list.size()>0){
				throw new Exception("站台名称已存在");
			}
		}
		station.setCreateBy(ShiroUtils.getUserName());
		station.setCreateTime(new Date());
		stationMapper.insertStation(station);
	}
	
	/**
     * 修改车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateStation(Station station)throws Exception
	{
		station.setUpdateBy(ShiroUtils.getUserName());
		station.setUpdateTime(new Date());
		stationMapper.updateStation(station);
	}

	/**
     * 删除车站对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteStationByIds(String ids)throws Exception
	{
		freightRateService.deleteFreightRateByIds(ids);
		stationMapper.deleteStationByIds(Convert.toStrArray(ids));
	}


	@Override
	public List<Station> selectStationByIds(String[] ids) throws Exception {
		return stationMapper.selectStationByIds(ids);
	}

	@Override
	public List<Station> selectStationNotInIds(List<Integer> list) throws Exception {
		return stationMapper.selectStationNotInIds(list);
	}
}
