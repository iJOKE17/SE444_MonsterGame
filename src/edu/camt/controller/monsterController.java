package edu.camt.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.camt.service.monsterService;
import edu.model.Monster;
import edu.model.Player;
import edu.model.Character;

@RestController
public class monsterController {
	
	
	monsterService ms = new monsterService();
	

	@RequestMapping("/monster")
	public ArrayList<Monster> getAllMonster(){
		return ms.getAllMonster();
	}
	
	@RequestMapping("/player")
	public ArrayList<Player> getAllPlayer(){
		return ms.getAllPlayer();
	}
	
	@RequestMapping("/character")
	public ArrayList<Character> getAllCharacter(){
		return ms.getAllCharacter();
	}
	
	
	@RequestMapping("/monster/{id}")
	public Monster getToonById(@PathVariable String id){
		return ms.getToonById(id);
	}
	
	@RequestMapping("/player/{id}")
	public Player getPlayerById(@PathVariable String id){
		return ms.getPlayerById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/createMonster")
	public boolean createNewMonster(@RequestBody Monster toon){
		boolean status = ms.createNewToon(toon);
		if(status == true){
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/createPlayer")
	public boolean createNewPlayer(@RequestBody Player player){
		boolean status = ms.createNewPlayer(player);
		if(status == true){
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update/{id}")
	public boolean updateToon(@PathVariable String id, @RequestBody Monster toon){
		boolean status = ms.updateToon(id,toon);
		if(status == true){
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatePlayer/{id}")
	public boolean updatePlayer(@PathVariable String id, @RequestBody Player player){
		boolean status = ms.updatePlayer(id,player);
		if(status == true){
			return true;
		}
		return false;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{id}")
	public boolean deleteToon(@PathVariable String id){
		boolean status = ms.deleteToon(id);
		if(status == true){
			return true;
		}
		return false;
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/player/{playerId}/battleMonster")
	private String battleMonster(@PathVariable String playerId,@RequestBody Monster monster) {
		Player player = ms.getPlayerById(playerId);
		Character whoWin = ms.battle(player, monster);
		return "Winner is "+whoWin.getName();

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/player/{playerId}/battleMonster/{monsterId}")
	private Character battleMonster(@PathVariable String playerId,@PathVariable String monsterId) {
		Player player = ms.getPlayerById(playerId);
		Monster monster = ms.getToonById(monsterId);
		Character whoWin = ms.battle(player, monster);
		return whoWin;

	}
	
	
	

}
