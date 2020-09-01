package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import junit.framework.Assert;

public class commonMethods {
	private String batchFile;
	private String SearchText;
	private boolean stopDocker;
	
	public void setbatchFileName(String batchFilename) {
		this.batchFile = batchFilename;
	}
	public String getBatchFilename() {
		return batchFile;
	}
	
	public void setSearchText(String textToSearchFor) {
		this.SearchText = textToSearchFor;
	}
	public String getSearchText() {
		return batchFile;
	}
	
	public boolean getStopDocker() {
		return stopDocker;
	}
	
	public void setStopDocker(boolean stopDockerTrue) {
		this.stopDocker = stopDockerTrue;
	}
	
	public void runBatchFile() throws IOException, InterruptedException
	{
		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start " + batchFile);
		
		if (stopDocker) 
		{
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
					if (currentLine.contains(SearchText))
					{
						System.out.println("Found line match - Docker server has now started/stopped");
						flag = true;
						break;
					}
					
					currentLine = reader.readLine();
				}
				reader.close();
			}
			
			Assert.assertTrue(flag);
			
			if (!flag)
			{
				System.out.println("Text Not Found");
			}
		}
	}

}
