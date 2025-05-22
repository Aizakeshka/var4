package com.example.var4;

public class Character {
    private String name;
    private String gender;
    private String race;
    private String characterClass;
    private int strength;
    private int agility;
    private int intelligence;
    private int endurance;
    private int charisma;
    private int luck;
    private int level;

    public Character(String name, String gender, String race, String characterClass,
                     int strength, int agility, int intelligence, int endurance,
                     int charisma, int luck, int level) {
        this.name = name;
        this.gender = gender;
        this.race = race;
        this.characterClass = characterClass;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.endurance = endurance;
        this.charisma = charisma;
        this.luck = luck;
        this.level = level;
    }

    public String getName() { return name; }
    public String getGender() { return gender; }
    public String getRace() { return race; }
    public String getCharacterClass() { return characterClass; }
    public int getStrength() { return strength; }
    public int getAgility() { return agility; }
    public int getIntelligence() { return intelligence; }
    public int getEndurance() { return endurance; }
    public int getCharisma() { return charisma; }
    public int getLuck() { return luck; }
    public int getLevel() { return level; }
}