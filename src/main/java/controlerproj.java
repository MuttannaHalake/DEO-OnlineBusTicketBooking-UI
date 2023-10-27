import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class controlerproj
 */
@WebServlet("/controlerproj")
public class controlerproj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controlerproj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String start=request.getParameter("start");
		String end=request.getParameter("end");
		String pref=request.getParameter("pref");
		String pgen=request.getParameter("pgen");
		Long num =Long.parseLong(request.getParameter("num"));
		
		
		System.out.println(name);
		System.out.println(start);
		System.out.println(end);
		System.out.println(pref);
		System.out.println(pgen);
		System.out.println(num);
		
		beanpro m=new beanpro();
		m.setName(name);
		m.setStart(start);
		m.setEnd(end);
		m.setPref(pref);
		m.setPgen(pgen);
		m.setNum(num);
		
		Daopro dw=new Daopro();
		dw.show(m);
		
		response.sendRedirect("vieww.jsp");
	}

}