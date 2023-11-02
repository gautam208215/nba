package com.api.nba.nba.api.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.api.nba.nba.api.test.model.Data;
import com.api.nba.nba.api.test.model.Meta;
import com.api.nba.nba.api.test.model.PlayerData;
import com.api.nba.nba.api.test.model.Team;

@RestController
public class PlayerApi {

	@Autowired
	DataRepo dataRepo;

	@GetMapping("/players")
	public List<PlayerData> getObjects() {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key", "ecf372b2damsh63429921602c19dp1e3c50jsnfc8972c33d3f");
		headers.set("X-RapidAPI-Host", "free-nba.p.rapidapi.com");
		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		String apiUrl = "https://free-nba.p.rapidapi.com/players";
		ResponseEntity<Data> exchange = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, Data.class);
		List<PlayerData> data = exchange.getBody().getData();
		for (int i = 0; i < data.size(); i++) {
			com.api.nba.nba.api.test.entity.PlayerData playerDatac = new com.api.nba.nba.api.test.entity.PlayerData();
			com.api.nba.nba.api.test.entity.Team teamc = new com.api.nba.nba.api.test.entity.Team();
			BeanUtils.copyProperties(data.get(i).getTeam(), teamc);
			BeanUtils.copyProperties(data.get(i), playerDatac);
			playerDatac.setTeam(teamc);
			System.out.println("data" + data.get(i).getTeam().getId());
			System.out.println("player " + playerDatac.getTeam());
			dataRepo.save(playerDatac);

		}
		return data;
	}

	@GetMapping("/players/new")
	public List<String> data() {
		RestTemplate restTemplate = new RestTemplate();
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("X-RapidAPI-Key", "ecf372b2damsh63429921602c19dp1e3c50jsnfc8972c33d3f");
//		headers.set("X-RapidAPI-Host", "free-nba.p.rapidapi.com");
//		HttpEntity<String> entity = new HttpEntity<>("body", headers);
		String apiUrl = "http://192.168.29.41:80";
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 5000; i++) {
			String exchange = restTemplate.getForObject(apiUrl, String.class);
			list.add(exchange);
		}
//		List<PlayerData> data = exchange.getBody().getData();
//		for (int i = 0; i < data.size(); i++) {
//			com.api.nba.nba.api.test.entity.PlayerData playerDatac = new com.api.nba.nba.api.test.entity.PlayerData();
//			com.api.nba.nba.api.test.entity.Team teamc = new com.api.nba.nba.api.test.entity.Team();
//			BeanUtils.copyProperties(data.get(i).getTeam(), teamc);
//			BeanUtils.copyProperties(data.get(i), playerDatac);
//			playerDatac.setTeam(teamc);
//			System.out.println("data" + data.get(i).getTeam().getId());
//			System.out.println("player " + playerDatac.getTeam());	
//			dataRepo.save(playerDatac);
//	
//		}
		return list;

	}

}
