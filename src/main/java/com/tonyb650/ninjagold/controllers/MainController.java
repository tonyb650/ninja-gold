package com.tonyb650.ninjagold.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@PostMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/process")
	public String process(
			@RequestParam(value="location") String location,
			HttpSession session
			) {
		if(session.getAttribute("gold")==null) {session.setAttribute("gold", 0);}
		if(session.getAttribute("activity")==null) {
			session.setAttribute("activity", new ArrayList<String>());
			}
		Random rand = new Random();
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyy h:mm a");
		String formattedDate = formatter.format(new Date());
		ArrayList<String> activity = (ArrayList<String>) session.getAttribute("activity");
		Integer gold = (Integer) session.getAttribute("gold");
		Integer change = 0;
		if(location.equals("farm")) {
			change = 10+rand.nextInt(11);
//			String changeStr = ""+change;
			activity.add(String.format("You entered a %s and earned %d gold. (%s)", location, change, formattedDate ));
		} else if (location.equals("cave")){
			change = 5+rand.nextInt(6);
			activity.add(String.format("You entered a %s and earned %d gold. (%s)", location, change, formattedDate ));
		} else if (location.equals("house")){
			change = 2+rand.nextInt(4);
			activity.add(String.format("You entered a %s and earned %d gold. (%s)", location, change, formattedDate ));
		}else if (location.equals("quest")){
			change = rand.nextInt(101)-50;
			if(change>0) {
				activity.add(String.format("You completed a quest and earned %d gold. %s", change, formattedDate ));
			} else {
				activity.add(String.format("You failed a quest and lost %d gold. Ouch! %s", -change, formattedDate ));
			}
		}
		gold += change;
		session.setAttribute("gold", gold);
		session.setAttribute("activity", activity);
		return "redirect:/";
	}
}
