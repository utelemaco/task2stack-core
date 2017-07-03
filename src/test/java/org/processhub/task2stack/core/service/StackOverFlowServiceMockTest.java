package org.processhub.task2stack.core.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.processhub.task2stack.core.domain.Stack;

public class StackOverFlowServiceMockTest {

	@Test
	public void test() {
		StackOverFlowServiceMock service = new StackOverFlowServiceMock();
		List<Stack> stacksAboutJavaFound = service.findByDescription("Java");
		Assert.assertEquals(1350, stacksAboutJavaFound.size());
		
		List<Stack> stacksAboutBugJavaFound = service.findByDescription("Bug Java");
		Assert.assertEquals(270, stacksAboutBugJavaFound.size());
		
		List<Stack> stacksAboutBugJavaLinuxFound = service.findByDescription("Bug Java Linux");
		Assert.assertEquals(90, stacksAboutBugJavaLinuxFound.size());
	}

}
