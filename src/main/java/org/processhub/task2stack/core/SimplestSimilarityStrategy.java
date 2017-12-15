package org.processhub.task2stack.core;

import java.util.List;

import org.processhub.task2stack.core.domain.Task;

public class SimplestSimilarityStrategy implements SimilarityStrategy {

	@Override
	public double score(String first, String second) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Task> findTopSimilar(Task newTask, List<Task> tasks) {
		// Default value is 10. The top 10 most similiar
		return findTopSimilar(newTask, tasks, 10);
	}

	@Override
	public List<Task> findTopSimilar(Task newTask, List<Task> tasks, int size) {
		if (tasks.size() <= size) {
			return tasks;
		}
		
		return tasks.subList(0, size);
	}	

}
