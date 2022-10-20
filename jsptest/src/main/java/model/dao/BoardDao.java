package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dto.BoardDto;

public class BoardDao {
	Connection con;			//DB 연동 인터페이스
	PreparedStatement ps;	//sql 조작 인터페이스
	ResultSet rs;			//쿼리 조작 인터페이스
	
	public BoardDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jsptest","root","1234");
			System.out.println("DB연동 성공");
		} catch (Exception e) {System.out.println("DB연동 실패) "+e);}
	}
	
	public boolean write(String btitle, String bcontent, String bwriter, String bpassword) {
		String sql = "insert into board (btitle,bcontent,bwriter,bpassword) values (?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setString(3, bwriter);
			ps.setString(4, bpassword);
			ps.executeUpdate();
			return true;
		} catch (Exception e) { System.out.println("DB오류) "+e); }
		return false;
	}
	
	public ArrayList<BoardDto> getlist(){
		String sql = "select * from board";
		ArrayList<BoardDto> list = new ArrayList();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDto dto = new BoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7));
				list.add(dto);
			}
			return list;
		} catch (Exception e) { System.out.println("DB오류) "+e); }
		return list;
	}
	
	public BoardDto getboard(int bno) {
		String sql = "select * from board where bno=?";
		BoardDto dto = new BoardDto();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bno);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BoardDto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7));
			}
			return dto;
		} catch (Exception e) { System.out.println("DB오류) "+e); }
		return dto;
	}
}
