package com.boardgamebrag.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping
public class WebController {
	
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/")
    public ModelAndView main() {
        return main("home");
    }
	
	@RequestMapping(value="/{pageName}")
	public ModelAndView main(@PathVariable String pageName) {
	    ModelAndView mv = new ModelAndView("views/home");
	    mv.addObject("pageName", pageName);
		return mv;
	}
	
	@RequestMapping(value="/{pageName}/**")
    public ModelAndView subPage(@PathVariable String pageName) {
        return main(pageName);
    }
}
