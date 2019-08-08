package com.usama.location1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usama.location1.entity.Location;
import com.usama.location1.service.LocationService;
@Controller
public class LocationController {
	@Autowired
	LocationService service;
	
	@RequestMapping("/showCreate")
	public String showCreate()
	{
		return "createLocation";
	}
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap)
	{
		Location locationSaved = service.saveLocation(location);
		String msg = "Location Saved with id: "+ locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createLocation";
	}


}
