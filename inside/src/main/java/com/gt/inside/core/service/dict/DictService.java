package com.gt.inside.core.service.dict;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.dict.req.DictListReq;
import com.gt.inside.core.entity.dict.Dict;

import java.util.List;

/**
 * <p>
 * 字典主表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-25
 */
public interface DictService extends IService<Dict> {

    /**
     * 分页获取字典列表
     * @param dictListReq
     * @return
     */
    ResponseDTO<List<Dict>> listDictByPage(DictListReq dictListReq);
}
