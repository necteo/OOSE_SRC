package sogongimms.command;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sogongimms.persistent.dto.LectureDTO;
import sogongimms.persistent.dao.LectureDAO;
import sogongimms.persistent.dao.LectureDateDAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class LectureCreateCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int result = 0;
        LectureDTO lectureDTO = createLectureInfo(request);
        String[] timeInfo = new String[]{ request.getParameter("start_time"), request.getParameter("end_time") };
        try {
            ArrayList<String> dateInfo = createDateInfo(request);
            LectureDAO lectureDAO = new LectureDAO();
            LectureDateDAO lectureDateDAO = new LectureDateDAO();
            result = lectureDAO.insert(lectureDTO);
            ArrayList<LectureDTO> lectures = lectureDAO.select("", "");
            result = lectureDateDAO.insert(lectures.get(lectures.size() - 1).getLectureCode(), dateInfo, timeInfo);
        } catch (SQLException e) {
            e.printStackTrace();
            result = -1;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        request.setAttribute("result", result);
    }

    public LectureDTO createLectureInfo(HttpServletRequest request) {
        LectureDTO lect = new LectureDTO();
        lect.setLectureName(request.getParameter("lect_name"));
        lect.setCapacity(Integer.parseInt(request.getParameter("capacity")));
        lect.setTeacherId(request.getParameter("teacher"));
        lect.setSports(request.getParameter("sports"));
        String[] gender = request.getParameterValues("gender");
        if (gender.length > 1) {
            lect.setGender(2);
        } else {
            lect.setGender(Integer.parseInt(gender[0]));
        }
        lect.setLocation(Integer.parseInt(request.getParameter("location")));
        String[] weeks = request.getParameterValues("weeks");
        String w = "";
        for (String week: weeks) {
            w += week + ", ";
        }
        lect.setWeeks(w.substring(0, w.length() - 2));

        return lect;
    }

    public ArrayList<String> createDateInfo(HttpServletRequest request) throws ParseException {
        HashMap<String, Integer> day_of_week = new HashMap<>(7);
        day_of_week.put("일", 1);
        day_of_week.put("월", 2);
        day_of_week.put("화", 3);
        day_of_week.put("수", 4);
        day_of_week.put("목", 5);
        day_of_week.put("금", 6);
        day_of_week.put("토", 7);

        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar startCalendar = Calendar.getInstance();
        Date startDate = format.parse(start_date);
        startCalendar.setTime(startDate);

        Calendar endCalendar = Calendar.getInstance();
        Date endDate = format.parse(end_date);
        endCalendar.setTime(endDate);

        Calendar cursorCalendar = Calendar.getInstance();
        cursorCalendar.setTime(startDate);

        ArrayList<String> dateInfo = new ArrayList<>();
        String[] weeks = request.getParameterValues("weeks");
        for (String week: weeks) {
            int d = 0;
            if (day_of_week.get(week) > startCalendar.get(Calendar.DAY_OF_WEEK)) {
                d = day_of_week.get(week) - startCalendar.get(Calendar.DAY_OF_WEEK);
            } else if (day_of_week.get(week) < startCalendar.get(Calendar.DAY_OF_WEEK)) {
                d = day_of_week.get(week) - startCalendar.get(Calendar.DAY_OF_WEEK) + 7;
            }
            cursorCalendar.add(Calendar.DATE, d);
            for (; cursorCalendar.getTime().compareTo(endCalendar.getTime()) < 1; ) {
                dateInfo.add(format.format(cursorCalendar.getTime()));
                cursorCalendar.add(Calendar.DATE, 7);
            }
            cursorCalendar.setTime(startDate);
        }

        return dateInfo;
    }
}
