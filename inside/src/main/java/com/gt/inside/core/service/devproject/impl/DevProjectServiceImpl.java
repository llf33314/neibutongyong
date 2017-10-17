package com.gt.inside.core.service.devproject.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.core.bean.devproject.DevProjectVO;
import com.gt.inside.core.dao.devproject.DevProjectDAO;
import com.gt.inside.core.entity.devproject.DevProject;
import com.gt.inside.core.service.devproject.DevProjectService;
import com.gt.inside.core.util.DateTimeKit;
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
}
