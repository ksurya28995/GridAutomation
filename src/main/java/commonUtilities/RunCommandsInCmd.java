package commonUtilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class RunCommandsInCmd {

	private static commonUtilities commObj = new commonUtilities();

	public static void main(String args[]) throws InterruptedException {
		String strtHubServerCmd = "java -jar selenium-server-standalone-3.14.0.jar -role hub -hubConfig hubConfig.json";
		startHubServer(strtHubServerCmd);
		System.out.println("Selenium Hub Server Started...");
		commObj.threadsleep(10000);
		endHubServer();
		
	}

	// to run below methd -> runCmdMain("java -version");
	public static void runCmdMain(String cmdCommand) {
		try {
			String errorLogLine = null;
			String passedLogLine = null;
			String linesToLogFile = "###cmd Console###\r\n";
			Process proc = Runtime.getRuntime().exec(cmdCommand);
			BufferedReader brOutput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader brError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			for (; (errorLogLine = brError.readLine()) != null;) {
				linesToLogFile = linesToLogFile + "\r\n" + errorLogLine;
			}
			for (; (passedLogLine = brOutput.readLine()) != null;) {
				linesToLogFile = linesToLogFile + "\r\n" + passedLogLine;
			}
			brError.close();
			brOutput.close();

			File file = new File(commObj.getFilepath("cmdLogFile.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(linesToLogFile);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void startHubServer(String strtHubServerCmd) {
		try {
			String strtCmd = "cmd /c start cmd.exe ";
			String serverFilePath = "src/test/resources/Grid";
			String naviCmdToGridPath = "cd "+serverFilePath;
			String taskCommand = "/K \""+naviCmdToGridPath+" && "+ strtHubServerCmd+"\"";
			
			Runtime.getRuntime().exec(strtCmd+taskCommand);
			commObj.threadsleep(3000);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public static void endHubServer() {
		try {
			// to list down all the cmd tasks opened -> tasklist  /FI "imagename eq cmd.exe" /V
			// to kill all imageName{xxxx} executions -> taskkill /im XXXX.exe
			
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"taskkill  /im cmd.exe\"");
			System.out.println("Selenium Hub Server Ended");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
