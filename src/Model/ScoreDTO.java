package Model;

public class ScoreDTO 
{
	private int scoreID;
	private String scoreName;
	private int date;
	private int point;
	private int money;
	private int isPromoted;
	private int price;
	private int selltako;

	public ScoreDTO(int scoreID, String scoreName, int date, int point) 
	{
		this.scoreID = scoreID;
		this.scoreName = scoreName;
		this.date = date;
		this.point = point;
		
	}
	
	public ScoreDTO(int scoreID, String scoreName, int date, int point, int money) 
	{
		this.scoreID = scoreID;
		this.scoreName = scoreName;
		this.date = date;
		this.point = point;
		this.money = money;
	}
	
	public ScoreDTO(int scoreID, String scoreName, int date, int point, int money, int isPromoted, int price) 
	{
		this.scoreID = scoreID;
		this.scoreName = scoreName;
		this.date = date;
		this.point = point;
		this.money = money;
		this.isPromoted = isPromoted;
		this.price = price;
	}
	
	public ScoreDTO(int scoreID, String scoreName, int date, int point, int money, int isPromoted, int price, int selltako) 
	{
		this.scoreID = scoreID;
		this.scoreName = scoreName;
		this.date = date;
		this.point = point;
		this.money = money;
		this.isPromoted = isPromoted;
		this.price = price;
		this.selltako = selltako;
	}
	
	

	public int getscoreID() 
	{
		return scoreID;
	}

	public void setscoreID(int scoreID) 
	{
		this.scoreID = scoreID;
	}

	public String getscoreName() 
	{
		return scoreName;
	}

	public void setscoreName(String scoreName) 
	{
		this.scoreName = scoreName;
	}

	public int getdate() 
	{
		return date;
	}

	public void setdate(int date) 
	{
		this.date = date;
	}

	public int getpoint() 
	{
		return point;
	}

	public void setpoint(int point) 
	{
		this.point = point;
	}
	
	public int getmoney() 
	{
		return money;
	}

	public void setmoney(int money) 
	{
		this.money = money;
	}

	public int getisPromoted() 
	{
		return isPromoted;
	}

	public void setisPromoted(int isPromoted) 
	{
		this.isPromoted = isPromoted;
	}
	
	public int getprice() 
	{
		return price;
	}

	public void setprice(int price) 
	{
		this.price = price;
	}
	
	public int getselltako() 
	{
		return selltako;
	}

	public void setselltako(int selltako) 
	{
		this.selltako = selltako;
	}
}
