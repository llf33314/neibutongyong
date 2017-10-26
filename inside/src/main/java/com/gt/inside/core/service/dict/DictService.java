package com.gt.inside.core.service.dict;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.dict.req.*;
import com.gt.inside.core.entity.dict.Dict;
import com.gt.inside.core.entity.dict.DictInfo;
import com.gt.inside.core.exception.dict.DictException;

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

    /**
     * 新增字典
     * @param dictAddReq
     */
    void addDict(DictAddReq dictAddReq) throws DictException;

    /**
     * 修改字典
     * @param dictModifyReq
     */
    void modifyDict(DictModifyReq dictModifyReq) throws DictException;

    /**
     * 根据字典ID获取字典详情
     * @param dictInfoListReq
     * @return
     */
    ResponseDTO<List<DictInfo>> listDictInfoByPage(DictInfoListReq dictInfoListReq);

    /**
     * 新增字典详情
     * @param dictInfoAddReq
     */
    void addDictInfo(DictInfoAddReq dictInfoAddReq);

    /**
     * 修改字典详情
     * @param dictInfoModifyReq
     */
    void modifyDictInfo(DictInfoModifyReq dictInfoModifyReq);

    /**
     * 删除字典
     * @param dictDelReq
     */
    void delDict(DictDelReq dictDelReq);

    /**
     * 删除字典详情
     * @param dictInfoDelReq
     */
    void delDictInfo(DictInfoDelReq dictInfoDelReq);
}
