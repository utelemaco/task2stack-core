package org.processhub.task2stack.core;

import java.util.List;

public class Task {

	
	private int id;
	private String titulo;
	
	private List<Task> similarTask;
	private List<Suggestion> suggestionHistory;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Task> getSimilarTask() {
		return similarTask;
	}

	public void setSimilarTask(List<Task> similarTask) {
		this.similarTask = similarTask;
	}

	public List<Suggestion> getSuggestionHistory() {
		return suggestionHistory;
	}

	public void setSuggestionHistory(List<Suggestion> suggestionHistory) {
		this.suggestionHistory = suggestionHistory;
	}
	
	
	
	
}
