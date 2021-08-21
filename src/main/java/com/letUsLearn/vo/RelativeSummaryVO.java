package com.letUsLearn.vo;

public class RelativeSummaryVO {
	int dices;
	int sides;
	int rollValue;
	int sumofrolls;
	int totalroll;
	String relativePercentage;

	public RelativeSummaryVO() {
	}

	public RelativeSummaryVO(Integer[] s) {
		this.dices = s[0];
		this.sides = s[1];
		this.rollValue = s[2];
		this.sumofrolls = s[3];
		this.totalroll = s[4];
		this.relativePercentage = ((float) s[3] / s[4] * 100) + "%";
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

	public int getRollValue() {
		return rollValue;
	}

	public void setRollValue(int rollValue) {
		this.rollValue = rollValue;
	}

	public int getSumofrolls() {
		return sumofrolls;
	}

	public void setSumofrolls(int sumofrolls) {
		this.sumofrolls = sumofrolls;
	}

	public int getTotalroll() {
		return totalroll;
	}

	public void setTotalroll(int totalroll) {
		this.totalroll = totalroll;
	}

	public String getRelativePercentage() {
		return relativePercentage;
	}

	public void setRelativePercentage(String relativePercentage) {
		this.relativePercentage = relativePercentage;
	}

}
