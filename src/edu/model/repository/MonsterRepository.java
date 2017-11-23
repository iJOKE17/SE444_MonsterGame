package edu.model.repository;



import java.util.List;


import org.springframework.stereotype.Service;

import edu.model.Monster;


public interface MonsterRepository{
	
	
public List<Monster> findAll();

}
