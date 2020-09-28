/**
 * @author stan biryukov (300324226)
 * 
 * Process Model class
 */

package entity_sbi_26;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ProcessModel {
	protected String modelName;
	protected String modelDescription;
	protected ArrayList<String> modelCons;
	protected ArrayList<String> modelPros;
	
	public ProcessModel() {
		this.modelCons = new ArrayList<String>();
		this.modelPros = new ArrayList<String>();
	}
	
	/**
	 * Getter Model Name
	 * @return String
	 */
	public String getModelName() {
		return this.modelName;
	}
	
	/**
	 * Getter Model Description
	 * @return String
	 */
	public String getModelDescription() {
		return this.modelDescription;
	}
	
	/**
	 * Getter Model Cons List
	 * @return list of cons per model
	 */
	public ArrayList<String> getModelCons() {
		return this.modelCons;
	}
	
	/**
	 * Getter Model Pros List
	 * @return list of pros per model
	 */
	public ArrayList<String> getModelPros() {
		return this.modelPros;
	}
	
	/**
	 * Fills model name
	 * @param modelDescription name of model
	 * @throws Exception if model name is empty or null
	 */
	public void fillModelName(String modelName) throws Exception {
		if (modelName == null || modelName.equals("")) {
			throw new Exception("Model name can't be empty!");
		}
		this.modelName = modelName;
	}
	
	/**
	 * Fills model description
	 * @param modelDescription description of model
	 * @throws Exception if model description is empty or null
	 */
	public void fillModelDescription(String modelDescription) throws Exception {
		if (modelDescription == null || modelDescription.equals("")) {
			throw new Exception("Model description can't be empty!");
		}
		this.modelDescription = modelDescription;
	}
	
	/**
	 * Adds Con to the list
	 * @param modelCon
	 */
	public void fillModelCon(String modelCon) {
		this.modelCons.add(modelCon);
	}
	
	/**
	 * Adds Pro to the list
	 * @param modelPro
	 */
	public void fillModelPro(String modelPro) {
		this.modelPros.add(modelPro);
	}
	
	/**
	 * Fill Pros from list
	 * @param prosList
	 */
	public void fillModelProsList(String[] prosList) {
		for (String pro : prosList) {
			this.fillModelPro(pro);
		}
	}
	
	/**
	 * Fill Cons from list
	 * @param consList
	 */
	public void fillModelConsList(String[] consList) {
		for (String con : consList) {
			this.fillModelCon(con);
		}
	}
	
	/**
	 * Saves model values into text file with model name as file name (UTF-8)
	 */
	public void saveModel() {
		OutputStreamWriter writer = null;
		try {
			writer = new OutputStreamWriter(new FileOutputStream(String.format("%s.txt", this.modelName.trim())), "UTF-8");
			writer.append(String.format(" Model Name: %s", this.modelName));
			
			writer.append("\n\n");
			writer.append(String.format(" Model Description: %s", this.modelDescription));
			
			writer.append("\n\n");
			writer.append(String.format(" %s pros:\n", this.modelName));
			for (String proVal : this.modelPros) {
				writer.append(String.format("\n\t* %s", proVal));
			}
			
			writer.append("\n\n");
			writer.append(String.format(" %s cons:\n", this.modelName));
			for (String conVal : this.modelCons) {
				writer.append(String.format("\n\t* %s", conVal));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {}
			}
		}
	}
}
