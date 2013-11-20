import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class HelloWorld extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		
		//resp.setContentType("text/html");		
                         
        // pegando os parâmetros do request
		resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");
		
		resp.getWriter().println("<form action=\"testando\">");
		resp.getWriter().println("Nome: <input type=\"text\" name=\"nome\" /><br />");
        resp.getWriter().println("<input type=\"submit\" value=\"Gravar\" />");    
        resp.getWriter().println("</form>");
		resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
        //resp.getWriter().print("Teste IF711\n");
    }

    public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
		//context.addServlet(new ServletHolder(new HelloWorld()),"/*");
        context.addServlet(new ServletHolder(new HelloWorld()),"/");
		context.addServlet(new ServletHolder(new LengthName()),"/testando/*");
        server.start();
        server.join();   
    }
}
