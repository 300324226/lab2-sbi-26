package decorator_sbi_26;

import java.io.PrintWriter;

import entity_sbi_26.ProcessModel;

public class HtmlOutput implements Output {
	StringBuilder template;
	ProcessModel model;
	PrintWriter writer;
	
	public HtmlOutput(ProcessModel model, PrintWriter writer) {
		this.template = new StringBuilder();
		this.model = model;
		this.writer = writer;
	}

	@Override
	public void display() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("<h1>%s</h1>", this.model.getModelName()));
		
		if (this.model.getModelDescription() != null) {
			output.append("\n\n");
			output.append(String.format(" Model Description: %s", this.model.getModelDescription()));	
		}
		
		output.append("<table>");
		output.append("<tbody>");
		output.append("<tr>");
		output.append("<td width=\"35%\">");
		output.append(String.format("<p><b>Pros:</b></p>", this.model.getModelName()));
		for (String proVal : this.model.getModelPros()) {
			output.append(String.format("<p>* %s</p>", proVal));
		}
		output.append("</td>");
		output.append("<td width=\"35%\"");
		output.append(String.format("<p><b>Cons:</b></p>", this.model.getModelName()));
		for (String conVal : this.model.getModelCons()) {
			output.append(String.format("<p>* %s</p>", conVal));				
		}
		output.append("</td>");
		output.append("</tr>");
		output.append("</tbody");
		output.append("</table>");
		
		this.writer.println(output);
	}
}
