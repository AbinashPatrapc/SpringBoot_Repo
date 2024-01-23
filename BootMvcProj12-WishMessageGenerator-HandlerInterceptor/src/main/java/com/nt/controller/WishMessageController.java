package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.service.IWishService;

@Controller
public class WishMessageController {
	@Autowired
	private IWishService service;

	/*
	 * @RequestMapping("/home") public String showHome() { return "welcome"; }
	 */

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}

	@GetMapping("/wish")
	public String fetchWishMessage(Map<String, Object> map) {
		String msg = service.WishMessageGenerator();
		map.put("wishMsg", msg);
		map.put("sysdate", new Date());
		return "forward:wish1";
	}

	@GetMapping("/wish1")
	public String fetchWishMessage1(Map<String, Object> map) {
		String msg = service.WishMessageGenerator();
		map.put("wishMsg", msg);
		map.put("sysdate", new Date());
		return "show_result";
	}

//	@RequestMapping("/wish")
//	public String fetchWishMessage(HttpServletResponse res) throws Exception {
//		String msg = service.WishMessageGenerator();
//		PrintWriter pw = res.getWriter();
//
//		pw.print("<b>Wish Message::" + msg + "</b><br>");
//		pw.print("<b>System Date::" + new Date() + "</b>");
//		return null;
//	}

	// =================OLD APPROACH===========================
	/*
	 * @RequestMapping("/wish") public ModelAndView showView() {
	 * 
	 * String msg=service.WishMessageGenerator();
	 * 
	 * ModelAndView mav=new ModelAndView(); mav.addObject("sysdate", new Date());
	 * mav.addObject("wishMsg", msg); mav.setViewName("show_result");
	 * 
	 * return mav; }
	 */

}
