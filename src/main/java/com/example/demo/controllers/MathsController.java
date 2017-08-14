package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Calculate;

@Controller 
@RequestMapping("/maths")

public class MathsController {

	@GetMapping("")
	public String adder() {
		return "maths/index";
	}
	
	
	@PostMapping("")
	public ModelAndView makeMathHappen (
		@RequestParam(name="left") int first, 
		@RequestParam(name="right") double second,
		@RequestParam(name="mathbuts", required = false) String mathbuts,
		@RequestParam(required = false, name= "value") String value, 
		Model model) {
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
	
	Double totalAfterMath = null; 
	 if (mathbuts.equals("+")) {
		 Calculate aVariableThatAdds = new Calculate(first, second);
		 totalAfterMath = aVariableThatAdds.addthings();
		
	
	 } else if (mathbuts.equals("-")) { 
	   Calculate aVariableThatSubtracts = new Calculate(first, second);
	   totalAfterMath = aVariableThatSubtracts.subtractthings();
		 
     } else if (mathbuts.equals("/")) { 
	   Calculate aVariableThatDivides = new Calculate(first, second);
	   totalAfterMath = aVariableThatDivides.dividethings();
		 
    } else if (mathbuts.equals("*")) { 
	   Calculate aVariableThatMultiplies = new Calculate(first, second);
	   totalAfterMath = aVariableThatMultiplies.multiplythings();
		 
    } else if (mathbuts.equals("%")) { 
 	   Calculate aVariableThatModulo = new Calculate(first, second);
 	  totalAfterMath = aVariableThatModulo.modulothings();
 	
    }
    
    else { 
	   Calculate aVariableThatExponate = new Calculate(first, second);
	   totalAfterMath = aVariableThatExponate.expothings();
	
    }
	 
ModelAndView mv = new ModelAndView("maths/sum-result"); 
mv.addObject("result", result);
return mv;
	
}
	
}

