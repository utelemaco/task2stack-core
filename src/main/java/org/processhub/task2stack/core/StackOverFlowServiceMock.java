package org.processhub.task2stack.core;

import java.util.ArrayList;
import java.util.List;

import org.processhub.task2stack.core.domain.Stack;

public class StackOverFlowServiceMock implements StackOverFlowServiceInterface {
	

	public List<Stack> findByDescription(String description){
		List<Stack> list = new ArrayList<Stack>();

		return list;
	} 

}