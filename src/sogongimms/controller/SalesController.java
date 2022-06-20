package sogongimms.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sogongimms.command.*;
import sogongimms.persistent.dto.NoticeTitleDTO;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Sales", value = "/SalesView/Sales/*")
public class SalesController extends HttpServlet {
    ArrayList<NoticeTitleDTO> testSet = new ArrayList<>();

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
            case "/salesView":
                viewPage = "SalesMain.jsp";
                break;
            case "/sales":
                command = new SalesCommand();
                command.execute(request, response);
                viewPage = "SalesMain.jsp";
                break;
        }

        // view page 로 forward
        if (viewPage != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/SalesView/" + viewPage);
            dispatcher.forward(request, response);
        }
    }
}
