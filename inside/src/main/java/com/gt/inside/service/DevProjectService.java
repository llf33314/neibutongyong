package com.gt.inside.service;

import com.gt.inside.bean.DevProjectVO;
import com.gt.inside.entity.DevProject;
import com.baomidou.mybatisplus.service.IService;

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

    List<DevProjectVO> listRunProject() throws Exception;
}
