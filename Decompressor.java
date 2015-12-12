import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.PrintWriter;

public class Decompressor
{
	private PrintWriter 	printWriter;
	private BufferedReader 	bufferedReader;
	private Data 			data;
	private String 			temp[];
	private String 			temporary;
	private String 			outputFilename;




	//constructor------------------------------------
	public Decompressor(String filename)throws IOException,FileNotFoundException
	{
		data = new Data();
		try
		{
			bufferedReader = new BufferedReader(new FileReader(new File(filename)));

			//read file name
			outputFilename = bufferedReader.readLine();
			printWriter = new PrintWriter(new File(outputFilename));
			
			//read object states
			while((temporary = bufferedReader.readLine()).equals("objectEndedInsideTheBar") == false)
			{
				data.setData(temporary);
			}
			System.out.println(data.getAllData());
			while((temporary = bufferedReader.readLine()) != null)
			{
				temp = temporary.split(" ");
				for(final String foreach : temp)
				{
					printWriter.print(data.getData(Integer.parseInt(foreach)));
				}
				printWriter.print("\r\n");
			}

		}catch(FileNotFoundException e)
		{
			System.err.println("file cannot be found");
			System.exit(1);

		}catch(IOException e)
		{
			System.err.println("io exception occured");
			System.exit(1);
		}finally
		{
			bufferedReader.close();
			printWriter.close();
		}
	}
}