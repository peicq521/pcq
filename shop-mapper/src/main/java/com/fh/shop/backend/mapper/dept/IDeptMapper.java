package com.fh.shop.backend.mapper.dept;

import com.fh.shop.backend.po.dept.DeptInfo;

import java.util.List;

public interface IDeptMapper {
    void findDept(DeptInfo deptInfo);

    List<DeptInfo> findDeptList(DeptInfo deptInfo);

    void addDept(DeptInfo deptInfo);

    DeptInfo findDeptById(Integer id);

    void updateDept(DeptInfo deptInfo);

    void deleteDept(List<Integer> ids);
}
