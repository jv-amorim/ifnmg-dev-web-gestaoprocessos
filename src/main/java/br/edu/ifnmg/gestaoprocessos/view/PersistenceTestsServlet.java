package br.edu.ifnmg.gestaoprocessos.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Transactional
public class PersistenceTestsServlet extends HttpServlet{
	
	private static final long serialVersionUID = -6443359076301085971L;
	
	@Inject
	private PersistenceTestBean bean;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		bean.popularBanco();
		
		try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Test</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Teste de persistencia</h1>");
            out.println("</body>");
            out.println("</html>");
        }catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
