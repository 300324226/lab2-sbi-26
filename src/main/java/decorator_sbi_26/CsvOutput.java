package decorator_sbi_26;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import entity_sbi_26.ProcessModel;

public class CsvOutput implements Output {

	ProcessModel model;
	PrintWriter writer;
	
	public CsvOutput(ProcessModel model, PrintWriter writer) {
		this.model = model;
		this.writer = writer;
	}
	
	@Override
	public void display() {
		BufferedWriter buffWriter = new BufferedWriter(writer);
		try {
			final int size = Math.max(this.model.getModelPros().size(), this.model.getModelCons().size());
			
			String[][] output = new String[size+2][];
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
			output[0] = new String[] { this.model.getModelName() };
			output[2] = new String[] { "Pros:", "\t", "Cons:" };
			for (int i = 0; i < size; i++) {
				String[] row = new String[3];
				if (i < this.model.getModelPros().size()) {
					row[0] = String.format("\t* %s", this.model.getModelPros().get(i));					
				}
				if (i < this.model.getModelCons().size()) {
					row[2] = String.format("\t* %s", this.model.getModelCons().get(i));
				}
				output[2+i] = row;
			}
			csvPrinter.printRecords(output);
			csvPrinter.flush();
			csvPrinter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
