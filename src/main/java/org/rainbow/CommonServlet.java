package org.rainbow;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ross
 */
@WebServlet("*.html")
public class CommonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6866417103101156508L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String ctxPath = this.getServletContext().getContextPath();
		int index = uri.lastIndexOf('.');
		String path = uri.substring(ctxPath.length(), index);
		String dispatcherPath = String.format("/WEB-INF/jsp%s.jsp", path);
		req.getRequestDispatcher(dispatcherPath).forward(req, resp);
	}
	
}

