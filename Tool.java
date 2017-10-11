import java.io.*;
import java.util.Scanner;

public class Tool{
	public static void main(String[] args) throws IOException{
		System.out.println("Enter file name: ");
		Scanner in = new Scanner(System.in);
		String filename = in.nextLine();
		Tool tool = new Tool(filename);
		System.out.println("Choose a thing to do: ");
		System.out.println("1: Remove \\r from newlines");
		System.out.println("2: Print file as ascii values");
		String thingToDo = in.nextLine();
		if (thingToDo.length() != 1 || thingToDo.charAt(0) < 49 || thingToDo.charAt(0) > 57){
			System.out.println("Not a valid option");
			System.exit(0);
		}
		int thing = Integer.parseInt(thingToDo);
		switch (thing){
			case 1:
				tool.removeCarriageReturn();
				break;
			case 2:
				tool.printAscii();
				break;
		}
		tool.writer.close();
	}
	
	FileReader reader;
	FileWriter writer;
	
	public Tool(String fileName) throws IOException, FileNotFoundException{
		reader = new FileReader(fileName);
		writer = new FileWriter("new" + fileName);
	}
	
	public void removeCarriageReturn() throws IOException{
		int lastRead = reader.read();
		while (lastRead > 0){
			if (lastRead == 13){
				lastRead = reader.read();
				if (lastRead == 10){
					writer.write(10);
				}
				else{
					writer.write(13);
					writer.write(lastRead);
				}
			}
			else{
				writer.write(lastRead);
			}
			lastRead = reader.read();
		}
	}
	
	public void printAscii() throws IOException{
	System.out.println("Printing Ascii values");
		int lastRead = reader.read();
		while (lastRead > 0){
			System.out.println(lastRead);
			lastRead = reader.read();
		}
	}
}
