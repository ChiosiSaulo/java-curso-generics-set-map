package ex1.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import ex1.entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<LogEntry> set = new HashSet<>();
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader (path))){
			
			String line = br.readLine();
			
			while (line != null) {
				String[] fields = line.split(" ");
				String name = fields[0];
				Instant date = Instant.parse(fields[1]);
				set.add(new LogEntry(name, date));
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		sc.close();
	}

}
