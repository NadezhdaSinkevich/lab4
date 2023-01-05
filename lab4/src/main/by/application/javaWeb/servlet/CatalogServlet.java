package by.application.javaWeb.servlet;

import by.application.javaWeb.model.dto.AutoDto;
import by.application.javaWeb.model.entity.Auto;
import by.application.javaWeb.model.enums.BrandType;
import by.application.javaWeb.model.enums.CarBodyType;
import by.application.javaWeb.model.enums.EngineType;
import by.application.javaWeb.model.enums.TransmissionType;
import by.application.javaWeb.service.AutoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static by.application.javaWeb.servlet.BaseServlet.PROJECT_WAR;

@WebServlet("/Catalog")
public class CatalogServlet extends HttpServlet {

    private AutoService autoService = new AutoService();

    private static final String WELCOME = "Welcome to Auto Catalog";
    private final String FORM_TABLE = "<table>\n" +
            "        <tr>\n" +
            "            <th>Name</th>\n" +
            "            <th>TransmissionType</th>\n" +
            "            <th>CarBodyType</th>\n" +
            "            <th>EngineType</th>\n" +
            "            <th>BrandType</th>\n" +
            "            <th>Country</th>\n" +
            "        </tr>\n" +
            "        <c:forEach var=\"auto\" items=\"${autoList}\">\n" +
            "            <tr>\n" +
            "                <td><c:out value=\"${auto.name}\" /></td>\n" +
            "                <td><c:out value=\"${auto.transmissionType}\" /></td>\n" +
            "                <td><c:out value=\"${auto.carBodyType}\" /></td>\n" +
            "                <td><c:out value=\"${auto.engineType}\" /></td>\n" +
            "                <td><c:out value=\"${auto.brandType}\" /></td>\n" +
            "                <td><c:out value=\"${auto.country}\" /></td>\n" +
            "            </tr>\n" +
            "        </c:forEach>\n" +
            "    </table>";

    private final String FORM_TABLE1 = "<table>\n" +
            "        <tr>\n" +
            "            <th>Name</th>\n" +
            "            <th>TransmissionType</th>\n" +
            "            <th>CarBodyType</th>\n" +
            "            <th>EngineType</th>\n" +
            "            <th>BrandType</th>\n" +
            "            <th>Country</th>\n" +
            "        </tr>\n";

    private final String FORM_TABLE2 = "</table><br>";

    private final String FROM_ADD = " " +
            "<h4>Add Auto: </h4>" +
            "<form action=\"/Project_war/Catalog\" method=\"post\">" +
            "        Name auto: <input name=\"name\" value=\"\" /><br><br>" +
            "        TransmissionType: <input name=\"transmission\" value=\"\" /><br><br>" +
            "        CarBodyType: <input name=\"car\" value=\"\" /><br><br>" +
            "        EngineType: <input name=\"engine\" value=\"\" /><br><br>" +
            "        BrandType: <input name=\"brand\" value=\"\" /><br><br>" +
            "        Country: <input name=\"country\" value=\"\" /><br><br>" +
            "        <input type=\"submit\" value=\"Save\" />" +
            "    </form><br>";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>"+WELCOME+"</h2><br>");
            writer.println(FORM_TABLE1);
            writer.println(getContent());
            writer.println(FORM_TABLE2);
            writer.println(FROM_ADD);
        } finally {
            writer.close();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String name = (String) request.getParameter("name");
            String transmission = (String) request.getParameter("transmission");
            String car = (String) request.getParameter("car");
            String engine = (String) request.getParameter("engine");
            String brand = (String) request.getParameter("brand");
            String country = (String) request.getParameter("country");

            if(null != name && null != transmission && null != car && null != engine
                    && null != brand && null != country) {
                Auto auto = getAuto(name, transmission, car, engine, brand, country);
                autoService.save(auto);
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>"+WELCOME+"</h2><br>");
            writer.println(FORM_TABLE1);
            writer.println(getContent());
            writer.println(FORM_TABLE2);
            writer.println(FROM_ADD);
        } finally {
            writer.close();
        }
    }

    private String getContent() {
        List<AutoDto> autoDtoList = autoService.getCatalogAuto();
        StringBuilder builder = new StringBuilder();
        for(AutoDto autoDto: autoDtoList) {
            builder.append("<tr>");
            builder.append("<td>"+autoDto.getName()+"</td>");
            builder.append("<td>"+autoDto.getTransmissionType()+"</td>");
            builder.append("<td>"+autoDto.getCarBodyType()+"</td>");
            builder.append("<td>"+autoDto.getEngineType()+"</td>");
            builder.append("<td>"+autoDto.getBrandType()+"</td>");
            builder.append("<td>"+autoDto.getCountry()+"</td>");
            builder.append("</tr>");
        }
        return builder.toString();
    }

    private Auto getAuto(String name, String transmission, String car, String engine, String brand, String country) {
        Auto auto = new Auto();
        auto.setName(name);
        auto.setTransmissionTypeId(TransmissionType.getIdByName(transmission));
        auto.setCarBodyTypeId(CarBodyType.getIdByName(car));
        auto.setEngineTypeId(EngineType.getIdByName(engine));
        auto.setBrandTypeId(BrandType.getIdByName(brand));
        auto.setCountry(country);
        auto.setInfo("");
        return auto;
    }
}
