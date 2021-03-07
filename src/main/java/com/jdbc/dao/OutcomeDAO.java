package com.jdbc.dao;

import com.jdbc.SpringJdbcConfig;
import com.jdbc.entity.Outcome;
import com.jdbc.mapper.OutcomeMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.*;

public class OutcomeDAO {
    private JdbcTemplate template;

    public OutcomeDAO() {
        DataSource dataSource = new SpringJdbcConfig().mysqlDataSource();
        this.template = new JdbcTemplate(dataSource);
    }

    public List<Outcome> retrieveAll(String orderBy) {
        String query = "SELECT * FROM OUTCOME1 ORDER BY PROGRAM " + orderBy;
        List<Outcome> outcomes = template.query(query, new OutcomeMapper());
        return outcomes;
    }

    //  private String howManyMajors;
    //    private String major;
    //    private String program;
    //    private String coop;
    //    private String gradeRange;
    //    private String tuitionFee;
    //    private String programRank;
    //    private String university;
    //    private String universityRank;
    //    private String city;
    public List<Outcome> retrieveByUniversityAndProgramAndCity(String university, String programName, String city, String tuitionFee, String programRank, String universityRank, String orderBy) {
//        String query = "SELECT * FROM OUTCOME1 WHERE " +
//                "(UNIVERSITY = ? or 'all'= ?) and " +
//                "(PROGRAM = ? or 'all'= ?) and " +
//                "(CITY = ? or 'all'=?) and " +
//                "(tuition_fee = ? or 'all'=?) and" +
//                "(program_rank = ? or 'all'=?) and " +
//                "(university_rank = ? or 'all'=?)" +
//                " ORDER BY PROGRAM " + orderBy;

        int programRankHigh = 0;
        int programRankLow = 0;
        if (programRank.equals("1")) {
            programRankHigh = 5;
            programRankLow = 1;
        }
        else if (programRank.equals("2")) {
            programRankHigh = 6;
            programRankLow = 10;
        }
        else if (programRank.equals("3")) {
            programRankHigh = 15;
            programRankLow = 11;
        }
        else if (programRank.equals("4")) {
            programRankHigh = 20;
            programRankLow = 16;
        }
        else if (programRank.equals("5")) {
            programRankHigh = 25;
            programRankLow = 21;
        }
        else if (programRank.equals("6")) {
            programRankHigh = 30;
            programRankLow = 26;
        }






        int universityRankHigh = 0;
        int universityRankLow = 0;
        if (universityRank.equals("1")) {
            universityRankHigh = 5;
            universityRankLow = 1;
        }
        else if (universityRank.equals("2")) {
            universityRankHigh = 6;
            universityRankLow = 10;
        }
        else if (universityRank.equals("3")) {
            universityRankHigh = 15;
            universityRankLow = 11;
        }
        else if (universityRank.equals("4")) {
            universityRankHigh = 20;
            universityRankLow = 16;
        }
        else if (universityRank.equals("5")) {
            universityRankHigh = 25;
            universityRankLow = 21;
        }
        else if (universityRank.equals("6")) {
            universityRankHigh = 30;
            universityRankLow = 26;
        }


        int tuitionFeeHigh = 0;
        int tuitionFeeLow = 0;
        if (tuitionFee.equals("1")) {
            tuitionFeeHigh = 8000-1;
            tuitionFeeLow = 5000;
        }
        else if (tuitionFee.equals("2")) {
            tuitionFeeHigh = 12000 - 1;
            tuitionFeeLow = 8000;
        }
        else if (tuitionFee.equals("3")) {
            tuitionFeeHigh = 15000 - 1;
            tuitionFeeLow = 12000;
        }
        else if (tuitionFee.equals("4")) {
            tuitionFeeHigh = 18000;
            tuitionFeeLow = 15000;
        }

        String query = "SELECT * FROM OUTCOME1 WHERE " +
                "(UNIVERSITY = ? or 'all'= ?) and " +
                "(PROGRAM = ? or 'all'= ?) and " +
                "(CITY = ? or 'all'=?) and " +
                "(cast(tuition_fee as int) between ? and ? or 'all'=?) and" +
                "(cast(program_rank as int) between ? and ? or 'all'=?) and " +
                "(cast(university_rank as int) between ? and ? or 'all'=?)" +
                " ORDER BY PROGRAM " + orderBy;
//SELECT * FROM OUTCOME1 where cast(university_rank as int) > 6;

        List<Outcome> outcomes = template.query(query, new Object[]{
                university, university,
                programName, programName,
                city, city,
                tuitionFeeLow, tuitionFeeHigh, tuitionFee,
                programRankLow, programRankHigh, programRank,
                universityRankLow, universityRankHigh, universityRank}, new OutcomeMapper());



        for (Outcome outcome : outcomes) {
            if (outcome.getProgram().equals("Mathematics & Business")) {
                outcome.setMoreInfo("math-biz-info.html");
            }
            else if (outcome.getProgram().equals("Computer Science")) {
                outcome.setMoreInfo("cs.html");
            }
            else if (outcome.getProgram().equals("Business")) {
                outcome.setMoreInfo("biz-management.html");
            }
            else if (outcome.getProgram().equals("Engineering") && outcome.getUniversity().equals("University of Toronto")) {
                outcome.setMoreInfo("elec-engineer-uot.html");
            }
            else if (outcome.getProgram().equals("Engineering")) {
                outcome.setMoreInfo("elec-engineer.html");
            }
            else if (outcome.getProgram().equals("Arts")) {
                outcome.setMoreInfo("art.html");
            }
        }



        return outcomes;
    }


