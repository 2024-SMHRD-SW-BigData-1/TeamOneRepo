package Model;

public class UserDTO
{
	private int ID;
	private int PW;
	private String Name;
	private int scoreID;

	public UserDTO(int  ID, int PW, String Name)
	{
		this.ID = ID;
		this.PW = PW;
		this.Name = Name;
		this.scoreID = 0;
	}
	
	public UserDTO(int  ID, int PW, String Name, int scoreID)
	{
		this.ID = ID;
		this.PW = PW;
		this.Name = Name;
		this.scoreID = scoreID;
	}
	
	public UserDTO(int  ID, int PW)
	{
		this.ID = ID;
		this.PW = PW;
	}

	
	public int getID()
	{
		return ID;
	}
	
	public void setID(int ID)
	{
		this.ID = ID;
	}
	
	public int getPW()
	{
		return PW;
	}
	
	public void setPW(int PW)
	{
		this.PW = PW;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public void setPW(String Name)
	{
		this.Name = Name;
	}
	
	public int getscoreID()
	{
		return scoreID;
	}
	
	public void setscoreID(int scoreID)
	{
		this.scoreID = scoreID;
	}
	
	
}
