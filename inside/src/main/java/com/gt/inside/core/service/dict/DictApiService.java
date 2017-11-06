package com.gt.inside.core.service.dict;

import com.gt.inside.core.entity.dict.DictInfo;

import java.util.List;
import java.util.Map;

/**
 * 字典api服务
 * @author psr
 * Created by psr on 2017/10/26 0026.
 */
public interface DictApiService {

    /**
     * 根据字典code，查询字典详情信息
     * @return list
     */
    List<DictInfo> listDictInfoByDictCode(Integer dictCode);

    /**
     * 根据字典code，查询字典详情信息
     * @return map
     */
    Map<Integer, String> getDictInfoByDictCode(Integer dictCode);

}
