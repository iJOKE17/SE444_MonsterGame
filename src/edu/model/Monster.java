package edu.model;

public class Monster extends Character{
	

	private String id;
	private String name;
	private int level;
	private int experience;
	private int health;
	private int agility;
	private int armor;
	private int damage;
	
	public Monster(){
		
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Monster(String id, String name, int level, int experience, int health, int agility, int armor, int damage) {
	this.id = id;
	this.name = name;
	this.level = level;
	this.experience = experience;
	this.health = health;
	this.agility = agility;
	this.armor = armor;
	this.damage = damage;
}

}
