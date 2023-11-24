package br.edu.ifnmg.gestaoprocessos.view;

import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.applicant.ApplicantEntity;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.selectionprocess.SelectionProcessEntity;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserDaoLocal;
import br.edu.ifnmg.gestaoprocessos.domain.user.UserEntity;
import br.edu.ifnmg.gestaoprocessos.utils.Utils;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

@Transactional
public class PersistenceTestsServlet extends HttpServlet {

    @Inject
    private UserDaoLocal userDao;
    @Inject
    private ApplicantDaoLocal applicantDao;
    @Inject
    private SelectionProcessDaoLocal processDao;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gestão de Processos - Testes de Persistência</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Testes de Persistência</h1>");
            printUsers(out);
            printApplicants(out);
            printProcesses(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet para testes de persistência.";
    }// </editor-fold>

    private void printUsers(PrintWriter out) {
        List<UserEntity> result = userDao.listAll();
        out.println("<h2>Usuários</h2>");
        out.println("<p><pre>" + Utils.toJson(result) + "</pre></p>");
    }

    private void printApplicants(PrintWriter out) {
        List<ApplicantEntity> result = applicantDao.listAll();
        out.println("<h2>Candidatos</h2>");
        out.println("<p><pre>" + Utils.toJson(result) + "</pre></p>");
    }

    private void printProcesses(PrintWriter out) {
        List<SelectionProcessEntity> result = processDao.listAll();
        out.println("<h2>Processos Seletivos</h2>");
        out.println("<p><pre>" + Utils.toJson(result) + "</pre></p>");
    }
}
