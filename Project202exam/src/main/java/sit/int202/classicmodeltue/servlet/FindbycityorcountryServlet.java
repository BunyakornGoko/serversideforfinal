package sit.int202.classicmodeltue.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodeltue.entities.Office;
import sit.int202.classicmodeltue.repositories.OfficeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FindbycityorcountryServlet", value = "/FindbycityorcountryServlet")
public class FindbycityorcountryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/findbycityorcountry.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityorcountry = request.getParameter("findcitycountry");
        OfficeRepository officeRepository = new OfficeRepository();
        List<Office> officeList=  officeRepository.findByCityOrCountry(cityorcountry);
        request.setAttribute("officelist",officeList);
        request.setAttribute("input",cityorcountry);
        getServletContext().getRequestDispatcher("/findbycityorcountry.jsp").forward(request,response);
    }
}