package com.gt.inside.core.service.devproject.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.core.bean.devproject.DevProjectVO;
import com.gt.inside.core.bean.devproject.req.DevProjectAddReq;
import com.gt.inside.core.bean.devproject.req.DevProjectListReq;
import com.gt.inside.core.bean.devproject.req.DevProjectModifyReq;
import com.gt.inside.core.bean.devproject.res.DevProjectListRes;
import com.gt.inside.core.dao.devproject.DevProjectDAO;
import com.gt.inside.core.entity.devproject.DevProject;
import com.gt.inside.core.exception.devproject.DevProjectException;
import com.gt.inside.core.service.devproject.DevProjectService;
import com.gt.inside.core.util.DateTimeKit;
import com.gt.inside.core.util.ObjectUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 研发项目表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-10
 */
@Service
public class DevProjectServiceImpl extends ServiceImpl<DevProjectDAO, DevProject> implements DevProjectService {

    @Override
    public List<DevProjectVO> listRunProject() throws Exception {
        List<DevProjectVO> devProjectVOList = new ArrayList<>();
        EntityWrapper<DevProject> entityWrapper = new EntityWrapper<>();
        // 查询所有进行中的项目
        entityWrapper.eq("project_status", 0);
        entityWrapper.orderBy("project_time");
        List<DevProject> devProjectList = selectList(entityWrapper);
        List<DevProject> updateList = new ArrayList<>();
        for (DevProject devProject : devProjectList){
            DevProjectVO devProjectVO = new DevProjectVO();
            devProjectVO.setProjectName(devProject.getProjectName());
            int dayNum = DateTimeKit.daysBetween(new Date(), devProject.getProjectTime());
            String endDayNum = String.valueOf(dayNum);
            devProjectVO.setEndDayNum(endDayNum);
            // 已经结束的项目，不返回前台
            if (dayNum < 0){
                devProject.setProjectStatus(1);
                updateList.add(devProject);
                continue;
            }
            devProjectVOList.add(devProjectVO);
        }
        // 将已经结束的项目标志为已结束
        if (updateList.size() > 0){
            updateBatchById(updateList);
        }
        return devProjectVOList;
    }

    /**
     * 分页获取开发项目
     *
     * @param devProjectListReq
     * @return
     * @exception DevProjectException
     */
    @Override
    public ResponseDTO<List<DevProjectListRes>> listDevProjectByPage(DevProjectListReq devProjectListReq) throws DevProjectException {
        Page<DevProject> page = new Page<>(devProjectListReq.getCurrent(), devProjectListReq.getSize());
        EntityWrapper<DevProject> entityWrapper = new EntityWrapper<>();
        if (ObjectUtil.isNotEmpty(devProjectListReq) && ObjectUtil.isNotEmpty(devProjectListReq.getProjectStatus())){
            entityWrapper.eq("project_status", devProjectListReq.getProjectStatus());
        }
        List<DevProject> devProjectList = selectPage(page, entityWrapper).getRecords();
        List<DevProjectListRes> devProjectListResList = new ArrayList<>();
        for (DevProject devProject : devProjectList){
            DevProjectListRes devProjectListRes = new DevProjectListRes();
            devProjectListRes.setId(devProject.getId());
            devProjectListRes.setProjectName(devProject.getProjectName());
            devProjectListRes.setProjectTime(devProject.getProjectTime());
            devProjectListRes.setProjectStatus(devProject.getProjectStatus());
            devProjectListResList.add(devProjectListRes);
        }
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取开发项目成功", devProjectListResList, pageDTO);
    }

    /**
     * 新增开发项目
     *
     * @param devProjectAddReq
     * @exception DevProjectException
     */
    @Override
    public void addDevProject(DevProjectAddReq devProjectAddReq) throws DevProjectException {
        DevProject devProject = new DevProject();
        devProject.setProjectName(devProjectAddReq.getProjectName());
        devProject.setProjectTime(devProjectAddReq.getProjectTime());
        insert(devProject);
    }

    /**
     * 编辑开发项目
     *
     * @param devProjectModifyReq
     */
    @Override
    public void modifyDevProject(DevProjectModifyReq devProjectModifyReq) {
        DevProject devProject = selectById(devProjectModifyReq.getId());
        if (ObjectUtil.isEmpty(devProject)){
            throw new DevProjectException(ResponseEnums.MODIFYNULL);
        }
        devProject.setProjectName(devProjectModifyReq.getProjectName());
        devProject.setProjectTime(devProjectModifyReq.getProjectTime());
        updateById(devProject);
    }
}
