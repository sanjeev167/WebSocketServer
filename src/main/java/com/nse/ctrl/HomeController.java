package com.nse.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sanjeevkumar
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String index() {
		return "client";
	}
}
