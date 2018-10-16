package commonUtilities;

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import flexjson.JSONSerializer;
/**
 * Class is used to read the json file
 * 
 * @author SuryaRay
 */
public class JsonFileHandler {

	public static void main(String arg[]) {
		setJsonData("port","38080");
	}

	/**
	 * Method is used to update the json file with the new value
	 * 
	 * @param head key to which the value needed to be changed
	 * 
	 * @param value to be changed
	 * 
	 * @author SuryaRay
	 */
	public static void setJsonData(String head, String value) {
		JSONParser jsonparse = new JSONParser();
		JSONObject jsonObj = new JSONObject();
		JSONSerializer json = new JSONSerializer();
		
		try {
			String jsonFilePath = "src/test/resources/Grid";
			String jsonNodeFile = jsonFilePath + "/nodeConfig.json";
			jsonObj = (JSONObject) jsonparse.parse(new FileReader(jsonNodeFile));
			jsonObj.put(head, value);

			PrintWriter writer = new PrintWriter(new File(jsonNodeFile));
			json.prettyPrint(true);
			writer.write(json.deepSerialize(jsonObj));
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
