package com.jdbc.mapper;

import com.jdbc.entity.Outcome;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OutcomeMapper implements RowMapper<Outcome> {
    public Outcome mapRow(ResultSet rs, int rowNum) throws SQLException {
        Outcome outcome = new Outcome();
        //create table outcomes (
        //			major varchar (50), program varchar (50), coop varchar (3),
        //            grade_range char (10), tuition_fee char (10), program_rank char(4),
        //            university varchar (30), university_rank char(4), city varchar (20));
        outcome.setHowManyMajors("howmany_majors");
        outcome.setMajor(rs.getString("major"));
        outcome.setProgram(rs.getString("program"));
        outcome.setCoop(rs.getString("coop"));
        outcome.setGradeRange(rs.getString("grade_range"));
        outcome.setTuitionFee(rs.getString("tuition_fee"));
        outcome.setProgramRank(rs.getString("program_rank"));
        outcome.setUniversity(rs.getString("university"));
        outcome.setUniversityRank(rs.getString("university_rank"));
        outcome.setCity(rs.getString("city"));
        return outcome;
    }

}
