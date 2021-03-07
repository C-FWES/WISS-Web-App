package com.example.servingwebcontent;

import com.jdbc.dao.OutcomeDAO;
import com.jdbc.entity.Outcome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class WISSController {


	private OutcomeDAO outcomeDAO = new OutcomeDAO();


	@GetMapping("/university-results")
	public String universityById(@RequestParam(value = "program") Optional<String> programName,
								 @RequestParam(value = "uni") Optional<String> universityName,
								 @RequestParam(value = "location") Optional<String> location,
								 @RequestParam(value = "tuitionfee")Optional<String> tuitionFee,
								 @RequestParam(value = "program_rank")Optional<String> programRank,
								 @RequestParam(value = "universityrank")Optional<String> universityRank,
								 @RequestParam(value = "orderBy")Optional<String> orderBy, Model model) {


		if (programName.isPresent()) {
			session().setAttribute("programName", programName.get());
			session().setAttribute("universityName", universityName.get());
			session().setAttribute("location", location.get());
			session().setAttribute("tuitionFee", tuitionFee.get());
			session().setAttribute("programRank", programRank.get());
			session().setAttribute("universityRank", universityRank.get());
			session().setAttribute("orderBy", orderBy.get());
		}

		String programNameNew = programName.orElse((String)session().getAttribute("programName"));
		String universityNameNew = universityName.orElse((String)session().getAttribute("universityName"));
		String locationNew = location.orElse((String)session().getAttribute("location"));
		String tuitionFeeNew = tuitionFee.orElse((String)session().getAttribute("tuitionFee"));
		String programRankNew = programRank.orElse((String)session().getAttribute("programRank"));
		String universityRankNew = universityRank.orElse((String)session().getAttribute("universityRank"));
		String orderByNextNew = orderBy.orElse((String)session().getAttribute("orderBy"));

		String orderByNext = "";
		if (orderByNextNew.equals("asc")) {
			orderByNextNew = "desc";
		}
		else if (orderByNextNew.equals("desc")) {
			orderByNextNew = "asc";
		}


		List<Outcome> outcomes = outcomeDAO.retrieveByUniversityAndProgramAndCity(universityNameNew, programNameNew, locationNew,
				tuitionFeeNew, programRankNew, universityRankNew, orderByNextNew);

			model.addAttribute("outcomesHTML", outcomes);
			model.addAttribute("programHTML", programNameNew);
			model.addAttribute("universityHTML", universityNameNew);
			model.addAttribute("locationHTML", locationNew);
			model.addAttribute("tutionFeeHTML", tuitionFeeNew);
			model.addAttribute("programRankHTML", programRankNew);
			model.addAttribute("universityRankHTML", universityRankNew);
			model.addAttribute("sourcePageHTML", "explore");

		return "university-results";
	}


	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}




	@GetMapping("/keywordSearch")
	public String keywordSearch(@RequestParam(value = "keyword") Optional<String> keyword, Model model) {
		List<Outcome> outcomes = outcomeDAO.retrieveByKeywordSearch(keyword.orElse("jhgkbggfhff"));

		model.addAttribute("outcomesHTML", outcomes);
		model.addAttribute("sourcePageHTML", "search");

		return "university-results";
	}

	@GetMapping("/quiz")
	public String submitQuiz(@RequestParam(value = "q1") int q1, @RequestParam(value = "q2") int q2, @RequestParam(value = "q3") int q3,
							 @RequestParam(value = "q4") int q4, @RequestParam(value = "q5") int q5, @RequestParam(value = "q6") int q6,
							 @RequestParam(value = "q7") int q7, @RequestParam(value = "q8") int q8, @RequestParam(value = "q9") int q9,
							 @RequestParam(value = "q10") int q10, Model model) {
		String recommended = outcomeDAO.findMajor(q1,q2,q3,q4,q5,q6,q7,q8,q9,q10);

		model.addAttribute("recommendedHTML", recommended);

		return "quiz-results";
	}

	@GetMapping("/jumpToProgram")
	public String jumpToProgram(Model model) {
		model.addAttribute("jumpToProgram");
		return "redirect:elec-engineer.html#program";
	}

	@GetMapping("/jumpToAdmission")
	public String jumpToAdmission(Model model) {
		model.addAttribute("jumpToAdmission");
		return "redirect:elec-engineer.html#admission";
	}

	@GetMapping("/jumpToSchool")
	public String jumpToSchool(Model model) {
		model.addAttribute("jumpToSchool");
		return "redirect:elec-engineer.html#school";
	}

	@GetMapping("/jumpToContact")
	public String jumpToContact(Model model) {
		model.addAttribute("jumpToContact");
		return "redirect:elec-engineer.html#contact";
	}
}
