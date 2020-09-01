package remoteTesting.dockerValidation;

import java.io.IOException;
import org.testng.annotations.Test;

public class startDockerUsingCommonMethodClass {

		@Test
		public void startFile() throws IOException, InterruptedException
		{
			commonMethods cm = new commonMethods();
			cm.setSearchText("registered to the hub and ready to use");
			cm.setbatchFileName("dockerup.bat");
			cm.setStopDocker(false);
			cm.runBatchFile();
			
			cm.setbatchFileName("scale.bat");
			cm.setStopDocker(true);
			cm.runBatchFile();
			
			Thread.sleep(15000);
		}
}
