/**
 * <pre>项目名称:shop_admin_v2
 * 文件名称:UserController.java
 * 包名:com.fh.shop.backend.web.controller.user
 * 创建日期:2019年1月7日下午3:54:12
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package com.fh.shop.backend.controller.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fh.shop.backend.common.FileInfo;
import com.fh.shop.backend.controller.BaseController;
import com.fh.shop.backend.util.*;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fh.shop.backend.biz.user.IUserService;
import com.fh.shop.backend.po.user.User;
import com.fh.shop.backend.serverResponse.ResponseEnum;
import com.fh.shop.backend.serverResponse.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * <pre>项目名称：shop_admin_v2
 * 类名称：UserController
 * 类描述：
 * 创建人：王亚州 2592683566@qq.com
 * 创建时间：2019年1月7日 下午3:54:12
 * 修改人：王亚州 2592683566@qq.com
 * 修改时间：2019年1月7日 下午3:54:12
 * 修改备注：
 * @version </pre>
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {

    @Resource(name = "userService")
    private IUserService userService;


    @RequestMapping("login")
    public String login() {
        return "user/login";
    }




    @RequestMapping("checkCunt")
    @ResponseBody
    public ServerResponse checkCunt(User user, HttpServletRequest request, HttpServletResponse response) {
        try {

            String userName = user.getUserName();
            String passWord = user.getPassWord();
            String imageCode = user.getImageCode();

            //判断用户名 密码 验证码是否为空
            if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord) || StringUtils.isEmpty((imageCode))) {
                return ServerResponse.error(ResponseEnum.USERNAME_USERPWD_EMPTY);
            }
            String loginId = CookieUtil.readCookie("loginId", request);
            if(loginId == null){
                String uuid = UUID.randomUUID().toString().toUpperCase();
               CookieUtil.writeCookie(response,"code:"+uuid,imageCode,0);
               RedisUtil.setnx("code:"+loginId,2*60);
            }
            String imageCode1 = RedisUtil.get("code:" + loginId);
            RedisUtil.setnx("code:"+loginId,2*60);
            // String imageCode1 = (String) request.getSession().getAttribute(SystemConstants.IMAGE_CODE);
            if (!imageCode.equals(imageCode1)) {
                return ServerResponse.error(ResponseEnum.IMAGECODE_EMPTY);
            }
            User userInfo = userService.checkCunt(user);

            //判断对象是否为空 如果为空直接返回
            if (userInfo == null) {
                return ServerResponse.error(ResponseEnum.USERNAME_EMPTY);
            }
            //如果用户状态为error直接返回
            if (userInfo.getStatus() != null && userInfo.getStatus().equals(SystemConstants.USER_STATUS)) {
                return ServerResponse.error(ResponseEnum.USER_LOCK);
            }
            String s = MD5Util.getStringMD5(user.getPassWord() + userInfo.getSalt());
            if (!s.equals(userInfo.getPassWord())) {
                //当密码错误时 错误次数+1
                user.setErrorCount(userInfo.getErrorCount() + SystemConstants.LOGIN_COUNT);
                //保存到数据库
                userService.updateUser(user);
                //如果密码错误3次后将用户状态设置为锁定状态
                if (userInfo.getErrorCount() == SystemConstants.LOGIN_ERROR_STATUS) {
                    user.setStatus(SystemConstants.USER_STATUS);
                    user.setId(userInfo.getId());
                    userService.updateUser(user);
                }
                return ServerResponse.error(ResponseEnum.USERPWD_EMPTY);
            }
            //request.getSession().setAttribute(SystemConstants.USERINFO, userInfo);
            //如果当前时间为空时 也就是说用户第一次登陆时
            if (userInfo.getCorrentDate() == null) {
                //将当前时间赋给上次登陆时间 将登陆次数设为1
                user.setCorrentDate(new Date());
                user.setCoount(SystemConstants.LOGIN_COUNT);
                user.setId(userInfo.getId());
                userService.updateUser(user);
            } else {
                //否则 登陆次数+1
                user.setCoount(userInfo.getCoount() + SystemConstants.LOGIN_COUNT);
                Date date = new Date();
                user.setCorrentDate(date);
                //当前时间（精确到天）
                Date currentTime = DateUtil.str2Date(DateUtil.date2Str(date, DateUtil.L_M_D), DateUtil.L_M_D);
                Date upLoginTime = userInfo.getCorrentDate();
                //上次登陆时间（精确到天）
                Date upLoginTime1 = DateUtil.str2Date(DateUtil.date2Str(upLoginTime, DateUtil.L_M_D), DateUtil.L_M_D);
                //如果当前时间在上次登录时间后面则证明是第二天
                if (currentTime.after(upLoginTime1)) {
                    user.setCoount(SystemConstants.LOGIN_COUNT);
                    user.setId(userInfo.getId());
                    userService.updateUser(user);
                }
            }
            if (userInfo.getErrorCount() < 3) {
                //如果密码错误次数小于3时 也是当账号未被锁定之前 登陆成功后将次数重置为0
                userInfo.setErrorCount(0);

            }
            user.setId(userInfo.getId());
            userService.updateUser(user);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ServerResponse.error(ResponseEnum.ERROR);
        }
        String loginId = CookieUtil.readCookie("loginId", request);
        Gson gson = new Gson();
        String s = gson.toJson(user);
        RedisUtil.set("user:"+loginId,s);
        RedisUtil.setnx("user:"+loginId,30*60);
       // request.getSession().setAttribute(SystemConstants.LOGIN_USER, user);

        return ServerResponse.success();
    }

    @RequestMapping("findUser")
    @ResponseBody
    public Map findUser(Integer length,
                                   Integer draw,
                                   Integer start,
                                   User user,
								   HttpServletRequest request) {
        String order = request.getParameter("order[0][column]");//排序的列号
        String orderDir = request.getParameter("order[0][dir]");//排序的顺序asc or desc
        String beanName = request.getParameter("columns[" + order + "][data]");//排序的列。注意，我认为页面上的列的名字要和表中列的名字一致，否则，会导致SQL拼接错误
        user.setSortField(beanName);
        user.setSort(orderDir);
        Map<Object, Object> resultMap = new HashMap<>();
        Long count = userService.queryCount(user);
        user.setStartPos(start);
        user.setPageSize(length);
        List<User> userList = userService.findUser(user);
        converDate(userList);
        resultMap.put("draw", draw);
        resultMap.put("recordsTotal", count);
        resultMap.put("recordsFiltered", count);
        resultMap.put("data", userList);
        return resultMap;
    }
    private void converDate(List<User> list) {
        for (User shop : list) {
        shop.setBirthdayStr(DateUtil.date2Str(shop.getBirthday(), DateUtil.L_M_D_H_M_S));
    }
}

    @RequestMapping("addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("addUserInfo")
    @ResponseBody
    public ServerResponse addUserInfo(User user) {
        userService.addUserInfo(user);
        return ServerResponse.success();
    }


    @RequestMapping("toAdd")
    public String toAdd() {
        return "user/addUser";
    }

    @RequestMapping("toUser")
    public String toUser() {
        return "user/listUser";
    }

    @RequestMapping("deleteUser")
    @ResponseBody
    public ServerResponse deleteUser(Integer id) {
        userService.deleteUser(id);
        return ServerResponse.success();
    }
    @RequestMapping("deleteUserInfo")
    @ResponseBody
    public ServerResponse deleteUserInfo(@RequestParam("ids[]") List<Integer> ids) {
        userService.deleteUserInfo(ids);
        return ServerResponse.success();
    }
    @RequestMapping("updateUserDept")
    @ResponseBody
    public ServerResponse updateUserDept(User user){
        userService.updateUserDept(user);
        return ServerResponse.success();
    }

    @RequestMapping("findUserById")
    @ResponseBody
    public ServerResponse findUserById(Integer id) {
       User userInfo =userService.findUserById(id);
        return ServerResponse.success(userInfo);
    }
    @RequestMapping("updateUser")
    @ResponseBody
    public ServerResponse updateUser(User user){
        userService.updateUser(user);
        return ServerResponse.success();
    }
    @RequestMapping("updateDept")
    @ResponseBody
    public ServerResponse updateDept(@RequestParam("ids[]") List<Integer> ids,Integer deptIds){
        userService.updateDept(ids,deptIds);
        return ServerResponse.success();
    }

    @RequestMapping(value = "uploadFile" , method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse uploadFile(@RequestParam("uploadImgFile") MultipartFile uploadImgFile, HttpServletRequest request){
        //获取项目根目录
        FileInfo fileInfo = createFileInfo(uploadImgFile);

        String realPath = getRootPath(request);

        String filePath = realPath + SystemConstants.PRODUCT_PICTURE_PATH;

        String path = FileUtil.copyFile(fileInfo.getInputStream(), fileInfo.getFileName(), filePath);

        String s = TXCos.cosStore(realPath+SystemConstants.PRODUCT_PICTURE_PATH+path);

        return ServerResponse.success(s);
    }

}
