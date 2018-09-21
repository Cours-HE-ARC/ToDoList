package ch.hearc.servlet.model;

import java.util.Date;

public class Tache {

	private String description;
	private String dueDate;
	
	public Tache(String description, String dueDate) {
		super();
		this.description = description;
		this.dueDate = dueDate;
	}

	public String getDescription() {
		return description;
	}

	public String getDueDate() {
		return dueDate;
	}

	@Override
	public String toString() {
		return "Tache [description=" + description + ", dueDate=" + dueDate + "]";
	}
	
}
