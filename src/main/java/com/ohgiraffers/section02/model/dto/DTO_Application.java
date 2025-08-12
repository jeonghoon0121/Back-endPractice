package com.ohgiraffers.section02.model.dto;


public class DTO_Application {
    public static void main(String[] args) {
        MemberDTO min=new MemberDTO();

        min.setMemberName("name");
        min.setMemberID(900);
        min.setMemberDate(new java.sql.Date(System.currentTimeMillis()));

        System.out.println(min.toString());
        min.toString();

        WorkoutlogDTO win=new WorkoutlogDTO(min, 100,new java.sql.Date(System.currentTimeMillis()),new java.sql.Time(System.currentTimeMillis()),new java.sql.Time(System.currentTimeMillis()));
        System.out.println("test1");
        System.out.println(win.getMemberID());
        win.toString();
        System.out.println(win.toString());
        System.out.println("test1");


    }
}
