package com.jdbc;

import com.jdbc.dao.OutcomeDAO;
import com.jdbc.entity.Outcome;

import java.util.List;

public class test {
    public static void main(String[] args) {
//
//

     /*   OutcomeDAO outcomeDAO = new OutcomeDAO();
//        List<Outcome> outcomes = outcomeDAO.retrieveByUniversityAndProgramAndCity("University of Waterloo",  "all", "Waterloo", "asc");
        List<Outcome> outcomes = outcomeDAO.retrieveByUniversityAndProgramAndCity("all",  "all", "all", "4", "all", "all", "asc");

*/

//        OutcomeDAO outcomeDAO = new OutcomeDAO();
////        List<Outcome> outcomes = outcomeDAO.retrieveByUniversityAndProgramAndCity("University of Waterloo",  "all", "Waterloo", "asc");
//        List<Outcome> outcomes = outcomeDAO.retrieveByKeywordSearch("waterloo");
//
//        for (Outcome outcome : outcomes) {
//            System.out.println(outcome);
//        }
//
//
//  outcomes = outcomeDAO.retrieveByKeywordSearch("engineeRing");
//
//        for (Outcome outcome : outcomes) {
//            System.out.println(outcome);
//        }

        String recommended = quiz.findMajor(5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        System.out.println(recommended);



    }
}
