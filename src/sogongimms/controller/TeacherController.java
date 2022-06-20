package sogongimms.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sogongimms.command.*;

import java.io.IOException;

@WebServlet(name = "Teacher", urlPatterns = {"/TeacherView/Teacher/*"})
public class TeacherController extends HttpServlet {

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
            case "/lists":
                command = new TeacherListCommand();
                command.execute(request, response);
                viewPage = "TeacherListView.jsp";
                break;
            case "/createView":
                viewPage = "TeacherCreateView.jsp";
                break;
            case "/create":
                command = new TeacherCreateCommand();
                command.execute(request, response);
                viewPage = "TeacherCreateOk.jsp";
                break;
            case "/view":
                command = new TeacherCommand();
                command.execute(request, response);
                viewPage = "TeacherView.jsp";
                break;
        }

        // view page 로 forward
        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/TeacherView/" + viewPage);
            dispatcher.forward(request, response);
        }
    }
}
