package ch.hearc.servlet.controlleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.hearc.servlet.dao.TachesDao;

@WebServlet(
		name="mainServlet",
		urlPatterns = ""
)
public class MainServlet extends HttpServlet{

TachesDao tachesDao = new TachesDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
		
		req.setAttribute("liste_taches", tachesDao.getAllTaches());
		
		try {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
