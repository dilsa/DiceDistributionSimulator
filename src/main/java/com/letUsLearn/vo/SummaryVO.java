package com.letUsLearn.vo;

public class SummaryVO {
	int dices;
	int sides;
	int count;
	int sumofrolls;

	public SummaryVO() {
	}

	public SummaryVO(int dices, int sides, int count, int sumofrolls) {
		this.dices = dices;
		this.sides = sides;
		this.count = count;
		this.sumofrolls = sumofrolls;
	}

	public SummaryVO(Integer[] s) {
		this.dices = s[0];
		this.sides = s[1];
		this.count = s[2];
		this.sumofrolls = s[3];
	}

	public int getDices() {
		return dices;
	}

	public void setDices(int dices) {
		this.dices = dices;
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getSumofrolls() {
		return sumofrolls;
	}

	public void setSumofrolls(int sumofrolls) {
		this.sumofrolls = sumofrolls;
	}

}
