package com.express.project.express.station.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.project.express.station.mapper.StationMapper;
import com.express.project.express.station.domain.Station;
import com.express.project.express.station.service.IStationService;
import com.express.common.utils.text.Convert;

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

	/**
     * 查询车站信息
     * 
     * @param id 车站ID
     * @return 车站信息
     */
    @Override
	public Station selectStationById(Integer id)
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
	public List<Station> selectStationList(Station station)
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
	public int insertStation(Station station)
	{
	    return stationMapper.insertStation(station);
	}
	
	/**
     * 修改车站
     * 
     * @param station 车站信息
     * @return 结果
     */
	@Override
	public int updateStation(Station station)
	{
	    return stationMapper.updateStation(station);
	}

	/**
     * 删除车站对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteStationByIds(String ids)
	{
		return stationMapper.deleteStationByIds(Convert.toStrArray(ids));
	}
	
}
