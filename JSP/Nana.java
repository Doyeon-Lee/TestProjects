import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Nana extends HttpServlet{
	public void service(HttpServletRequest request,
		            HttpServletResponse response)
			throws IOException, ServletException
	{
		/*
		OutputStream os = response.getOutputStream();
		PrintStream out = new PrintStream(os, true);
		
		There is Stream/Writer in Java.
		If you're going to use a string which is foreign,
		you should use Writer.
		*/
		PrintWriter out = response.getWriter();
		out.println("Hello Servlet!!");
	}
}