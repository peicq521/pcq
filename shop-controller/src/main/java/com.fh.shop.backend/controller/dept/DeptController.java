package com.fh.shop.backend.controller.dept;

import com.fh.shop.backend.biz.dept.IDeptService;
import com.fh.shop.backend.biz.user.IUserService;
import com.fh.shop.backend.po.dept.DeptInfo;
import com.fh.shop.backend.serverResponse.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RequestMapping("/dept")
@RestController
public class DeptController {
    @Resource(name = "deptService")
    private IDeptService deptService;
    @Resource(name = "userService")
    private IUserService userService;

  @RequestMapping("findDept")
    public ServerResponse findDept(DeptInfo deptInfo,
                                   Integer draw,
                                   Integer start,
                                   Integer length,
                                   HttpServletRequest request){
        deptService.findDept(deptInfo);

        return ServerResponse.success();
    }
    @RequestMapping("findDeptList")
    public ServerResponse findDeptList(DeptInfo deptInfo){
      List<DeptInfo> deptInfoList=deptService.findDeptList(deptInfo);
      return ServerResponse.success(deptInfoList);
    }
    @RequestMapping("addDept")
    public ServerResponse addDept(DeptInfo deptInfo){

        deptService.addDept(deptInfo);
        return ServerResponse.success(deptInfo.getId());
    }
    @RequestMapping("deleteDept")
    public ServerResponse deleteDept(@RequestParam("ids []") List<Integer> ids){
       // List<User> userList= userService.findDeptByIds(ids);
        deptService.deleteDept(ids);
        return ServerResponse.success();
    }
    @RequestMapping("findDeptById")
    public ServerResponse findDeptById(Integer id){
       DeptInfo deptInfo = deptService.findDeptById(id);
        return ServerResponse.success(deptInfo);
    }
    @RequestMapping("updateDept")
    public ServerResponse updateDept(DeptInfo deptInfo){
               deptService.updateDept(deptInfo);
      return ServerResponse.success();
    }

}
