package com.letUsLearn.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "dds")
public class DDS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	@Column(name = "rolls")
	int rolls;
	@Column(name = "sides")
	int sides;
	@Column(name = "dices")
	int dices;

	@OneToMany(mappedBy = "dds", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<DDSdetail> ddsdetail;

	public DDS() {
	}

	public DDS(int rolls, int sides, int dices) {
		this.rolls = rolls;
		this.sides = sides;
		this.dices = dices;
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

	public Set<DDSdetail> getDdsdetail() {
		return ddsdetail;
	}

	public void setDdsdetail(Set<DDSdetail> ddsdetail) {
		this.ddsdetail = ddsdetail;
	}
}