    public List<Outcome> retrieveByKeywordSearch(String keyword) {
//SELECT * FROM OUTCOME1 where LOWER(UNIVERSITY) LIKE LOWER('%Waterlo1223%') or LOWER(program) LIKE LOWER('%engIneering%') or LOWER(CITY) LIKE LOWER('%Waterlpppp%');

        String keywordLikePattern = "'%" + keyword + "%'";
        String query = "SELECT * FROM OUTCOME1 where " +
                "LOWER(UNIVERSITY) LIKE LOWER("+ keywordLikePattern +") or " +
                "LOWER(program) LIKE LOWER("+ keywordLikePattern +") or " +
                "LOWER(CITY) LIKE LOWER("+ keywordLikePattern +");";
//SELECT * FROM OUTCOME1 where cast(university_rank as int) > 6;

        List<Outcome> outcomes = template.query(query ,new OutcomeMapper());



        for (Outcome outcome : outcomes) {
            if (outcome.getProgram().equals("Mathematics & Business")) {
                outcome.setMoreInfo("math-biz-info.html");
            }
            else if (outcome.getProgram().equals("Computer Science")) {
                outcome.setMoreInfo("cs.html");
            }
            else if (outcome.getProgram().equals("Business")) {
                outcome.setMoreInfo("biz-management.html");
            }
            else if (outcome.getProgram().equals("Engineering") && outcome.getUniversity().equals("University of Toronto")) {
                outcome.setMoreInfo("elec-engineer-uot.html");
            }
            else if (outcome.getProgram().equals("Engineering")) {
                outcome.setMoreInfo("elec-engineer.html");
            }
            else if (outcome.getProgram().equals("Arts")) {
                outcome.setMoreInfo("art.html");
            }
        }



        return outcomes;
    }








    public static String findMajor(int q1, int q2, int q3, int q4, int q5,
                                   int q6, int q7, int q8, int q9, int q10 ) {
        String major  = "";

        int[] newData = new int[]{q1,q2,q3,q4,q5,q6,q7,q8,q9,q10};

        String AA= "Electrical and Computer Engineering";
        String AB= "Management";
        String AC= "Image Arts";
        String AD= "CS";
        String AE= "CS & Business";

        int[] BA = new int[]{2,4,5,3,2,4,2,3,4,4};
        int[] BB = new int[]{5,1,3,5,5,3,3,5,1,1};
        int[] BC = new int[]{4,1,1,3,3,5,5,3,1,4};
        int[] BD = new int[]{1,4,5,1,1,1,1,3,5,5};
        int[] BE = new int[]{5,4,4,5,5,1,4,4,5,4};

        int aa = Math.abs(BA[1]-q1)^2+2*Math.abs(BA[2]-q2);
        int ab=Math.abs(BB[1]-q1)^2+2*Math.abs(BB[2]-q2);
        int ac =Math.abs(BC[1]-q1)^2+2*Math.abs(BC[2]-q2);
        int ad=Math.abs(BD[1]-q1)^2+2*Math.abs(BD[2]-q2);
        int ae=Math.abs(BE[1]-q1)^2+2*Math.abs(BE[2]-q2);

        for (int i = 3; i <= 9; i++) {
            aa=aa+Math.abs(BA[i]-newData[i]);
            ab=ab+Math.abs(BB[i]-newData[i]);
            ac=ac+Math.abs(BC[i]-newData[i]);
            ad=ad+Math.abs(BD[i]-newData[i]);
            ae=ae+Math.abs(BE[i]-newData[i]);

        }

        int bb = 0;
        int[] arr = new int[]{aa,ab,ac,ad,ae};
        Arrays.sort(arr);
        bb=arr[0];

        int[] c = new int[]{aa,ab,ac,ad,ae};
        Arrays.sort(c);
        int cc = c[1]; //0 based indexing

        if (aa==bb) {
            if (ab==cc){
                major =(AA + " and " + AB);
            }
            if (ac==cc){
                major =(AA + " and " + AC);
            }
            if (ad==cc){
                major =(AA + " and " + AD);
            }
            if (ae==cc) {
                major =(AA + " and " + AE);
            }
        }


        else if (ab==bb) {
            if (aa==cc){
                major =(AB + " and " + AA);
            }
            if (ac==cc){
                major =(AB + " and " + AC);
            }
            if (ad==cc){
                major =(AB + " and " + AD);
            }
            if (ae==cc) {
                major =(AB + " and " + AE);
            }
        }

        else if (ac==bb) {
            if (aa == cc) {
                major = (AC + " and " + AA);
            }
            if (ab == cc) {
                major = (AC + " and " + AB);
            }
            if (ad == cc) {
                major = (AC + " and " + AD);
            }
            if (ae == cc) {
                major = (AC + " and " + AE);
            }
        }

        else if (ad==bb) {
            if (aa==cc){
                major =(AD + " and " + AA);
            }
            if (ab==cc){
                major =(AD + " and " + AB);
            }
            if (ac==cc) {
                major = (AD + " and " + AC);
            }
            if (ae == cc) {
                major = (AD + " and " + AE);
            }
        }

        else {
            if (aa == cc) {
                major = (AE + " and " + AA);
            }
            if (ab == cc) {
                major = (AE + " and " + AB);
            }
            if (ac == cc) {
                major = (AE + " and " + AC);
            } else {
                major = (AE + " and " + AD);
            }
        }

        return major;
    }
}
