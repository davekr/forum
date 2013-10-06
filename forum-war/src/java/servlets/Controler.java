/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dave
 */
public class Controler extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException{
            execute(request, response);
	}

    @Override
    public void doPost(HttpServletRequest request,
	        HttpServletResponse response) throws ServletException, IOException{
            execute(request, response);
    }

    public void execute(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

        request.getSession(true).setAttribute("user", null);
        getServletContext().getRequestDispatcher("/faces/pages/forum.jsp")
                            .forward(request, response);
    }

}
