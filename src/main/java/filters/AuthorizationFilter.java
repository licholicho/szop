package filters;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/*"})
public class AuthorizationFilter implements Filter {

    private List<String> allowedAddresses = new ArrayList<String>();
    
    public void init(FilterConfig fc) throws ServletException {
        InputStream is = fc.getServletContext().getResourceAsStream("/WEB-INF/allowed.txt");
        Scanner scanner = new Scanner(is);
        while (scanner.hasNextLine()) {
            allowedAddresses.add(scanner.nextLine().trim());
        }
        scanner.close();
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException {
    	HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) resp;
        HttpSession session = httpReq.getSession();
        String login = (String) session.getAttribute("user");
        if (login != null) {
            fc.doFilter(req, resp);
        } else {
            String path = httpReq.getServletPath();
            System.out.println(path);
            if (allowedAddresses.contains(path)) {
                fc.doFilter(req, resp);
            } else {
            	httpRes.sendError(401, "Musisz byc zalogowany by wejsc na strone!");
            }
        }
    }

    public void destroy() {
    }
}
