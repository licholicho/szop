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

import shop.User;

@WebFilter(urlPatterns = { "/*" })
public class AdminFilter implements Filter {

	private List<String> adminAllowedAddresses = new ArrayList<String>();

	public void init(FilterConfig fc) throws ServletException {
		InputStream is = fc.getServletContext().getResourceAsStream(
				"/WEB-INF/adminAllowed.txt");
		Scanner scanner = new Scanner(is);
		while (scanner.hasNextLine()) {
			adminAllowedAddresses.add(scanner.nextLine().trim());
		}
		scanner.close();
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpRes = (HttpServletResponse) resp;
		HttpSession session = httpReq.getSession();

		String path = httpReq.getServletPath();
		if (adminAllowedAddresses.contains(path)) {
			User cUser = (User) session.getAttribute("currentUser");
			if (cUser != null && !cUser.isAdmin()) {
				httpRes.sendError(401,
						"Musisz byc zalogowany by wejsc na admina!");
				return;
			}
		}
		fc.doFilter(req, resp);
	}

	public void destroy() {
	}
}
