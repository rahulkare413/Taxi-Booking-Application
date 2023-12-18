package taxiOperation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pickupPoint = req.getParameter("pick");
        String dropPoint = req.getParameter("drop");
        String kms = req.getParameter("kilometer");
        String car = req.getParameter("car");

        Calculation c1 = new Calculation();
        double payableAmount = c1.taxiBill(kms, car);

        PrintWriter pw = resp.getWriter();

        // Setting up HTML content with background image
        pw.println("<!DOCTYPE html>");
        pw.println("<html>");
        pw.println("<head>");
        pw.println("<title>Taxi Fare Details</title>");
        pw.println("<style>");
        pw.println("body {");
        pw.println("    background-image: url('https://cdn.pixabay.com/photo/2015/07/23/02/57/united-states-856368_1280.jpg'); /* Replace 'path_to_your_image.jpg' with the image path */");
        pw.println("    background-size: cover;");
        pw.println("    background-position: center;");
        pw.println("    color: white; /* Text color for better visibility */");
        pw.println("}");
        pw.println("</style>");
        pw.println("</head>");
        pw.println("<body>");

        pw.println("<h1>Taxi Fare Details</h1>");
        pw.println("<p>Pickup Point: " + pickupPoint + "</p>");
        pw.println("<p>Drop Point: " + dropPoint + "</p>");
        pw.println("<p>Distance Travelled: " + kms + " kilometers</p>");
        pw.println("<p>Selected Car Type: " + car + "</p>");
        pw.println("<p>Payable Amount: Rs." + payableAmount + "</p>");

        pw.println("</body>");
        pw.println("</html>");
    }
}
