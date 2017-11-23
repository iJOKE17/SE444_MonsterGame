package edu.camt.service;

import java.util.ArrayList;
import edu.model.Monster;
import edu.model.Player;

import edu.model.Character;



public class monsterService {
	
	
//	@Autowired
//	MonsterRepository monsterRepo;
	
	ArrayList<Monster> listOfMonster = new ArrayList<Monster>();
	ArrayList<Player>  listOfPlayer = new ArrayList<Player>();
	ArrayList<Character> listOfCharacter = new ArrayList<Character>();

	public monsterService(){
		Monster a = new Monster("1","Dragon",10,100,100,25,25,25);
		Monster c = new Monster("2","Root",15,190,800,29,250,255);
		Monster d = new Monster("3","Minion",1,1,1,1,1,1);
		Monster e = new Monster("4","Bob",99,25,40,58,50,10);
		Monster f = new Monster("5","Razer",10,100,50,20,20,20);
		Monster g = new Monster("6","Mizuho",1,10,100,20,20,20);
		
		//monsterRepo.save(a);

		Player b = new Player("0","Joker",1,10,100,20,20,20);
		listOfMonster.add(a);
		listOfMonster.add(c);
		listOfMonster.add(d);
		listOfMonster.add(e);
		listOfMonster.add(f);
		listOfMonster.add(g);
		listOfPlayer.add(b);
		listOfCharacter.add(a);
		listOfCharacter.add(b);
	}
	
	public ArrayList<Monster>  getAllMonster(){
		return listOfMonster;
	}
	
	public ArrayList<Player>  getAllPlayer(){
		return listOfPlayer;
	}
	
	public ArrayList<Character>  getAllCharacter(){
		return listOfCharacter;
	}
	
	public Monster getToonById(String id){
		Monster returnToon = null;
		for (Monster toon : listOfMonster) {
			if(toon.getId().equals(id)){
				returnToon = toon;
				break;
			}
		}
		return returnToon;	
	}
	
	public Player getPlayerById(String id){
		Player returnPlayer = null;
		for (Player player : listOfPlayer) {
			if(player.getId().equals(id)){
				returnPlayer = player;
				break;
			}
		}
		return returnPlayer;	
	}
	
	public boolean createNewToon(Monster toon){
		Monster newToon = new Monster();
		newToon.setExperience(toon.getExperience());
		newToon.setHealth(toon.getHealth());
		newToon.setLevel(toon.getLevel());
		newToon.setName(toon.getName());
		newToon.setId(toon.getId());
		newToon.setAgility(toon.getAgility());
		newToon.setArmor(toon.getArmor());
		newToon.setDamage(toon.getDamage());
		
		listOfMonster.add(newToon);
		return true;
	}
	
	public boolean createNewPlayer(Player player){
		Player newPlayer = new Player();
		newPlayer.setExperience(player.getExperience());
		newPlayer.setHealth(player.getHealth());
		newPlayer.setLevel(player.getLevel());
		newPlayer.setName(player.getName());
		newPlayer.setId(player.getId());
		newPlayer.setAgility(player.getAgility());
		newPlayer.setArmor(player.getArmor());
		newPlayer.setDamage(player.getDamage());
		listOfPlayer.add(newPlayer);
		return true;
	}
	
	
	public boolean updateToon(String id,Monster toon){
		Monster updateToon = getToonById(id);
		updateToon.setExperience(toon.getExperience());
		updateToon.setHealth(toon.getHealth());
		updateToon.setLevel(toon.getLevel());
		updateToon.setName(toon.getName());
		updateToon.setAgility(toon.getAgility());
		updateToon.setArmor(toon.getArmor());
		updateToon.setDamage(toon.getDamage());
		
		return true;		
	}
	
	public boolean updatePlayer(String id,Player player){
		Player updatePlayer = getPlayerById(id);
		updatePlayer.setExperience(player.getExperience());
		updatePlayer.setHealth(player.getHealth());
		updatePlayer.setLevel(player.getLevel());
		updatePlayer.setName(player.getName());
		updatePlayer.setAgility(player.getAgility());
		updatePlayer.setArmor(player.getArmor());
		updatePlayer.setDamage(player.getDamage());
		
		return true;		
	}
	
	public boolean deleteToon(String id){
		Monster deleteToon = getToonById(id);
		listOfMonster.remove(deleteToon);
		return true;		
	}
	
	public boolean deletePlayer(String id){
		Player deletePlayer = getPlayerById(id);
		listOfPlayer.remove(deletePlayer);
		return true;		
	}

//	public Monster battle(Monster toon1, Monster toon2) {
//		Monster win = null;
//		if(toon1.getAgility()>=toon2.getAgility()){
//			win = attack(toon1, toon2);
//			
//		}else{
//			win = attack(toon2, toon1);
//		}
//		return win;
//	}
//	
//	public Monster attack(Monster toon1,Monster toon2){
//		int flag = 1;
//		Monster win = null;
//		int toon1Health = toon1.getArmor()+toon1.getHealth();
//		int toon2Health = toon2.getArmor()+toon2.getHealth();
//		int toon1Damage = toon1.getDamage();
//		int toon2Damage = toon2.getDamage();
//		{
//			toon2Health -= toon1Damage;
//			toon1Health -= toon2Damage;
//			if(toon1Health==0){
//				flag=0;
//				return win=toon2;
//			}else if(toon2Health==0){
//				flag=0;
//				return win=toon1;
//			}
//		}while(flag!=0);
//		return win;
//		
//	}

	
	public Character battle(Player player, Monster monster) {
		Character whoWin = null;
		if(player.getAgility()>=monster.getAgility()){
			whoWin = attack(player, monster);
		}else{
			whoWin = attack(monster, player);
		}
		return whoWin;
	}
	
	public Character attack(Character toon1,Character toon2){
		int flag = 1;
		Character win = null;
		int toon1Health = toon1.getArmor()+toon1.getHealth();
		int toon2Health = toon2.getArmor()+toon2.getHealth();
		int toon1Damage = toon1.getDamage();
		int toon2Damage = toon2.getDamage();
		do{
			toon2Health -= toon1Damage;
			toon1Health -= toon2Damage;
			if(toon1Health<=0){
				win=toon2;
				flag=0;
			}else if(toon2Health<=0){
				win=toon1;
				flag=0;
			}
		}while(flag!=0);
		return win;
		
	}
	

}
