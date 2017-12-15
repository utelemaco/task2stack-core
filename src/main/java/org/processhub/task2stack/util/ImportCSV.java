package org.processhub.task2stack.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.processhub.task2stack.core.LevenshteinDistanceStrategy;
import org.processhub.task2stack.core.domain.Task;

public class ImportCSV {
	
	public String string1 = null;
    public String string2 = null;
    public static LevenshteinDistanceStrategy comparador = new LevenshteinDistanceStrategy(); 
    
   
	public List<Task> extractFromCSV(String pathCSV) {
		
		List <Task> tasks = new ArrayList<Task> ();
		 
        InputStream in = ImportCSV.class.getResourceAsStream(pathCSV); 
        List<String> arr = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            String sCurrentLine;   
            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }
           
            for (int i = 0; i<arr.size(); i++) {
            	Task task = new Task(); // criando obj task
            	task.setId(i);    
            	task.setTitulo(arr.get(i));
            	tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } 
        return tasks;
     }

}