package com.letUsLearn.vo;

import java.util.HashMap;

public class DDSVo {
	long id;
	int rolls;
	int sides;
	int dices;
	HashMap<Integer, Integer> rollDetails = new HashMap<Integer, Integer>();

	public DDSVo() {
	}

	public DDSVo(long id, int rolls, int sides, int dices, HashMap<Integer, Integer> map) {
		this.id = id;
		this.rolls = rolls;
		this.sides = sides;
		this.dices = dices;
		this.rollDetails = map;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRolls() {
		return rolls;
	}

	public void setRolls(int rolls) {
		this.rolls = rolls;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public int getDices() {
		return dices;
	}

	public void setDices(int dices) {
		this.dices = dices;
	}

	public HashMap<Integer, Integer> getRollDetails() {
		return rollDetails;
	}

	public void setRollDetails(HashMap<Integer, Integer> rollDetails) {
		this.rollDetails = rollDetails;
	}

}
