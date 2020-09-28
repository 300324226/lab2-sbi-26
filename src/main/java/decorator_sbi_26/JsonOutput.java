package decorator_sbi_26;

import java.io.PrintWriter;
import org.json.simple.*;

import entity_sbi_26.ProcessModel;

public class JsonOutput implements Output {
	
	ProcessModel model;
	PrintWriter writer;
	
	public JsonOutput(ProcessModel model, PrintWriter writer) {
		this.model = model;
		this.writer = writer;
	}

	@Override
	public void display() {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("modelName", this.model.getModelName());
		jsonObj.put("pros", this.model.getModelPros());
		jsonObj.put("cons", this.model.getModelCons());
		this.writer.println(jsonObj.toJSONString());
	}

}
