

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class regicontroler
 */
@WebServlet("/regicontroler")
public class regicontroler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regicontroler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String email=request.getParameter("email");
		
		Regibean n=new Regibean();
		n.setName(name);
		n.setPass(password);
		n.setEmail(email);
		
		daoREGI gb=new daoREGI();
		gb.show(n);
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.forward(request,response);
	}

}
