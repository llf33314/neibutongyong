package com.gt.inside.core.service.organize.department.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.inside.api.dto.PageDTO;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.core.bean.organize.department.req.DepartmentAddReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentDelReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentListReq;
import com.gt.inside.core.bean.organize.department.req.DepartmentModifyReq;
import com.gt.inside.core.dao.organize.department.DepartmentDAO;
import com.gt.inside.core.entity.organize.department.Department;
import com.gt.inside.core.exception.dict.DictException;
import com.gt.inside.core.exception.organize.department.DepartmentException;
import com.gt.inside.core.service.organize.department.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-26
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDAO, Department> implements DepartmentService {

    /**
     * 分页获取部门
     *
     * @param departmentListReq
     * @return
     */
    @Override
    public ResponseDTO<List<Department>> listDepartmentByPage(DepartmentListReq departmentListReq) {
        Page<Department> page = new Page<>(departmentListReq.getCurrent(), departmentListReq.getSize());
        EntityWrapper<Department> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        if (CommonUtil.isNotEmpty(departmentListReq.getDepartmentSearch())){
            entityWrapper.like("dep_name", departmentListReq.getDepartmentSearch());
        }
        List<Department> departmentList = selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取部门成功", departmentList, pageDTO);
    }

    /**
     * 新增部门
     *
     * @param departmentAddReq
     */
    @Override
    public void addDepartment(DepartmentAddReq departmentAddReq) {
        EntityWrapper<Department> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("dep_name", departmentAddReq.getDepName());
        Department departmentSelect = selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(departmentSelect)){
            throw new DepartmentException(ResponseEnums.DEPARTMENT_HAS);
        }
        Department department = new Department();
        department.setCreateTime(new Date());
        department.setDeleteFlag(0);
        department.setDepAdd(departmentAddReq.getDepAdd());
        department.setDepName(departmentAddReq.getDepName());
        department.setDepRemark(departmentAddReq.getDepRemark());
        insertAllColumn(department);
    }

    /**
     * 修改部门
     *
     * @param departmentModifyReq
     */
    @Override
    public void modifyDepartment(DepartmentModifyReq departmentModifyReq) {
        EntityWrapper<Department> entityWrapperCheck = new EntityWrapper<>();
        entityWrapperCheck.eq("delete_flag", 0);
        entityWrapperCheck.eq("dep_name", departmentModifyReq.getDepName());
        Department departmentSelect = selectOne(entityWrapperCheck);
        if (CommonUtil.isNotEmpty(departmentSelect)  && !departmentSelect.getId().equals(departmentModifyReq.getId())){
            throw new DepartmentException(ResponseEnums.DEPARTMENT_HAS);
        }
        EntityWrapper<Department> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", departmentModifyReq.getId());
        Department department = selectOne(entityWrapper);
        if (CommonUtil.isEmpty(department)){
            throw new DepartmentException(ResponseEnums.MODIFY_NULL);
        }
        department.setDepName(departmentModifyReq.getDepName());
        department.setDepAdd(departmentModifyReq.getDepAdd());
        department.setDepRemark(departmentModifyReq.getDepRemark());
        updateAllColumnById(department);
    }

    /**
     * 删除部门
     *
     * @param departmentDelReq
     */
    @Override
    public void delDepartment(DepartmentDelReq departmentDelReq) {
        EntityWrapper<Department> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.eq("id", departmentDelReq.getId());
        Department department = selectOne(entityWrapper);
        if (CommonUtil.isEmpty(department)){
            throw new DepartmentException(ResponseEnums.DEL_NULL);
        }
        department.setDeleteFlag(1);
        updateById(department);
    }

    /**
     * 获取所有部门
     *
     * @return
     */
    @Override
    public List<Department> listAllDepartment() {
        EntityWrapper<Department> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("delete_flag", 0);
        List<Department> departmentList = selectList(entityWrapper);
        return departmentList;
    }
}
