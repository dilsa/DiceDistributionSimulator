package com.letUsLearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ddsdetails")
public class DDSdetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	long id;
	@Column(name = "rolledvalue")
	int rolledvalue;
	@Column(name = "times")
	int times;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "dds_id", nullable = false)
	private DDS dds;

	public DDSdetail() {
	}

	public DDSdetail(int rolledvalue, int times, DDS dds) {
		this.rolledvalue = rolledvalue;
		this.times = times;
		this.dds = dds;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRolledvalue() {
		return rolledvalue;
	}

	public void setRolledvalue(int rolledvalue) {
		this.rolledvalue = rolledvalue;
	}

	public int getTimes() {
		return times;
	}

	public void setTimes(int times) {
		this.times = times;
	}

	public DDS getDds() {
		return dds;
	}

	public void setDds(DDS dds) {
		this.dds = dds;
	}
}