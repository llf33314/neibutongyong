package com.gt.inside.core.service.dict.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.entity.dict.Dict;
import com.gt.inside.core.entity.dict.DictInfo;
import com.gt.inside.core.exception.dict.DictException;
import com.gt.inside.core.service.dict.DictApiService;
import com.gt.inside.core.service.dict.DictInfoService;
import com.gt.inside.core.service.dict.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by psr on 2017/10/26 0026.
 */
@Service
public class DictApiServiceImpl implements DictApiService{

    @Autowired
    DictService dictService;

    @Autowired
    DictInfoService dictInfoService;

    /**
     * 根据字典code，查询字典详情信息
     *
     * @return
     */
    @Override
    public List<DictInfo> getDictInfoByDictCode(Integer dictCode) {
        EntityWrapper<Dict> entityWrapperDict = new EntityWrapper<>();
        entityWrapperDict.eq("dict_code", dictCode);
        entityWrapperDict.eq("delete_flag", 0);
        Dict dict = dictService.selectOne(entityWrapperDict);
        if (CommonUtil.isEmpty(dict)){
            throw new DictException(ResponseEnums.DICT_NULL);
        }
        EntityWrapper<DictInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("dict_id", dict.getId());
        entityWrapper.eq("delete_flag", 0);
        List<DictInfo> dictInfoList = dictInfoService.selectList(entityWrapper);
        return dictInfoList;
    }
}
