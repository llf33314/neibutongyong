package com.gt.inside.core.service.dict.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.dict.req.DictListReq;
import com.gt.inside.core.dao.dict.DictDAO;
import com.gt.inside.core.entity.dict.Dict;
import com.gt.inside.core.service.dict.DictService;
import org.springframework.stereotype.Service;

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
        if (CommonUtil.isNotEmpty(dictListReq.getDictSearch())){
            entityWrapper.like("dict_name", dictListReq.getDictSearch()).or().like("dict_code", dictListReq.getDictSearch());
        }
        List<Dict> dictList = selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取开发项目成功", dictList, pageDTO);
    }
}
