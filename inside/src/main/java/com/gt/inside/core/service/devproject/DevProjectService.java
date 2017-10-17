package com.gt.inside.core.service.devproject;

import com.gt.inside.core.bean.devproject.DevProjectVO;
import com.gt.inside.core.entity.devproject.DevProject;
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
