package Model;

public class ScoreDTO 
{
	private int scoreID;
	private String scoreName;
	private int date;
	private int point;

	public ScoreDTO(int scoreID, String scoreName, int date, int point) 
	{
		this.scoreID = scoreID;
		this.scoreName = scoreName;
		this.date = date;
		this.point = point;
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

	public void setspoint(int point) 
	{
		this.point = point;
	}

}
