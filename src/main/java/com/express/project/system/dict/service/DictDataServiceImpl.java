package com.express.project.system.dict.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.express.common.utils.StringUtils;
import com.express.common.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.express.common.utils.security.ShiroUtils;
import com.express.common.utils.text.Convert;
import com.express.project.system.dict.domain.DictData;
import com.express.project.system.dict.mapper.DictDataMapper;

/**
 * 字典 业务层处理
 *
 * @author chenyb
 */
@Service
public class DictDataServiceImpl implements IDictDataService {
    @Autowired
    private DictDataMapper dictDataMapper;

    /**
     * 根据条件分页查询字典数据
     *
     * @param dictData 字典数据信息
     * @return 字典数据集合信息
     */
    @Override
    public List<DictData> selectDictDataList(DictData dictData) {
        return dictDataMapper.selectDictDataList(dictData);
    }

    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<DictData> selectDictDataByType(String dictType) {
        return dictDataMapper.selectDictDataByType(dictType);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType  字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue) {
        return dictDataMapper.selectDictLabel(dictType, dictValue);
    }

    /**
     * 根据字典数据ID查询信息
     *
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    @Override
    public DictData selectDictDataById(Long dictCode) {
        return dictDataMapper.selectDictDataById(dictCode);
    }

    /**
     * 通过字典ID删除字典数据信息
     *
     * @param dictCode 字典数据ID
     * @return 结果
     */
    @Override
    public int deleteDictDataById(Long dictCode) {
        return dictDataMapper.deleteDictDataById(dictCode);
    }

    /**
     * 批量删除字典数据
     *
     * @param ids 需要删除的数据
     * @return 结果
     */
    @Override
    public int deleteDictDataByIds(String ids) {
        return dictDataMapper.deleteDictDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 新增保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int insertDictData(DictData dictData) {
        dictData.setCreateBy(ShiroUtils.getLoginName());
        return dictDataMapper.insertDictData(dictData);
    }

    /**
     * 修改保存字典数据信息
     *
     * @param dictData 字典数据信息
     * @return 结果
     */
    @Override
    public int updateDictData(DictData dictData) {
        dictData.setUpdateBy(ShiroUtils.getLoginName());
        return dictDataMapper.updateDictData(dictData);
    }


    @Override
    public List<DictData> selectDictDataByDictTypeList(List<String> dictTypeList) {
        if (BeanUtils.isEmpty(dictTypeList) || dictTypeList.size() == 0) {
            return new ArrayList<DictData>();
        }
        return dictDataMapper.selectDictDataByDictTypeList(dictTypeList);
    }

    @Override
    public Map<String, DictData> getDicDataMapByDictType(String dictType) throws Exception {
        Map<String, DictData> dictDataMap = new HashMap<>(16);
        if (StringUtils.isEmpty(dictType)) {
            return dictDataMap;
        }
        List<DictData> dictDataList = dictDataMapper.selectDictDataByType(dictType);
        for (DictData dict : dictDataList) {
            dictDataMap.put(dict.getDictType() + dict.getDictValue(), dict);
        }
        return dictDataMap;
    }

    @Override
    public Map<String, DictData> getDicDataMapByDictType(List<String> dictTypeList) throws Exception {
        Map<String, DictData> dictDataMap = new HashMap<>(16);
        if (BeanUtils.isEmpty(dictTypeList)) {
            return dictDataMap;
        }
        List<DictData> dictDataList = dictDataMapper.selectDictDataByDictTypeList(dictTypeList);
        for (DictData dict : dictDataList) {
            dictDataMap.put(dict.getDictType() + dict.getDictValue(), dict);
        }
        return dictDataMap;
    }
}
