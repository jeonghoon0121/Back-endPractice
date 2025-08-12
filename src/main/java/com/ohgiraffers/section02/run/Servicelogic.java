package com.ohgiraffers.section02.run;

import com.ohgiraffers.section02.model.dao.MemberDAO;
import com.ohgiraffers.section02.model.dto.ExcerciseDTO;
import com.ohgiraffers.section02.model.dto.MemberDTO;
import com.ohgiraffers.section02.model.dto.WorkoutlogDTO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Servicelogic {
    private MemberDAO dao;
    private Connection con;
    private Scanner sc;
    public Servicelogic(){};

    public Servicelogic(MemberDAO dao){
        this.dao=dao;
        sc=new Scanner(System.in);
        con = getConnection();
    };
    public void SearchMemberAll(){
        List<Map<Integer,String>> memberList=dao.selectAllMember(con);
        for(Map<Integer, String> member : memberList) {
            System.out.println("ID,MEMBER="+member);
        }
    }
    public void SearchOneMember(){
        System.out.print("조회할 ID:");
        int memberID=sc.nextInt();
        ExcerciseDTO excerciseDTO=dao.selectMemberByIdAllData2(memberID,con);
        if(excerciseDTO != null) {
            System.out.println("회원 ID: " +excerciseDTO.getMemberID());
            System.out.println("회원이름: " +excerciseDTO.getMemberName());
            System.out.println("등록일: " +excerciseDTO.getMemberDate());
            System.out.println("로그 ID: " +excerciseDTO.getLogID());
            System.out.println("운동일:" +excerciseDTO.getLogDate());
            System.out.println("입장시간: " +excerciseDTO.getLogInTime());
            System.out.println("퇴장시간" +excerciseDTO.getLogOutTime());
            System.out.println("운동 ID:"+excerciseDTO.getExrID());
            System.out.println("운동 세트"+excerciseDTO.getExrSet());
            System.out.println("운동 개수"+excerciseDTO.getSetCnt());
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }
    public void SearchOneMember2(){
        System.out.print("조회할 ID:");
        int memberID=sc.nextInt();
        ExcerciseDTO excerciseDTO=dao.selectMemberByIdAllData2(memberID,con);
        if(excerciseDTO != null) {
            System.out.println("회원 ID: " +excerciseDTO.getMemberID());
            System.out.println("회원이름: " +excerciseDTO.getMemberName());
            System.out.println("등록일: " +excerciseDTO.getMemberDate());
            System.out.println("로그 ID: " +excerciseDTO.getLogID());
            System.out.println("운동일:" +excerciseDTO.getLogDate());
            System.out.println("입장시간: " +excerciseDTO.getLogInTime());
            System.out.println("퇴장시간" +excerciseDTO.getLogOutTime());
            System.out.println("운동 ID:"+excerciseDTO.getExrID());
            System.out.println("운동 세트"+excerciseDTO.getExrSet());
            System.out.println("운동 개수"+excerciseDTO.getSetCnt());
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }
    public void SearchOneMember3() {
        System.out.print("조회할 ID: ");
        int memberID = sc.nextInt();

        List<ExcerciseDTO> exerciseList = dao.selectMemberByIdAllData3(memberID, con);

        if (exerciseList != null && !exerciseList.isEmpty()) {
            for (ExcerciseDTO dto : exerciseList) {
                System.out.println("회원 ID: " + dto.getMemberID());
                System.out.println("회원 이름: " + dto.getMemberName());
                System.out.println("등록일: " + dto.getMemberDate());
                System.out.println("로그 ID: " + dto.getLogID());
                System.out.println("운동일: " + dto.getLogDate());
                System.out.println("입장시간: " + dto.getLogInTime());
                System.out.println("퇴장시간: " + dto.getLogOutTime());
                System.out.println("운동 ID: " + dto.getExrID());
                System.out.println("운동 이름: " + dto.getExerName());
                System.out.println("운동 세트: " + dto.getExrSet());
                System.out.println("운동 개수: " + dto.getSetCnt());
                System.out.println("────────────────────────────");
            }
        } else {
            System.out.println("해당 회원의 운동 기록이 없습니다.");
        }
    }

    public void InsertMember(){
        int maxMemberCode=dao.selectLastMemberCode(con);
        System.out.println("마지막숫자:"+maxMemberCode);
        System.out.print("이름입력");
        String insertName=sc.nextLine();
        MemberDTO newMember=new MemberDTO(maxMemberCode+1,insertName,new Date(System.currentTimeMillis()));
        int result=dao.insertNewMember(newMember,con);
        if(result > 0) {
            System.out.println(newMember.toString());
            System.out.println("InsertMember 성공");
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }
    public void InsertWorkout(){
        int maxWorkoutCode=dao.selectWorkoutCode(con);
        System.out.println("마지막로그"+maxWorkoutCode);

        System.out.print("회원 ID 입력: ");
        int memberId = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기
        System.out.print("운동 날짜 입력 (yyyy-MM-dd):");
        String dateInput = sc.nextLine();
        java.sql.Date workoutDate = new java.sql.Date(System.currentTimeMillis());
        System.out.print("입장 시간 입력 (HH:mm:ss):");
        String inTimeInput = sc.nextLine();
        java.sql.Time inTime = java.sql.Time.valueOf(inTimeInput);
        System.out.print("퇴장 시간 입력 (HH:mm:ss):");
        String outTimeInput = sc.nextLine();
        java.sql.Time outTime = java.sql.Time.valueOf(outTimeInput);

        /*객체생성*/
        WorkoutlogDTO workoutlogdto=new WorkoutlogDTO(memberId,maxWorkoutCode+1,workoutDate,inTime,outTime);
        workoutlogdto.setMemberID(memberId);

        int result= dao.insertNewWorkoutlog(workoutlogdto,con);
        if(result > 0) {
            System.out.println(workoutlogdto.toString());
            System.out.println("InsertMember 성공");
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }
    public void InsertExercise(){
        int maxExerCode=dao.selectExerciseCode(con);
        System.out.println("마지막ID"+maxExerCode);

        ExcerciseDTO insertExercise=new ExcerciseDTO();
        insertExercise.setExrID(maxExerCode+1);
        System.out.print("logID");
        insertExercise.setLogID(sc.nextInt());
        sc.nextLine();
        System.out.print("운동이름?");
        insertExercise.setExerName(sc.nextLine());
        System.out.print("세트수?:");
        insertExercise.setExrSet(sc.nextInt());
        System.out.print("개수???:");
        insertExercise.setSetCnt(sc.nextInt());

        int result=dao.insertNewExerciselog(insertExercise,con);


        if(result > 0) {
            System.out.println(insertExercise.toString());
            System.out.println("InsertExr 성공");
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }


    public void DeleteMember(){
        int result =dao.deleteMember(con);
        if(result > 0) {
            System.out.println("회원 삭제 성공! 삭제된 회원 ID:");
        } else {
            System.out.println("회원 삭제 실패!");
        }
    }
    public void DeleteMember2(){
        System.out.println("멤버ID입력:");
        int DeleteNumber=sc.nextInt();

        int result=dao.deleteMember2(DeleteNumber,con);
        if(result>0){
            System.out.println("삭제성공");
        }else{
            System.out.println("삭제실패");
        }
    }
    public void UpdateMember(){
        System.out.print("수정할 ID입력:");
        int deleteNumber=sc.nextInt();
        sc.nextLine();
        int result1=dao.deleteMember2(deleteNumber,con);
        if(result1>0){
            System.out.println("삭제성공");
        }else{
            System.out.println("삭제실패");
        }
        int maxMemberCode=dao.selectLastMemberCode(con);
        System.out.println("마지막숫자:"+maxMemberCode);
        System.out.print("이름입력");
        String insertName=sc.nextLine();
        MemberDTO newMember=new MemberDTO(maxMemberCode+1,insertName,new Date(System.currentTimeMillis()));
        int result2=dao.insertNewMember(newMember,con);

        if(result2> 0) {
            System.out.println(newMember.toString());
            System.out.println("InsertMember 성공");
        } else {
            System.out.println("잘못된 번호입니다.");
        }
    }
    public void UpdateMember2(){
        MemberDTO updateDTO=new MemberDTO();
        System.out.print("수정할 ID 입력:");
        updateDTO.setMemberID(sc.nextInt());
        sc.nextLine();
        System.out.println("변경할 이름 입력:");
        updateDTO.setMemberName(sc.nextLine());
        updateDTO.setMemberDate(new Date(System.currentTimeMillis()));
        int result=dao.updateMember(updateDTO,con);
        if(result>0){
            System.out.println("성공");
        }
        else{
            System.out.println("실패");
        }
    }



}
