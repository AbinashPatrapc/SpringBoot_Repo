package com.nt.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;
@Service
public class WishServiceImpl implements IWishService{

	@Override
	public  String WishMessageGenerator() {
		LocalTime lt=LocalTime.now();
		int hour=lt.getHour();
		System.out.println(hour);
		if(hour<12) {
			return "Good Moring";
		}else if(hour>12&&hour<18) {
			return "Good Afternoon";
		}else
		return "Good Night";
	}
}
