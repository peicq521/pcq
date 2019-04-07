package com.fh.shop.backend.controller.member;

import com.fh.shop.backend.biz.member.IMemberService;
import com.fh.shop.backend.common.DataTableInfo;
import com.fh.shop.backend.po.member.Member;
import com.fh.shop.backend.serverResponse.ServerResponse;
import com.fh.shop.backend.util.SystemConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Resource(name = "memberService")
    private IMemberService memberService;

    @RequestMapping(value = "findMemberList")
    @ResponseBody
    public ServerResponse findMemberList(Member member, Integer start, Integer length, Integer draw, HttpServletRequest req){
        String order = req.getParameter(SystemConstants.ORDER_COLUMN);//排序的列号
        String orderDir = req.getParameter(SystemConstants.ORDER_DIR);//排序的顺序asc or desc
        String beanName = req.getParameter(buildParam(order));//排序的列。注意，我认为页面上的列的名字要和表中列的名字一致，否则，会导致SQL拼接错误
        DataTableInfo dataTableInfo =  memberService.buildDataTable(member, start, length, draw, orderDir, beanName);
        return ServerResponse.success(dataTableInfo);
    }
    @RequestMapping(value = "toUpdateMember")
    @ResponseBody
    public ServerResponse toUpdateMember(Integer id){
       Member member = memberService.toUpdateMember(id);
        return  ServerResponse.success(member);
    }
    @RequestMapping(value = "updateMember")
    @ResponseBody
    public ServerResponse updateMember(Member member){
        memberService.updateMember(member);
        return ServerResponse.success();
    }

    private String buildParam(String order) {
        return "columns[" + order + "][data]";
    }

    @RequestMapping(value = "toMember")
    public String toMember(){
        return "member/list";
    }


}
