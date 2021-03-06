package com.ait.interview.controllers;

import com.ait.interview.domain.Location;
import com.ait.interview.domain.UserLocation;
import com.ait.interview.services.ChatService;
import com.ait.interview.services.LocationService;
import com.ait.interview.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/location")
public class LocationController {

	@Autowired
	LocationService locationService;

	@Autowired
	UserService userService;


	@GetMapping("/")
	public String index(Model model) {
		List<Location> areas = this.locationService.getListArea();
		model.addAttribute("areas", areas);
		return "location/all";
	}

	@GetMapping("/ajax")
	@ResponseBody
	public List<Location> ajax(@RequestParam(name = "area") int area) {
		if (area == 0) {
			return this.locationService.getListAllIgnoreRootArea();
		} else {
			return this.locationService.getAllLocationByArea(area);
		}

	}

	@GetMapping("/detail")
	public String detail(Model model, @RequestParam(name = "id") Long id) {
		Location location = this.locationService.getById(id);
		Location parent = (location != null) ? this.locationService.getById(location.getId()) : null;
		List<UserLocation> users = (location != null) ? this.userService.getUsersInLocation(location.getId()) : null;
		model.addAttribute("location", location);
		model.addAttribute("parent", parent);
		model.addAttribute("users", users);
		return "location/detail";
	}
}
