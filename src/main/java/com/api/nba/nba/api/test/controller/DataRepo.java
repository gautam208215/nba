package com.api.nba.nba.api.test.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.nba.nba.api.test.entity.PlayerData;
import com.api.nba.nba.api.test.entity.Team;

public interface DataRepo extends JpaRepository<PlayerData, Long> {


	void save(Team team);


}
