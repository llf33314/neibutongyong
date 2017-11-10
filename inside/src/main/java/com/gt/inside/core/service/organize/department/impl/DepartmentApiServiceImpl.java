package com.gt.inside.core.service.organize.department.impl;

import com.gt.inside.core.entity.organize.department.Department;
import com.gt.inside.core.service.organize.department.DepartmentApiService;
import com.gt.inside.core.service.organize.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by psr on 2017/10/31 0031.
 */
@Service
public class DepartmentApiServiceImpl implements DepartmentApiService {

    @Autowired
    DepartmentService departmentService;

    /**
     * 获取所有部门
     *
     * @return
     */
    @Override
    public List<Department> listAllDepartment() {
        return departmentService.listAllDepartment();
    }
}
