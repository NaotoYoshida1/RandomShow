package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RandomStringController {

	@Autowired
	RandomStringGenerator gen;

	@RequestMapping("/")
	public String index() {
		return "random";
	}

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public ModelAndView generate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "") String withNumber,
			@RequestParam(name = "withLanguage", defaultValue = "") String withLanguage,
			@RequestParam("count") final int count,
			ModelAndView mv) {
		boolean withNumFlag = "1".equals(withNumber);
		boolean withLangFlag = "1".equals(withLanguage);
		List<String> randomStringList = gen.generate(charLength, withNumFlag, count, withLangFlag);
		mv.addObject("randList", randomStringList);
		//タイムリーフに渡す
		mv.addObject("count", count);
		//タイムリーフに渡す
		mv.addObject("charLen", charLength);

		mv.setViewName("random");
		return mv;
	}
}
