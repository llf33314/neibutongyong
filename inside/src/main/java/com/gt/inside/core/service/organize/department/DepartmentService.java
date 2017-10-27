package com.gt.inside.core.service.organize.department;

import com.baomidou.mybatisplus.service.IService;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.core.bean.organize.department.req.DepartmentAddReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentDelReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentListReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentModifyReq;
import com.gt.inside.core.entity.organize.department.Department;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-26
 */
public interface DepartmentService extends IService<Department> {
    /**
     * 分页获取部门
     * @param departmentListReq
     * @return
     */
    ResponseDTO<List<Department>> listDepartmentByPage(DepartmentListReq departmentListReq);

    /**
     * 新增部门
     * @param departmentAddReq
     */
    void addDepartment(DepartmentAddReq departmentAddReq);

    /**
     * 修改部门
     * @param departmentModifyReq
     */
    void modifyDepartment(DepartmentModifyReq departmentModifyReq);

    /**
     * 删除部门
     * @param departmentDelReq
     */
    void delDepartment(DepartmentDelReq departmentDelReq);

    /**
     * 获取所有部门
     * @return
     */
    List<Department> listAllDepartment();
}
