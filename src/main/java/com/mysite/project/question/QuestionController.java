package com.mysite.project.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	 private final QuestionRepository questionRepository;
	 private final QuestionService questionService;
	 
	@GetMapping("/list")
	public String list(Model model, @RequestParam(value="page", defaultValue="0")int page) {
		
		Page<Question> paging = this.questionService.getList(page);
		model.addAttribute("paging", paging);
		
		return "question_list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id) {
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	@GetMapping("/create")
	public String questionCreate() {
		return "question_form";
	}
	
    @PostMapping("/create")
    public String questionCreate(@RequestParam String subject, @RequestParam String content) {
    	this.questionService.create(subject, content);
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }

}
