import java.io.*;
import java.util.Scanner;

public class Tool{
	public static void main(String[] args) throws IOException{
		Tool tool = new Tool("test.txt");
		tool.removeCarriageReturn();
		tool.writer.close();
	}
	
	FileReader reader;
	Scanner scanner;
	FileWriter writer;
	
	public Tool(String fileName) throws IOException, FileNotFoundException{
		reader = new FileReader(fileName);
		scanner = new Scanner(reader);
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
		int lastRead = reader.read();
		while (lastRead > 0){
			System.out.println(lastRead);
			lastRead = reader.read();
		}
	}
}
