package org.processhub.task2stack.core;

import java.util.ArrayList;
import java.util.List;

public class StackOverFlowServiceMock implements StackOverFlowServiceInterface {
	

	public List<StackOverFlowItem> findByDescription(String description){
		List<StackOverFlowItem> list = new ArrayList<StackOverFlowItem>();

		return list;
	} 

}