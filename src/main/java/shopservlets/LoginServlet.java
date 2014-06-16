package shopservlets;

import helpers.Encryption;
import helpers.Message;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.User;
import shopiDAO.IUserDAO;
import cart.ShoppingCart;
import decorators.ZlotyDekorator;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public String loginMessage;
    public String passMessage;
    
    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public void setPassMessage(String passMessage) {
        this.passMessage = passMessage;
    }

    Message auxMessage = new Message();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dis = request.getRequestDispatcher("/home.jsp");
        dis.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String login = request.getParameter("login");
	        String pass = request.getParameter("pass");
	        	        
	        boolean isError = false;
	        if (login == null || login.trim().equals("")) {
	            loginMessage = "Nie wpisano loginu";
	            setLoginMessage(loginMessage);
	            auxMessage.setLoginMessage(loginMessage);
	            isError = true;
	        }

	        if (pass == null || pass.trim().equals("")) {
	            passMessage = "Nie wpisano hasla";
	            setPassMessage(passMessage);
	            auxMessage.setPassMessage(passMessage);
	            System.out.println(passMessage);
	            isError = true;	        
	        }
	        
	        IUserDAO dao = (IUserDAO) getServletContext().getAttribute("customerDAO");
	        
	        User dbUser = dao.getUser(new User(login, Encryption.md5(pass)));
	        
	        if (dbUser == null) {
	            loginMessage = "Zle dane logowania";
	            setLoginMessage(loginMessage);
	            auxMessage.setLoginMessage(loginMessage);
	            request.setAttribute("messageL", auxMessage);
	            isError = true;
	        }

	       if (!isError) {
	    	   	request.getSession().setAttribute("currentUser", dbUser);
	        	ShoppingCart cart = new ShoppingCart();
	        	request.getSession().setAttribute("cart", cart);
	        	ZlotyDekorator dekorator = new ZlotyDekorator();
	    		request.getSession().setAttribute("dekorator", dekorator);
	            RequestDispatcher dis = request.getRequestDispatcher("/search");
	            dis.forward(request, response);
	       }     else {
	            auxMessage.setLogin(dbUser.getLogin());
	            RequestDispatcher dis = request.getRequestDispatcher("/welcome.jsp");
	            dis.forward(request, response);
	        }
	       request.setAttribute("messageL", auxMessage);

	}
	
	}

