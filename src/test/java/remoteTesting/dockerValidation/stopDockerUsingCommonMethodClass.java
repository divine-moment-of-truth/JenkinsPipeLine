package remoteTesting.dockerValidation;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class stopDockerUsingCommonMethodClass {

		@Test
		public void startFile() throws IOException, InterruptedException
		{
			commonMethods cm = new commonMethods();
			cm.setbatchFileName("dockerdown.bat");
			cm.setSearchText("Shutdown complete");
			cm.setStopDocker(true);
			cm.runBatchFile();
			
			File f = new File("output.txt");
			if(f.delete())
			{
				System.out.println("output.txt file deleted successfully!");
			}
		}
}
