package com.fh.shop.backend.mapper.member;

import com.fh.shop.backend.po.member.Member;

import java.util.List;

public interface IMemberMapper {
    List<Member> findMemberList(Member member);

    Long queryCount(Member member);

    Member toUpdateMember(Integer id);

    void updateMember(Member member);
}
