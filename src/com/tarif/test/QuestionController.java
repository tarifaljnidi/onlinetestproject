package com.tarif.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.tarif.test.dao.QuestionDao;
import com.tarif.test.entity.Quest;
import com.tarif.test.entity.Question;

@Controller
@EnableWebMvc
public class QuestionController 
{
	@Autowired
	QuestionDao qDao;
	
		@RequestMapping("saveQuestion.htm")
		public ModelAndView saveQuestion(@ModelAttribute Question q)
		{
			
			ModelAndView mv = new ModelAndView("printQuestions.jsp");
			qDao.saveQuestion(q);
			return mv;
		}
		
		@RequestMapping("getQuestions")
		@ResponseBody
		public List<Question> getQuestions()
		{
			List<Question> questions = qDao.getTestQuestions();
			
			System.out.println(questions);
			
			return questions;
		}
		
		@RequestMapping("/test")
		public ModelAndView test()
		{
			ModelAndView mv = new ModelAndView("2.jsp");
			
			return mv;
		}
		@RequestMapping("/verify.htm")
		public ModelAndView verify(@ModelAttribute Quest quest)
		{
			
			int result=qDao.verify(quest);
			ModelAndView mv = new ModelAndView("result.jsp");
			mv.addObject("result",result);
			mv.addObject("percent",result*20);
			return mv;
		}
}

	


