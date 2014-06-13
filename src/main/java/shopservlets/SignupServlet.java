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
import shopDAO.UserDAO;

@WebServlet("/register")
public class SignupServlet extends HttpServlet {
	    public String loginMessage;
	    public String passMessage;
	    
	    public void setLoginMessage(String loginMessage) {
	        this.loginMessage = loginMessage;
	    }

	    public void setPassMessage(String passMessage) {
	        this.passMessage = passMessage;
	    }
	    
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        request.setCharacterEncoding("UTF-8");
	        String login = request.getParameter("loginr");
	        String pass = request.getParameter("passr");

	        Message auxMessage = new Message();
	        
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
	            isError = true;
	        }

	        UserDAO dao = (UserDAO) getServletContext().getAttribute("customerDAO");
	        
	        if (dao.isUserWithLogin(login)) {
	            loginMessage = "Uzytkownik z takim loginem istnieje";
	            setLoginMessage(loginMessage);
	            auxMessage.setLoginMessage(loginMessage);
	            isError = true;
	        }

	        if (!isError) {
	            dao.createUser(new User(login, Encryption.md5(pass)));
	            auxMessage.setLoginMessage("Dodano uzytkownika poprawnie");
	            request.setAttribute("messageR", auxMessage);
	        } else {
	        	auxMessage.setLoginMessage("else");
	            auxMessage.setLogin(login);
	         //   request.setAttribute("messageR", helper);
	        }
	        request.setAttribute("messageR", auxMessage);
	        RequestDispatcher dis = request.getRequestDispatcher("/welcome.jsp");
	        dis.forward(request, response);
	    }
	}

