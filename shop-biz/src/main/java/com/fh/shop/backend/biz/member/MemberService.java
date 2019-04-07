package com.fh.shop.backend.biz.member;

import com.fh.shop.backend.common.DataTableInfo;
import com.fh.shop.backend.mapper.member.IMemberMapper;
import com.fh.shop.backend.po.member.Member;
import com.fh.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("memberService")
public class MemberService implements  IMemberService {
    @Autowired
    private IMemberMapper memberMapper;

    public DataTableInfo buildDataTable(Member member, Integer start, Integer length, Integer draw, String orderDir, String beanName) {
        //排序信息
        buildOrderInfo(member, orderDir, beanName);
        //总条数 分页信息
        Long count = queryCount(member);
        member.setStartPos(start);
        member.setPageSize(length);
        //当前页信息
        List<Member> list = memberMapper.findMemberList(member);
        converDate(list);
        DataTableInfo dataTableInfo = DataTableInfo.buildDataTable(draw, count, count, list);
        return  dataTableInfo;
    }

    @Override
    public Member toUpdateMember(Integer id) {
       Member member =  memberMapper.toUpdateMember(id);
        member.setBirthdayStr(DateUtil.date2Str(member.getBirthday(),DateUtil.L_M_D));
        return member;
    }

    @Override
    public void updateMember(Member member) {
        memberMapper.updateMember(member);
    }

    public Long queryCount(Member member) {
        Long queryCount = memberMapper.queryCount(member);
        return queryCount;
    }


    private void converDate(List<Member> list) {
        for (Member memberRequest : list) {
            memberRequest.setBirthdayStr(DateUtil.date2Str(memberRequest.getBirthday(), DateUtil.L_M_D_H_M_S));
        }
    }

    private void buildOrderInfo(Member member, String orderDir, String beanName) {
        member.setSortField(beanName);
        member.setSort(orderDir);
        if (member.getSortField().equals("birthdayStr")) {
            member.setSortField("birthdayStr");
        }
    }
}
