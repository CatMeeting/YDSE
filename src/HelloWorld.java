import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

	public class HelloWorld extends HttpServlet {

	  public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ServletException{

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html><head>Sample</head><body>");
	    out.println("<p>Hello World!</p>");
	    out.println("</body></html>");
	  }
	}

