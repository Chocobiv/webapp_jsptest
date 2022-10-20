package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/list")
public class list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public list() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray array = new JSONArray();
		
		//DAO
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.getlist();
		
		JSONObject object = new JSONObject();
		for(BoardDto dto : list) {
			object.put("bno", dto.getBno());
			object.put("btitle", dto.getBtitle());
			object.put("bcontent", dto.getBcontent());
			object.put("bwriter", dto.getBwriter());
			object.put("bpassword", dto.getBpassword());
			object.put("bdate", dto.getBdate());
			object.put("bview", dto.getBview());
		}
		array.add(object);
		
		//응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
