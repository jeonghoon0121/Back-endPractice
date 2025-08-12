package com.ohgiraffers.section02.model.dto;

public class ExcerciseDTO extends WorkoutlogDTO {
    private int exrID;
    private int exrSet;
    private int setCnt;
    private String exerName;

    public ExcerciseDTO() {};

    public ExcerciseDTO(ExcerciseDTO excerciseDTO) {
    }

    ;

    public ExcerciseDTO(WorkoutlogDTO workoutlogDTO, int exrID, String name, int exrSet, int setCnt) {
        this.setMemberID(workoutlogDTO.getMemberID());
        this.setMemberName(workoutlogDTO.getMemberName());
        this.setMemberDate(workoutlogDTO.getMemberDate());
        this.setLogID(workoutlogDTO.getLogID());
        this.setLogDate(workoutlogDTO.getLogDate());
        this.setLogInTime(workoutlogDTO.getLogInTime());
        this.setLogOutTime(workoutlogDTO.getLogOutTime());
        this.exerName = name;
        this.exrID = exrID;
        this.exrSet = exrSet;
        this.setCnt = setCnt;
    }

    public int getExrID() {
        return exrID;
    }

    public void setExrID(int exrID) {
        this.exrID = exrID;
    }

    public int getExrSet() {
        return exrSet;
    }

    public void setExrSet(int exrSet) {
        this.exrSet = exrSet;
    }

    public int getSetCnt() {
        return setCnt;
    }

    public void setSetCnt(int setCnt) {
        this.setCnt = setCnt;
    }

    public String getExerName() {
        return exerName;
    }

    public void setExerName(String exerName) {
        this.exerName = exerName;
    }

    @Override
    public String toString() {
        return "ExcerciseDTO{" +
                "exrID=" + exrID +
                ", exrSet=" + exrSet +
                ", setCnt=" + setCnt +
                ", exerName='" + exerName + '\'' +
                '}';
    }
}
