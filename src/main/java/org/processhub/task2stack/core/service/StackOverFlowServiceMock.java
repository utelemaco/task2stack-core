package org.processhub.task2stack.core.service;

import java.util.ArrayList;
import java.util.List;

import org.processhub.task2stack.core.domain.Stack;

public class StackOverFlowServiceMock implements StackOverFlowServiceInterface {
	
	
	private static List<Stack> allStacks = new ArrayList<>();
	private static String[] part1 = new String[] {"Problem ", "Error ", "Suggestion ", "Tip ", "Bug "};
	private static String[] part1Prep = new String[] {"with ", "with ", "about ", "about ", "in "};
	private static String[] part2 = new String[] {"persistence ", "performance ", "security ", "presentation ", "compatibility "};
	private static String[] part2Prep = new String[] {"in ", "in ", "with ", "in ", "with "};
	private static String[] part3 = new String[] {"Java ", "PHP ", "Oracle ", ".NET ", "Javascript "};
	private static String[] part3Prep = new String[] {"in ", "in ", "in ", "in ", "in "};
	private static String[] part4 = new String[] {"Windows ", "Linux ", "MacOS "};
	private static String[] part4Prep = new String[] {"in ", "in ", "in "};
	private static String[] part5 = new String[] {"Production ", "Test ", "Development "};
	private static String[] part6 = new String[] {"(Urgent)", "(Help me)", ""};
	
	static {
		long counter = 0;
		for (int i1 = 0; i1 < part1.length; i1++) {
			for (int i2 = 0; i2 < part2.length; i2++) {
				for (int i3 = 0; i3 < part3.length; i3++) {
					for (int i4 = 0; i4 < part4.length; i4++) {
						for (int i5 = 0; i5 < part5.length; i5++) {
							for (int i6 = 0; i6 < part6.length; i6++) {
								Stack stack = new Stack();
								stack.setId(++counter);
								stack.setDescription(part1[i1] + part1Prep[i1] + part2[i2] + part2Prep[i2] + part3[i3] + part3Prep[i3] + part4[i4] + part4Prep[i4] + part5[i5] + part6[i6] );
								stack.addTag(part2[i2]);
								stack.addTag(part3[i3]);
								stack.addTag(part4[i4]);
								stack.addTag(part5[i5]);
								allStacks.add(stack);
								System.out.println(stack);
							}
						}
					}
				}
			}
		}
	}
	

	public List<Stack> findByDescription(String description){
		String[] keyWords = description.split(" ");
		List<Stack> stacksThatMatchDescription = new ArrayList<Stack>();
		for (Stack stack: allStacks) {
			if (containsAll(stack.getDescription(), keyWords)) {
				stacksThatMatchDescription.add(stack);
			}
		}

		return stacksThatMatchDescription;
	}
	
	private boolean containsAll(String description, String[] keyWords) {
		for (int i = 0; i < keyWords.length; i++) {
			if(!description.contains(keyWords[i])) {
				return false;
			}
		}		
		return true;
	}

}