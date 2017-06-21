package org.processhub.task2stack.core;

import java.util.List;

public interface StackOverFlowServiceInterface {
	

	public List<StackOverFlowItem> findByDescription(String description); 

}