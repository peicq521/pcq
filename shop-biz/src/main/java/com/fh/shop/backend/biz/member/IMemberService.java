package com.fh.shop.backend.biz.member;

import com.fh.shop.backend.common.DataTableInfo;
import com.fh.shop.backend.po.member.Member;

public interface IMemberService {
    DataTableInfo buildDataTable(Member member, Integer start, Integer length, Integer draw, String orderDir, String beanName);

    Member toUpdateMember(Integer id);

    void updateMember(Member member);
}
