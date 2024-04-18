package Taco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Screen
{

	public void Clear()
	{
//		for (int i = 0; i < 80; i++)
//		{
//			System.out.println("");
//		}
	}

	public void Draw()
	{
		System.out.println("??");
	}

	public void printAsciiArtFromFile(String filePath)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				System.out.println(line);
			}
		} 
		catch (IOException e)
		{
			System.err.println("Failed to read ASCII art file: " + e.getMessage());
		}
	}

	public void draw(String filePath)
	{
		Clear();
        //String filePath = "logo.txt"; // 실제 파일 경로로 변경해야 함
//        printAsciiArtFromFile(filePath);
	
		switch(filePath)
		{
		case "logo.txt":
			System.out.println("");
			break;
		}
		
	}
	
}
