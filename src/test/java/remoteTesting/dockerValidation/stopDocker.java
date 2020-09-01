package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

//import org.testng.Assert;

public class stopDocker {

		public void stopFile() throws IOException, InterruptedException
		{
			boolean flag = false;
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("cmd /c start dockerdown.bat");
			
			String file = "output.txt";

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, 30);
			long stopNow = cal.getTimeInMillis();
			Thread.sleep(3000);
			
			while(System.currentTimeMillis() < stopNow)
			{
				if(flag)
				{
					break;
				}
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String currentLine = reader.readLine();
				
				while(currentLine != null && !flag )
				{
					if (currentLine.contains("selenium-hub exited"))
					{
						System.out.println("Found line match - Docker server has now started");
						flag = true;
						break;
					}
					
					currentLine = reader.readLine();
				}
				reader.close();
			}
			
			// Assert.assertTrue(flag);	// test will fail if the flag is false at the end of looking through the entire 'output.txt' file

		}
}
