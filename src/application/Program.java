package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter file full path: ");
		String path = sc.next();
		Map<String, Integer> votesCounted = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(",");
				String name = fields[0];
				Integer votes = Integer.parseInt(fields[1]);
				
				if(votesCounted.containsKey(name)) {
					Integer currentVotes = votesCounted.get(name);
					Integer totalVotes = votes + currentVotes;
					votesCounted.put(name, totalVotes);
					
				} else {
					votesCounted.put(name, votes);
				}				
								
				line = br.readLine();
			}
			

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		
		System.out.println("");
		for(String key: votesCounted.keySet()) {
			System.out.println(key + ": " + votesCounted.get(key));
		}

	}

}
