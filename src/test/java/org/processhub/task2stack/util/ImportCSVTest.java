package org.processhub.task2stack.util;

import java.util.List;

import org.junit.Test;
import org.processhub.task2stack.core.domain.Task;

import junit.framework.Assert;

public class ImportCSVTest {

	@Test
	public void test() {
		ImportCSV importer = new ImportCSV();
		
		List<Task> tasks = importer.extractFromCSV("/tasks.csv");
		
		Assert.assertNotNull(tasks);
		Assert.assertEquals(71, tasks.size());
		
		Assert.assertEquals("Entrega da Segunda Iteracao Deploy final release java hibernate jenkins ", tasks.get(0).getTitulo());
		
	}

}
