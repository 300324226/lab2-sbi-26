package controller_sbi_26;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity_sbi_26.ProcessModel;
import decorator_sbi_26.*;

/**
 * Servlet implementation class ValidationController
 */
public class ValidationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessModel processModel = new ProcessModel();
		try {
			processModel.fillModelName(request.getParameter("modelName"));
			String[] prosList = request.getParameter("prosList").split("\n");
			String[] consList = request.getParameter("consList").split("\n");
			processModel.fillModelProsList(prosList);
			processModel.fillModelConsList(consList);
		} catch (Exception e) {
			
		} finally {
			response.setContentType("text/html");
			Output output;
			switch (request.getParameter("outputType")) {
			case "json":
				output = new JsonOutput(processModel, response.getWriter());
				break;
			case "csv":
				output = new CsvOutput(processModel, response.getWriter());
				break;
			default:
				output = new HtmlOutput(processModel, response.getWriter());
				break;
			}
			output.display();
		}
	}

}
