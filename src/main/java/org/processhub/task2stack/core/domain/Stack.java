package org.processhub.task2stack.core.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stack {
	
	private Long id;
	private String description;
	private List<String> tags = new ArrayList();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}
		
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addTag(String tag){
		tags.add(tag);
	}

	public List<String> getTags() {
		return tags;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (String tag: tags) {
			sb.append(tag.trim() + ";");
		}
		return "Stack [id=" + id + ", description=" + description + ", tags=[" + sb.toString() + "]]";
	}


}