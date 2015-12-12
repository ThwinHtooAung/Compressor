import java.util.Scanner;

import java.io.IOException;
import java.io.FileNotFoundException;

public class Main
{
	private Compressor 		compressor = null;
	private Decompressor 	decompressor = null;

	public void compress(String filename)throws IOException, FileNotFoundException
	{
		compressor = new Compressor(filename);
		compressor = null;
		System.gc();
	}
	public void retrieve(String filename)throws IOException, FileNotFoundException
	{
		decompressor = new Decompressor(filename);
		decompressor = null;
		System.gc();
	}

	public static void main(String[]argc)throws IOException,FileNotFoundException
	{
		Main fileController = new Main();
		Scanner input = new Scanner(System.in);
		System.out.println("Options__________");
		System.out.println("compress");
		System.out.println("retrieve");
		System.out.print("enter here : ");
		//change option here
		String userInput = argc[0];

		if(userInput.toLowerCase().equals("compress"))
		{
			System.out.print("please enter the file name :");
			userInput = argc[1];
			fileController.compress(userInput);
		}else
		{
			System.out.print("please enter the file name:");
			userInput = argc[1];
			fileController.retrieve(userInput);
		}

	}
}