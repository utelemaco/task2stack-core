package org.processhub.task2stack.core;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.processhub.task2stack.core.domain.Task;
import org.processhub.task2stack.util.ImportCSV;

public class SimplestSimilarityStrategyTest {
	
	
	private List<Task> buildMockTasks(int size) {
		List<Task> tasks = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			Task task = new Task();
			task.setId(i);
			task.setTitulo("Task " + i);
			tasks.add(task);
		}
		
		return tasks;
	}

	@Test
	public void test01() {
		SimplestSimilarityStrategy similarityStrategy  = new SimplestSimilarityStrategy();
		List<Task> allTasks = buildMockTasks(100);
		
		Task task = new Task();
		task.setTitulo("A new task");
		
		List<Task> top10SimilarTasks = similarityStrategy.findTopSimilar(task, allTasks);
		
		Assert.assertNotNull(top10SimilarTasks);
		Assert.assertEquals(10, top10SimilarTasks.size());
		
		
		List<Task> top5SimilarTasks = similarityStrategy.findTopSimilar(task, allTasks, 5);
		
		Assert.assertNotNull(top5SimilarTasks);
		Assert.assertEquals(5, top5SimilarTasks.size());
		
	}
	
	
	@Test
	public void test02() {
		SimplestSimilarityStrategy similarityStrategy  = new SimplestSimilarityStrategy();
		ImportCSV importCSV = new ImportCSV();
		List<Task> tasksFromCSV = importCSV.extractFromCSV("/tasks.csv");
		
		Task task = new Task();
		task.setTitulo("A new task");
		
		List<Task> top10SimilarTasks = similarityStrategy.findTopSimilar(task, tasksFromCSV);
		
		Assert.assertNotNull(top10SimilarTasks);
		Assert.assertEquals(10, top10SimilarTasks.size());
		
		
		List<Task> top5SimilarTasks = similarityStrategy.findTopSimilar(task, tasksFromCSV, 5);
		
		Assert.assertNotNull(top5SimilarTasks);
		Assert.assertEquals(5, top5SimilarTasks.size());
		
	}

}
