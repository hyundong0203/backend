package hd.backend.repository;

import hd.backend.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//@Repository
public class JdbcOracleBoardRepository implements BoardRepository {
    //@Autowired //DI 의존성 주입
    private final DataSource dataSource;
    //@Autowired
    public JdbcOracleBoardRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    Connection getConnection(){
        return DataSourceUtils.getConnection(dataSource);
    }
    private void close(Connection con) throws SQLException {
        DataSourceUtils.releaseConnection(con, dataSource);
    }
    @Override
    public List<Board> list() {
        ArrayList<Board> list = new ArrayList<>();
        String sql = "select * from BOARD order by SEQ desc";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs =null;
        try{
            con = getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                long seq = rs.getLong(1);
                String writer = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String content = rs.getString(5);
                Date rdate = rs.getDate(6);
                Date udate = rs.getDate(7);
                list.add(new Board(seq, writer, email, subject,content, rdate,udate));
            }
            return list;
        }catch(SQLException se){
            return null;
        }finally {
            close(con,stmt,rs);
        }
    }
    private void close(Connection con,Statement stmt, ResultSet rs){
        try{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        }catch(SQLException se){}
    }
    @Override
    public Board insert(Board board) {
        String sql = "insert into BOARD values(BOARD_SEQ.nextval,? ,? ,?, ? ,SYSDATE,SYSDATE)";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,board.getWriter());
            pstmt.setString(2,board.getEmail());
            pstmt.setString(3,board.getSubject());
            pstmt.setString(4,board.getContent());
            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            return board;
        }catch(SQLException se){
            se.printStackTrace();
            return null;
        }finally{
            close(con,pstmt,rs);
        }

    }
    @Override
    public Board updateshow(long seq) {
        String sql = "SELECT * FROM BOARD WHERE SEQ = ?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setLong(1, seq);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                seq = rs.getLong(1);
                String writer = rs.getString(2);
                String email = rs.getString(3);
                String subject = rs.getString(4);
                String content = rs.getString(5);
                Date rdate = rs.getDate(6);
                Date udate = rs.getDate(7);

                return new Board(seq, writer, email, subject, content, rdate, udate);
            }else {
                return null;
            }
        }catch(SQLException se) {
            return null;
        }finally{
            close(con,pstmt,rs);
        }

    }
    @Override
    public Board update_ok(Board board) {
        String sql = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,board.getEmail());
            pstmt.setString(2,board.getSubject());
            pstmt.setString(3,board.getContent());
            pstmt.setLong(4,board.getSeq());
            pstmt.executeUpdate();

            rs = pstmt.getGeneratedKeys();
            return board;
        }catch(SQLException se){
            se.printStackTrace();
            return null;
        }finally{
            close(con,pstmt,rs);
        }

    }

    @Override
    public boolean delete(long seq) {
        String sql = "delete from BOARD where SEQ = ?";
        Connection con =null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setLong(1, seq);
            int i = pstmt.executeUpdate();
            if(i>0) return true;
            else return false;
        }catch(SQLException se){
            return false;
        }finally {
            close(con, pstmt, rs);
        }
    }
}
