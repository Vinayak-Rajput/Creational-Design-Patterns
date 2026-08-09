package com.example.creation.Prototype;

public class Goblin implements Enemy{
    private int health;
    private int speed;
    private String weapon;

    public Goblin(int health, int speed, String weapon) {
        this.health = health;
        this.speed = speed;
        this.weapon = weapon;
    }

    public Goblin(Goblin target){
        if(target != null){
            this.health = target.health;
            this.speed = target.speed;
            this.weapon = new String(target.weapon);
        }
    }

    @Override
    public Goblin clone() {
        return new Goblin(this);
    }
}
