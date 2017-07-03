package org.processhub.task2stack.core.service;

import java.util.List;

import org.processhub.task2stack.core.domain.Stack;

public interface StackOverFlowServiceInterface {
	

	public List<Stack> findByDescription(String description); 

}