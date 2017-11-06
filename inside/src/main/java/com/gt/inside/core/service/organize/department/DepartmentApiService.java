package com.gt.inside.core.service.organize.department;

import com.gt.inside.core.entity.organize.department.Department;

import java.util.List;

/**
 * Created by psr on 2017/10/31 0031.
 */
public interface DepartmentApiService {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> listAllDepartment();

}
