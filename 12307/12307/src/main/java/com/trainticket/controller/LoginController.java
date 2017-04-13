package com.trainticket.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trainticket.service.StationService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("stationService")
	private StationService stationService;
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	@ResponseBody
	public Object login(){
		return "success";
	}
	
	@RequestMapping(value="/station/{name}",method=RequestMethod.GET,produces="text/html;charset=UTF-8")
	@ResponseBody
	public Object station(@PathVariable(value = "name")String name){
		List<String> al=stationService.getStation(name);
		JSONArray array = new JSONArray();
        for(int i=1;i<=al.size();i++){
        	array.add(al.get(i-1));
        }
		return array.toString();
	}


}
