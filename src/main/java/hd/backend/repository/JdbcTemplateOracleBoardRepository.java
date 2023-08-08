package hd.backend.repository;


import hd.backend.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class JdbcTemplateOracleBoardRepository implements BoardRepository {
    //@Autowired
    private final JdbcTemplate jdbcTemplate;
    //@Autowired
    public JdbcTemplateOracleBoardRepository(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*private void close(Connection con) throws SQLException {
        DataSourceUtils.releaseConnection(con, dataSource);
    }*/
    @Override
    public List<Board> list() {
        String sql = "select * from BOARD order by SEQ desc";
        List<Board> list = jdbcTemplate.query(sql, boardRowMapper());
        return list;
        }
    private RowMapper<Board> boardRowMapper(){
        return new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board board = new Board();
                board.setSeq(rs.getLong("seq"));
                board.setWriter(rs.getString("writer"));
                board.setEmail(rs.getString("email"));
                board.setSubject(rs.getString("subject"));
                board.setContent(rs.getString("content"));
                board.setRdate(rs.getDate("rdate"));
                board.setUdate(rs.getDate("udate"));
                return board;
            }
        };
    }

    @Override
    public Board insert(Board board) {
        String sql = "insert into BOARD values(BOARD_SEQ.nextval,? ,? ,?, ? ,SYSDATE,SYSDATE)";
        jdbcTemplate.update(sql, board.getWriter(), board.getEmail(), board.getSubject(), board.getContent());

        return board;
    }

    @Override
    public Board updateshow(long seq) {
        String sql = "select * from BOARD where SEQ = ?";
        Board board = jdbcTemplate.queryForObject(sql,boardRowMapper(),seq);
        return board;
    }

    @Override
    public Board update_ok(Board board) {
        long seq = jdbcTemplate.queryForObject("select BOARD_SEQ.nextval from dual",Long.class);
        String sql = "update BOARD set EMAIL=?, SUBJECT=?, CONTENT=? where SEQ=?";
        jdbcTemplate.update(sql,board.getEmail(),board.getSubject(),board.getContent(),board.getSeq());

        return board;
    }

    @Override
    public boolean delete(long seq) {
        String sql ="delete from BOARD where SEQ=?";
        int count = jdbcTemplate.update(sql,seq);
        if(count > 0) return true;
        else return false;
    }
}
