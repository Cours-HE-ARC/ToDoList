package ch.hearc.servlet.controlleur;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.hearc.servlet.dao.TachesDao;
import ch.hearc.servlet.model.Tache;

@WebServlet(
		name="tacheServlet",
		urlPatterns = "/taches"
)
public class TacheServlet extends HttpServlet{

	TachesDao tachesDao = new TachesDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
		
		PrintWriter out = null;
		
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(tachesDao.getAllTaches().isEmpty()) {
			out.print("Aucune taches enregistrées");
		}else {
			
			out.print("<ul>");
			
			tachesDao.getAllTaches().forEach(tache -> {
				//out.print("<li>" + tache.getDescription() + ", due: " + tache.getDueDate() +"</li>");
			});
			
			out.print("</ul>");
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter out = resp.getWriter();
		
		//out.print("ok - " + req.getParameter("description") + ", "  + req.getParameter("due_date"));
		
		tachesDao.saveTaches(new Tache(req.getParameter("description"), req.getParameter("due_date")));
		
		req.setAttribute("liste_taches", tachesDao.getAllTaches());
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		
	}

	
}
