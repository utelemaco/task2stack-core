package org.processhub.task2stack.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.processhub.task2stack.core.LevenshteinDistanceStrategy;
import org.processhub.task2stack.core.Suggestion;
import org.processhub.task2stack.core.domain.Task;

public class ImportCSV {
	
	public String string1 = null;
    public String string2 = null;
    public static LevenshteinDistanceStrategy comparador = new LevenshteinDistanceStrategy(); 
    
   
	public static void main(String[] args) {
		
		 String string1 = null;
         String string2 = null;
         List <Suggestion> SuggestionStack = mockStackOverflow(); 
         
         
        ArrayList<String> arr = new ArrayList<String>();
        
        
       
        // Lendo arquivo com a lista de strings contendo tarefas + contexto
        InputStream in = ImportCSV.class.getResourceAsStream("/tasks.csv"); 
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in)))
        {
            String sCurrentLine;   
          
            
            // Adicionando linhas ao array
            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }
           
            //Criando lista de tarefas
            List <Task> TaskList = new ArrayList<Task> ();
            
            // external loop 
            for (int i = 0; i<arr.size(); i++)
            {
            	Task task = new Task(); // criando obj task
            	task.setId(i);    
            	task.setTitulo(arr.get(i));
            	task.setSimilarTask(new ArrayList<Task>());
            	task.setSuggestionHistory(new ArrayList<Suggestion>());
            	
                System.out.println ("Criando nova Task" + task.getTitulo());  

            	
            	// internal loop
                for (int j = 0; j < TaskList.size(); j++)
                {
                	// each array will be given a different var
                	// these vars will be submitted to the similarity comparison
                    string1 = task.getTitulo();
                    string2 = TaskList.get(j).getTitulo();
                    
                	//System.out.println (i + string1 + " " + j +  string2);      
                    double nota = comparador.score (string1, string2);
                    
                    // if comparison index > then 70% and tasks are <>:
                    if (nota > 0.7 && i != j) 
                    {  
                    
                    // Record on Similars structure
                    System.out.println (i+string1 + " " +  j+string2 + " " + nota);  
                    task.getSimilarTask().add(TaskList.get(j));
                    
                    
                    }
                } 
                
                //Buscar sugestoes
                
                if (task.getSimilarTask().isEmpty()) {
                	
                	for (Suggestion suggestion : SuggestionStack) {
                		// Busca sugestao no Stack 
                        double nota = comparador.score (task.getTitulo(), suggestion.getTitulo());
                        
                  
                        if (nota > 0.5) 
                        {  
                        
                        System.out.println ("Sugestões do Stack: " + suggestion.getTitulo());
                        task.getSuggestionHistory().add(suggestion);
                        }
					}
                } else {
                	for (Task similar : task.getSimilarTask()) {
                		//System.out.println ("Sugestões das Similares: " + similar.getTitulo());
                		
                		for (Suggestion suggestion : similar.getSuggestionHistory()) {
                			
                			if (!task.getSuggestionHistory().contains(suggestion)) {
                                System.out.println ("Sugestões da Similar: " + suggestion.getTitulo());

                        		task.getSuggestionHistory().add(suggestion);

                			}
                    
    					}
                		
					}
                }
                
                TaskList.add(task);//adicionando objeto task a list
                System.out.println ("------------------------------------");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
     }


	private static List<Suggestion> mockStackOverflow() {
		
		List<Suggestion> mock = new ArrayList();
		Suggestion s;
		
		{
			s = new Suggestion();
			s.setId(1);
			s.setTitulo("Testar Caso de Uso: Emitir Diploma do Aluno Run test case java hibernate jenkins");
			mock.add(s);
			
		}
		
		{
			s = new Suggestion();
			s.setId(2);
			s.setTitulo("Implementar Caso de Uso: Emitir Diploma do Aluno Develop technical solution java hibernate jenkins");
			mock.add(s);
			
		}
		
		{
			s = new Suggestion();
			s.setId(2);
			s.setTitulo("Caso de Teste: Emitir Diploma do Aluno Develop technical solution java hibernate jenkins");
			mock.add(s);
			
		}
		
				return mock;
	}
}