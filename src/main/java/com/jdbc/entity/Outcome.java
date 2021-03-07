package com.jdbc.entity;

import java.util.Objects;

public class Outcome {
    //create table outcomes (
//create table outcome1 (
//            howmany_majors char(1),
//			major varchar (50), program varchar (50), coop varchar (3),
//            grade_range char (10), tuition_fee char (10), program_rank char(4),
//            university varchar (30), university_rank char(4), city varchar (20));


    private String howManyMajors;
    private String major;
    private String program;
    private String coop;
    private String gradeRange;
    private String tuitionFee;
    private String programRank;
    private String university;
    private String universityRank;
    private String city;
    private String moreInfo;

    public String getHowManyMajors() {
        return howManyMajors;
    }

    public void setHowManyMajors(String howManyMajors) {
        this.howManyMajors = howManyMajors;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCoop() {
        return coop;
    }

    public void setCoop(String coop) {
        this.coop = coop;
    }

    public String getGradeRange() {
        return gradeRange;
    }

    public void setGradeRange(String gradeRange) {
        this.gradeRange = gradeRange;
    }

    public String getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(String tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public String getProgramRank() {
        return programRank;
    }

    public void setProgramRank(String programRank) {
        this.programRank = programRank;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getUniversityRank() {
        return universityRank;
    }

    public void setUniversityRank(String universityRank) {
        this.universityRank = universityRank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "Outcome{" +
                "major='" + major + '\'' +
                ", program='" + program + '\'' +
                ", coop='" + coop + '\'' +
                ", gradeRange='" + gradeRange + '\'' +
                ", tuitionFee='" + tuitionFee + '\'' +
                ", programRank='" + programRank + '\'' +
                ", university='" + university + '\'' +
                ", universityRank='" + universityRank + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Outcome outcome = (Outcome) o;
        return Objects.equals(howManyMajors, outcome.howManyMajors) &&
                Objects.equals(major, outcome.major) &&
                Objects.equals(program, outcome.program) &&
                Objects.equals(coop, outcome.coop) &&
                Objects.equals(gradeRange, outcome.gradeRange) &&
                Objects.equals(tuitionFee, outcome.tuitionFee) &&
                Objects.equals(programRank, outcome.programRank) &&
                Objects.equals(university, outcome.university) &&
                Objects.equals(universityRank, outcome.universityRank) &&
                Objects.equals(city, outcome.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(howManyMajors, major, program, coop, gradeRange, tuitionFee, programRank, university, universityRank, city);
    }
}
