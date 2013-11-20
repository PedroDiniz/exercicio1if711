import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

public class LengthName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // pegando os parâmetros do request
        String nome = req.getParameter("nome");
		resp.getWriter().println("<html>");
        resp.getWriter().println("<body>");
		if(nome!=null){
			resp.getWriter().println("Seu nome ("+ nome +") tem "+ nome.length() +" letras");
		}else{
			resp.getWriter().println("Sem nome!");
		}
		resp.getWriter().println("<form action=\"/\">");
        resp.getWriter().println("<input type=\"submit\" value=\"Novamente\" />");    
        resp.getWriter().println("</form>");
		resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
        resp.getWriter().println("Volte Sempre!");
        //resp.getWriter().print("Teste IF711\n");
    }

}
