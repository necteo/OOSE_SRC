package sogongimms.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sogongimms.command.*;

import java.io.IOException;

@WebServlet(name = "Member", value = "/MemberView/Member/*")
public class MemberController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doAction(request, response);
    }

    protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Command command = null;	// 어떠한 로직을 수행할지
        String viewPage = null;	// 어떠한 페이지를 보여줄지

        // URL 로부터 command 분리
        String uri = request.getRequestURI();
        String com = uri.substring(uri.lastIndexOf('/'));

        switch(com) {
            case "/login":
                viewPage = "Login.jsp";
                break;
            case "/loginOk":
                command = new MemberLoginCommand();
                command.execute(request, response);
                viewPage = "LoginOk.jsp";
                break;
            case "/logout":
                viewPage = "LogoutOk.jsp";
                break;
            case "/join":
                viewPage = "Join.jsp";
                break;
            case "/joinOk":
                command = new MemberJoinCommand();
                command.execute(request, response);
                viewPage = "JoinOk.jsp";
                break;
            case "/lists":
                command = new MemberListCommand();
                command.execute(request, response);
                viewPage = "MemberView.jsp";
                break;
            case "/search":
                command = new MemberSearchCommand();
                command.execute(request, response);
                viewPage = "MemberView.jsp";
                break;
        }

        // view page 로 forward
        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/MemberView/" + viewPage);
            dispatcher.forward(request, response);
        }
    }
}
