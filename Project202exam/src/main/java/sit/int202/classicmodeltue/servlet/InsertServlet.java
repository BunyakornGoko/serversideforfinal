package sit.int202.classicmodeltue.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sit.int202.classicmodeltue.entities.Office;
import sit.int202.classicmodeltue.repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "InsertServlet", value = "/InsertServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/insertoffice.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeCode = request.getParameter("officeCode");
        String addressLine1 =request.getParameter("addressLine1");
        String addressLine2 =request.getParameter("addressLine2");
        String city =request.getParameter("city");
        String state =request.getParameter("state");
        String country =request.getParameter("country");
        String postalCode =request.getParameter("postalCode");
        String phone =request.getParameter("phone");
        String territory =request.getParameter("territory");

        Office office = new Office();
        office.setOfficeCode(officeCode);
        office.setAddressLine1(addressLine1);
        office.setAddressLine2(addressLine2);
        office.setCity(city);
        office.setState(state);
        office.setCountry(country);
        office.setPostalCode(postalCode);
        office.setPhone(phone);
        office.setTerritory(territory);

        OfficeRepository officeRepository = new OfficeRepository();
        officeRepository.insert(office);


        response.sendRedirect("office-list");
    }
}