package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JdbcUtil;
import vo.BookVo;

public class BookDAO {
	public BookDAO() {
	}
	
	public ArrayList<BookVo> getBookList() {
		ArrayList<BookVo> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from bookshop order by isbn";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookVo vo = new BookVo();
				vo.setIsbn(rs.getString("isbn"));
				vo.setTitle(rs.getString("title"));
				vo.setAuthor(rs.getString("author"));
				vo.setCompany(rs.getString("company"));
				vo.setPrice(rs.getInt("price"));
				
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		
		return list;
	}

	public int insertBookData(BookVo data) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into bookshop values(?, ?, ?, ?, ?)";
		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, data.getIsbn());
			pstmt.setString(2, data.getTitle());
			pstmt.setString(3, data.getAuthor());
			pstmt.setString(4, data.getCompany());
			pstmt.setInt(5, data.getPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
		
		return result;
	}
}
