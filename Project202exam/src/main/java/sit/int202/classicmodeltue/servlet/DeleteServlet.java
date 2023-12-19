package sit.int202.classicmodeltue.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodeltue.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/deleteoffice.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteByOfficeCode = request.getParameter("deletebyofficecode");
        OfficeRepository officeRepository = new OfficeRepository();
        officeRepository.delete(deleteByOfficeCode);
        response.sendRedirect("office-list");
    }
}