package Model;

public class UserDTO
{
	private int ID;
	private int PW;
	private String Name;

	public UserDTO(int  ID, int PW, String Name)
	{
		this.ID = ID;
		this.PW = PW;
		this.Name = Name;
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
	
}
