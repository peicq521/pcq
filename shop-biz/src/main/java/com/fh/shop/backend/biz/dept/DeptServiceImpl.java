package com.fh.shop.backend.biz.dept;

import com.fh.shop.backend.mapper.dept.IDeptMapper;
import com.fh.shop.backend.po.dept.DeptInfo;

import com.fh.util.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements IDeptService{
    @Autowired
    private IDeptMapper deptMapper;

    @Override
    public void findDept(DeptInfo deptInfo) {
        deptMapper.findDept(deptInfo);
    }

    @Override
    public List<DeptInfo> findDeptList(DeptInfo deptInfo) {
        CacheManager instance =  CacheManager.getInstance();
        Object object = instance.getObj("deptList");
        if(object!=null){
            return (List<DeptInfo>) object;
        }
        List<DeptInfo> deptInfoList = deptMapper.findDeptList(deptInfo);
        instance.putObj("deptList",deptInfoList);
        return deptInfoList;
    }

    @Override
    public void addDept(DeptInfo deptInfo) {

        deptMapper.addDept(deptInfo);
        CacheManager instance =  CacheManager.getInstance();
        instance.remove("deptList");
    }

    @Override
    public void deleteDept(List<Integer> ids) {
        deptMapper.deleteDept(ids);
        CacheManager instance =  CacheManager.getInstance();
        instance.remove("deptList");
    }



    @Override
    public  DeptInfo findDeptById(Integer id) {
        DeptInfo deptInfoList =  deptMapper.findDeptById(id);
        return deptInfoList;
    }

    @Override
    public void updateDept(DeptInfo deptInfo) {
        deptMapper.updateDept(deptInfo);
        CacheManager instance =  CacheManager.getInstance();
        instance.remove("deptList");
    }


}
