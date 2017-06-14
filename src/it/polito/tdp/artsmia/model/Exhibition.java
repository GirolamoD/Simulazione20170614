package it.polito.tdp.artsmia.model;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

public class Exhibition {

	private int id ;
	private String department ;
	private String title ;
	private Year begin ;
	private Year end ;
	private Set<Integer> opere;
	
	public Exhibition(int id, String department, String title, Year begin, Year end) {
		super();
		this.id = id;
		this.department = department;
		this.title = title;
		this.begin = begin;
		this.end = end;
		this.opere = new HashSet<>() ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exhibition other = (Exhibition) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString(){
		return this.id + " " + this.title + "\n" ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Year getBegin() {
		return begin;
	}

	public void setBegin(Year begin) {
		this.begin = begin;
	}

	public Year getEnd() {
		return end;
	}

	public void setEnd(Year end) {
		this.end = end;
	}

	public Set<Integer> getOpere() {
		return opere;
	}
	
	
	

	
	
	
	

}
