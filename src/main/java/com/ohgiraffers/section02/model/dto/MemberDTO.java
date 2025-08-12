package com.ohgiraffers.section02.model.dto;


import java.sql.Date;

public class MemberDTO {
    private int memberID;
    private String memberName;
    private Date memberDate;

    public MemberDTO (){}
    public MemberDTO(int memberID) {

        this.memberID = memberID;
    }
    public MemberDTO(int memberID, String memberName, Date memberDate) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberDate = memberDate;
    }
    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(Date memberDate) {
        this.memberDate = memberDate;
    }
    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", memberDate=" + memberDate +
                '}';
    }
}
