package net.server.servlets;

import net.server.dao.SensorDao;
import net.server.dao.SensorStateDao;
import net.server.model.GSONResponse;
import net.server.model.Sensor;
import net.server.model.SensorState;
import net.util.DatabaseConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

@WebServlet(name = "dbServlet", urlPatterns = "/db")

public class DBServlet extends HttpServlet {
    public int counti = 8;
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.getRequestDispatcher("db.ftl").forward(req, resp);
        SensorStateDao sensorStateDao = new SensorStateDao();
        List<SensorState> fullList = sensorStateDao.getAll();
        List<SensorState> list = new ArrayList<>();
        SensorDao sensorDao = new SensorDao();
        for (int i = 1; i <= counti; i++) {
            //list.add(fullList.get(fullList.size() - i));
            SensorState ss = fullList.get(fullList.size() - i);
            int typeId = sensorDao.get(fullList.get(fullList.size() - i).getSensorId()).getSensorTypeId();
            GSONResponse gsonResponse = new GSONResponse();
        }
        String json = new SensorState().convertListToJson(list);
        PrintWriter pw = resp.getWriter();
        resp.setContentType("application/json");
        pw.print(json);
        pw.close();
        //req.setAttribute("list", list);
        //resp.sendRedirect("db.ftl");
        //req.getRequestDispatcher("db.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}

