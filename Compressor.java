import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Compressor
{
	private BufferedReader 	bufferedReader;
	private PrintWriter 	printWriter;
	private Data 			data;
	private String 			tokens[];
	private String 			inputTokens[];
	private String 			dataStream = "";



	//constructor-------------------------------------------------------------
	public Compressor(String filename)throws FileNotFoundException,IOException
	{
		data = new Data();
		try
		{
			bufferedReader = new BufferedReader(new FileReader(new File(filename)));
			while((dataStream = (String)bufferedReader.readLine()) != null)
			{
				
				
				if(dataStream.length() == 0)
				{
					
					
					data.setData("\\r\\n");
					
				}else
				{
					inputTokens = dataStream.split(" ");
					for(int i = 0 ; i < inputTokens.length; i++)
					{
						data.setData(inputTokens[i]);
						
					}
				}
				
			}
			tokens = filename.split(".txt");
			tokens[0] += ".compressed";
			printWriter = new PrintWriter(new File(tokens[0]));
			printWriter.println(filename);
			for(int i = 0 ; i < data.getLength(); i++)
			{
				printWriter.println(data.getData(i) + " ");
				System.out.println(data.getData(i).hashCode());
			}
			printWriter.println("objectEndedInsideTheBar");
			
			

			bufferedReader.close();
			bufferedReader = new BufferedReader(new FileReader(new File(filename)));
			while((dataStream = (String)bufferedReader.readLine()) != null)
			{
				if(dataStream.length() == 0)
				{
					printWriter.println(data.getToken("\\r\\n"));
				}else
				{
					inputTokens = dataStream.split(" ");
					for(int i = 0 ; i < inputTokens.length; i++)
					{
						printWriter.print(data.getToken(inputTokens[i]) + " ");
						//System.out.println(data.isCaptured(inputTokens[i]));
					}
					printWriter.println();
				}
			}

		}catch(FileNotFoundException e)
		{
			System.err.println("File cannot be found");
			e.printStackTrace();

		}catch(IOException e)
		{
			System.err.println("Unknown exception occours");
			e.printStackTrace();

		}finally
		{
			if(bufferedReader != null)
			{
				bufferedReader.close();
				printWriter.flush();
				printWriter.close();
			}
		}
	}
	
}