package com.ohgiraffers.section02.model.dto;

import java.sql.Date;
import java.sql.Time;

public class WorkoutlogDTO extends MemberDTO{
    private int logID;
    private Date logDate;
    private Time logInTime;
    private Time logOutTime;

    public WorkoutlogDTO(){};
    public WorkoutlogDTO(WorkoutlogDTO workoutDTO){};


    public WorkoutlogDTO(MemberDTO memberDTO, int logID, Date logDate, Time logInTime, Time logOutTime) {
        this.setMemberID(memberDTO.getMemberID());
        this.setMemberName(memberDTO.getMemberName());
        this.setMemberDate(memberDTO.getMemberDate());
        this.logID = logID;
        this.logDate = logDate;
        this.logInTime = logInTime;
        this.logOutTime = logOutTime;
    };

    public WorkoutlogDTO(int memberID,int maxWorkoutCode, Date workoutDate, Time inTime, Time outTime) {
        this.setMemberID(memberID);
        this.setLogID(maxWorkoutCode);
        this.logDate=workoutDate;
        this.logInTime=inTime;
        this.logOutTime=outTime;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public Time getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(Time logInTime) {
        this.logInTime = logInTime;
    }

    public Time getLogOutTime() {
        return logOutTime;
    }

    public void setLogOutTime(Time logOutTime) {
        this.logOutTime = logOutTime;
    }


    @Override
    public String toString() {
        return "WorkoutlogDTO{" +
                "logID=" + logID +
                ", logDate=" + logDate +
                ", logInTime=" + logInTime +
                ", logOutTime=" + logOutTime +
                '}';
    }
}
