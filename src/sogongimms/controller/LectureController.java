package sogongimms.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sogongimms.command.*;

import java.io.IOException;

@WebServlet(name = "Lecture", urlPatterns = {"/LectureView/Lecture/*"})
public class LectureController extends HttpServlet {

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
            case "/listView":
                viewPage = "LectureListView.jsp";
                break;
            case "/lists":
                command = new LectureListCommand();
                command.execute(request, response);
                viewPage = "LectureListView.jsp";
                break;
            case "/createView":
                viewPage = "LectureCreateView.jsp";
                break;
            case "/create":
                command = new LectureCreateCommand();
                command.execute(request, response);
                viewPage = "LectureCreateOk.jsp";
                break;
            case "/register":
                command = new RegisteringForLecturesCommand();
                command.execute(request, response);
                viewPage = "RegisteringForLecturesOk.jsp";
                break;
            case "/takingView":
                command = new TakingLectureListCommand();
                command.execute(request, response);
                viewPage = "TakingLecturesView.jsp";
                break;
        }

        // view page 로 forward
        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LectureView/" + viewPage);
            dispatcher.forward(request, response);
        }
    }
}
