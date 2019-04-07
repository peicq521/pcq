package com.fh.shop.backend.biz.dept;

import com.fh.shop.backend.po.dept.DeptInfo;

import java.util.List;


public interface IDeptService {

    void findDept(DeptInfo deptInfo);

    List<DeptInfo> findDeptList(DeptInfo deptInfo);

    void addDept(DeptInfo deptInfo);

    void deleteDept(List<Integer> ids);

    DeptInfo findDeptById(Integer id);

    void updateDept(DeptInfo deptInfo);

}
