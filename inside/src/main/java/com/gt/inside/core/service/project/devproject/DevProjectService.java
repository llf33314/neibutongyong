package com.gt.inside.core.service.project.devproject;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.project.devproject.DevProjectVO;
import com.gt.inside.core.bean.project.devproject.req.DevProjectAddReq;
import com.gt.inside.core.bean.project.devproject.req.DevProjectListReq;
import com.gt.inside.core.bean.project.devproject.req.DevProjectModifyReq;
import com.gt.inside.core.bean.project.devproject.res.DevProjectListRes;
import com.gt.inside.core.entity.project.devproject.DevProject;
import com.gt.inside.core.exception.project.devproject.DevProjectException;

import java.util.List;

/**
 * <p>
 * 研发项目表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-10
 */
public interface DevProjectService extends IService<DevProject> {

    /**
     * 获取进行中的开发项目
     * @return
     * @throws Exception
     */
    List<DevProjectVO> listRunProject() throws Exception;

    /**
     * 分页获取开发项目
     * @param devProjectListReq
     * @return
     * @throws DevProjectException
     */
    ResponseDTO<List<DevProjectListRes>> listDevProjectByPage(DevProjectListReq devProjectListReq) throws DevProjectException;

    /**
     * 新增开发项目
     * @param devProjectAddReq
     * @throws DevProjectException
     */
    void addDevProject(DevProjectAddReq devProjectAddReq) throws DevProjectException;

    /**
     * 编辑开发项目
     * @param devProjectModifyReq
     */
    void modifyDevProject(DevProjectModifyReq devProjectModifyReq);
}
