package commonUtilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Map;
/**
 * Class is used to run the open and run the cmd commands to sart the hub and nodes
 * 
 * @author SuryaRay
 */
public class RunCommandsInCmd {

	private static final int Map = 0;
	private static final int String = 0;
	private static commonUtilities commObj = new commonUtilities();

	public static void main(String args[]) throws InterruptedException {
		/*String strtHubServerCmd = "java -jar selenium-server-standalone-3.14.0.jar -role hub -hubConfig hubConfig.json";
		String strtNodeServerCmd = "java -jar selenium-server-standalone-3.14.0.jar -role node -nodeConfig nodeConfig.json";
		int node1 = 1;
		startHubServer(strtHubServerCmd);
		commObj.threadsleep(5000);
		startNodeServer(strtNodeServerCmd, node1);
		commObj.threadsleep(5000);
		endHubServer();
		runCmdMain("ipconfig");*/
	}

	// to run this methd -> runCmdMain("java -version");
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

	/**
	 * Method is used to start the node
	 * 
	 * @param strtNodeServerCmd node starting cmd, node number on which the node starts
	 * 
	 * @author SuryaRay
	 */
	public static void startNodeServer(String strtNodeServerCmd, int nodeNo) {
		try {
			String[] nodePorts = { "not in use", "38081", "38082", "38083", "38054", "38085" };
			JsonFileHandler.setJsonData("port", nodePorts[nodeNo]);
			String strtCmd = "cmd /c start cmd.exe ";
			String serverFilePath = "src/test/resources/Grid";
			String naviCmdToGridPath = "cd " + serverFilePath;
			String taskCommand = "/K \"" + naviCmdToGridPath + " && " + strtNodeServerCmd + "\"";

			Runtime.getRuntime().exec(strtCmd + taskCommand);
			commObj.threadsleep(3000);
			System.out.println("Selenium Node Server Started...");

			String gridConfigCSV = "gridConfigs.csv";
			Map<String, String> arrData = commObj.readCsvData(gridConfigCSV);
			String hubURL = arrData.get("URL Node " + nodeNo);
			hubURL = hubURL.split(":")[0] + ":" + hubURL.split(":")[1] + ":" + nodePorts[nodeNo] + "/wd/hub";
			commObj.setCsvData(gridConfigCSV, "URL Node " + nodeNo, hubURL);

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Method is used to start the hub
	 * 
	 * @param strtHubServerCmd hub starting cmd
	 * 
	 * @author SuryaRay
	 */
	public static void startHubServer(String strtHubServerCmd) {
		try {
			String strtCmd = "cmd /c start cmd.exe ";
			String serverFilePath = "src/test/resources/Grid";
			String naviCmdToGridPath = "cd " + serverFilePath;
			String taskCommand = "/K \"" + naviCmdToGridPath + " && " + strtHubServerCmd + "\"";

			Runtime.getRuntime().exec(strtCmd + taskCommand);
			commObj.threadsleep(3000);
			System.out.println("Selenium Hub Server Started...");

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	public static void endHubServer() {
		try {
			// to list down all the cmd tasks opened -> tasklist /FI "imagename eq cmd.exe"
			// /V
			// to kill all imageName{xxxx} executions -> taskkill /im XXXX.exe

			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"taskkill  /im cmd.exe\"");
			System.out.println("Selenium Servers Ended");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
