package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Yeller;
import com.example.demo.models.Whisperer;

@Controller
@RequestMapping({"/", "/HelloWorld"})
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	public String index() {
		return "helloworld/index";
	}
	
	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="<<SHHHHHH>>") String whisper) {
		ModelAndView mv = new ModelAndView("helloworld/whisper");
		Whisperer randos = new Whisperer(whisper);
		String result = randos.soft();
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
	
	@GetMapping("message")
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");
		Yeller random = new Yeller(message);
		String result = random.yell();
		mv.addObject("title", title);
		mv.addObject("message", result);
		return mv;
	}
	 
	@GetMapping("say-something")
	public String makeAChoice(
			String speechChoice,
			String submittedMessage,
			Model theThingIPutDataIntoForTheView 
			) {
		// if speech choice is yell
		if (speechChoice.equals("yell")) {
			Yeller aVariableThatHoldsAYeller = new Yeller(submittedMessage);
			String loud = aVariableThatHoldsAYeller.yell();
			theThingIPutDataIntoForTheView.addAttribute("output", loud);
		} else { 
			Whisperer someQuietThing = new Whisperer(submittedMessage);
			String quiet = someQuietThing.soft();
			theThingIPutDataIntoForTheView.addAttribute("output", quiet);
			
			
		}
		
		return "helloworld/mixed-messages";
		
	}

}
