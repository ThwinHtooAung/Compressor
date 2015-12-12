import java.util.ArrayList;

public class Data
{
	private ArrayList<String> tokens;

	// private boolean 			isCaptured(String token);
	// private int 				length();

	// public void 				setData(String token);
	// public String 				getData(int index);
	// public ArrayList<String> 	getAllData();


	//methods------------
	private int isCaptured(String token)
	{
		int value = -1;
		for(int i = 0 ; i < this.tokens.size(); i++)
		{
			if(getData(i).hashCode() == token.hashCode())
			{
				value = i;
			}
		}
		return value;
	}
	public int getLength()
	{
		return this.tokens.size();
	}
	public void setData(String token)
	{
			if((isCaptured(token) == -1))
			{
				this.tokens.add(token);
			}
	}
	public String getData(int index)
	{
		return this.tokens.get(index);
	}
	public ArrayList<String> getAllData()
	{
		return this.tokens;
	}
	public int getToken(String token)
	{
		for(int i = 0 ; i < this.tokens.size(); i++)
		{
			if(token.hashCode() == this.getData(i).hashCode())
			{
				return i;
			}
		}
		return -1;
	}


	//constructor-------------
	public Data()
	{
		tokens = new ArrayList<String>();
	}
}