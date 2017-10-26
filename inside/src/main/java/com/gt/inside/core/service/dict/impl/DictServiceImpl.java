package com.gt.inside.core.service.dict.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.dict.req.*;
import com.gt.inside.core.dao.dict.DictDAO;
import com.gt.inside.core.entity.dict.Dict;
import com.gt.inside.core.entity.dict.DictInfo;
import com.gt.inside.core.exception.dict.DictException;
import com.gt.inside.core.service.dict.DictInfoService;
import com.gt.inside.core.service.dict.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 字典主表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-25
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictDAO, Dict> implements DictService {

    @Autowired
    DictInfoService dictInfoService;

    /**
     * 分页获取字典列表
     *
     * @param dictListReq
     * @return
     */
    @Override
    public ResponseDTO<List<Dict>> listDictByPage(DictListReq dictListReq) {
        Page<Dict> page = new Page<>(dictListReq.getCurrent(), dictListReq.getSize());
        EntityWrapper<Dict> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.orderBy("dict_code");
        if (CommonUtil.isNotEmpty(dictListReq.getDictSearch())){
            entityWrapper.like("dict_name", dictListReq.getDictSearch()).or().like("dict_code", dictListReq.getDictSearch());
        }
        List<Dict> dictList = selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取字典列表成功", dictList, pageDTO);
    }

    /**
     * 新增字典
     *
     * @param dictAddReq
     */
    @Override
    public void addDict(DictAddReq dictAddReq) throws DictException {
        EntityWrapper<Dict> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("dict_code", dictAddReq.getDictCode());
        Dict dictSelect = selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(dictSelect)){
            throw new DictException(ResponseEnums.DICT_CODE_HAS);
        }
        Dict dict = new Dict();
        dict.setCreateTime(new Date());
        dict.setDeleteFlag(0);
        dict.setDictCode(dictAddReq.getDictCode());
        dict.setDictName(dictAddReq.getDictName());
        dict.setDictRemark(dictAddReq.getDictRemark());
        insertAllColumn(dict);
    }

    /**
     * 修改字典
     *
     * @param dictModifyReq
     */
    @Override
    public void modifyDict(DictModifyReq dictModifyReq) throws DictException {
        EntityWrapper<Dict> entityWrapperCheck = new EntityWrapper<>();
        entityWrapperCheck.eq("delete_flag", 0);
        entityWrapperCheck.eq("dict_code", dictModifyReq.getDictCode());
        Dict dictSelect = selectOne(entityWrapperCheck);
        if (CommonUtil.isNotEmpty(dictSelect) && !dictSelect.getId().equals(dictModifyReq.getId())){
            throw new DictException(ResponseEnums.DICT_CODE_HAS);
        }
        EntityWrapper<Dict> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", dictModifyReq.getId());
        Dict dict = selectOne(entityWrapper);
        if (CommonUtil.isEmpty(dict)){
            throw new DictException(ResponseEnums.MODIFY_NULL);
        }
        dict.setDictName(dictModifyReq.getDictName());
        dict.setDictCode(dictModifyReq.getDictCode());
        dict.setDictRemark(dictModifyReq.getDictRemark());
        updateAllColumnById(dict);
    }

    /**
     * 根据字典ID获取字典详情
     *
     * @param dictInfoListReq
     * @return
     */
    @Override
    public ResponseDTO<List<DictInfo>> listDictInfoByPage(DictInfoListReq dictInfoListReq) {
        Page<DictInfo> page = new Page<>(dictInfoListReq.getCurrent(), dictInfoListReq.getSize());
        EntityWrapper<DictInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("dict_id", dictInfoListReq.getDictId());
        entityWrapper.orderBy("info_code");
        if (CommonUtil.isNotEmpty(dictInfoListReq.getDictSearch())){
            entityWrapper.like("info_code", dictInfoListReq.getDictSearch()).or().like("info_content", dictInfoListReq.getDictSearch());
        }
        List<DictInfo> dictInfoList = dictInfoService.selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取字典详情成功", dictInfoList, pageDTO);
    }

    /**
     * 新增字典详情
     *
     * @param dictInfoAddReq
     */
    @Override
    public void addDictInfo(DictInfoAddReq dictInfoAddReq) {
        EntityWrapper<DictInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("dict_id", dictInfoAddReq.getDictId());
        entityWrapper.eq("info_code", dictInfoAddReq.getInfoCode());
        DictInfo dictInfoSelect = dictInfoService.selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(dictInfoSelect)){
            throw new DictException(ResponseEnums.DICT_CODE_HAS);
        }
        DictInfo dictInfo = new DictInfo();
        dictInfo.setDictId(dictInfoAddReq.getDictId());
        dictInfo.setCreateTime(new Date());
        dictInfo.setDeleteFlag(0);
        dictInfo.setInfoCode(dictInfoAddReq.getInfoCode());
        dictInfo.setInfoContent(dictInfoAddReq.getInfoContent());
        dictInfo.setInfoRemark(dictInfoAddReq.getInfoRemark());
        dictInfoService.insertAllColumn(dictInfo);
    }

    /**
     * 修改字典详情
     *
     * @param dictInfoModifyReq
     */
    @Override
    public void modifyDictInfo(DictInfoModifyReq dictInfoModifyReq) {
        EntityWrapper<DictInfo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", dictInfoModifyReq.getId());
        DictInfo dictInfo = dictInfoService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(dictInfo)){
            throw new DictException(ResponseEnums.MODIFY_NULL);
        }
        EntityWrapper<DictInfo> entityWrapperCheck = new EntityWrapper<>();
        entityWrapperCheck.eq("delete_flag", 0);
        entityWrapperCheck.eq("info_code", dictInfoModifyReq.getInfoCode());
        entityWrapperCheck.eq("dict_id",dictInfo.getDictId());
        DictInfo dictInfoSelect = dictInfoService.selectOne(entityWrapperCheck);
        if (CommonUtil.isNotEmpty(dictInfoSelect) && !dictInfoSelect.getId().equals(dictInfoModifyReq.getId())){
            throw new DictException(ResponseEnums.DICT_CODE_HAS);
        }
        dictInfo.setInfoContent(dictInfoModifyReq.getInfoContent());
        dictInfo.setInfoCode(dictInfoModifyReq.getInfoCode());
        dictInfo.setInfoRemark(dictInfoModifyReq.getInfoRemark());
        dictInfoService.updateAllColumnById(dictInfo);
    }

    /**
     * 删除字典
     *
     * @param dictDelReq
     */
    @Override
    public void delDict(DictDelReq dictDelReq) {
        DictInfo dictInfo = new DictInfo();
        dictInfo.setDeleteFlag(1);
        EntityWrapper<DictInfo> entityWrapperInfo = new EntityWrapper<>();
        entityWrapperInfo.eq("dict_id", dictDelReq.getId());
        entityWrapperInfo.eq("delete_flag", 0);
        dictInfoService.update(dictInfo, entityWrapperInfo);
        dictInfoService.delete(entityWrapperInfo);
        Dict dict = new Dict();
        dict.setDeleteFlag(1);
        dict.setId(dictDelReq.getId());
        updateById(dict);
        deleteById(dictDelReq.getId());
    }

    /**
     * 删除字典详情
     *
     * @param dictInfoDelReq
     */
    @Override
    public void delDictInfo(DictInfoDelReq dictInfoDelReq) {
        DictInfo dictInfo = new DictInfo();
        dictInfo.setDeleteFlag(1);
        dictInfo.setId(dictInfoDelReq.getId());
        dictInfoService.updateById(dictInfo);
        dictInfoService.deleteById(dictInfoDelReq.getId());
    }
}
