package hd.backend.repository;


import hd.backend.domain.Board;
import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
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
public class JpaOracleBoardRepository implements BoardRepository {
    //@Autowired
    private final EntityManager em;
    //@Autowired
    public JpaOracleBoardRepository(EntityManager em){
            this.em = em;
    }

    @Override
    public List<Board> list() {
        List<Board> list = em.createQuery("SELECT b FROM Board b ORDER BY b.seq DESC", Board.class)
                    .getResultList();
                return list;
        
        }
    public List<Board> findByName(String writer) {
        List<Board> list = em.createQuery("select B from BOARD b where b.writer=:writer", Board.class)
                .setParameter("writer", writer)
                .getResultList();
        return list;
    }
    public Board findBySeq(long seq){
        Board board = em.find(Board.class, seq);
        return board;
    }

    @Override
    public Board insert(Board board) { //insert, update, delete 기능은 jpql이 필요없음
        em.persist(board);
        return board;
    }
    @Override  //contentboard
    public Board updateshow(long seq) {
        List<Board> list = em.createQuery("select b from Board b where b.seq = :seq", Board.class)
        .setParameter("seq", seq)
        .getResultList();
        return list.isEmpty() ? null : list.get(0);           
    }

    @Override
    public Board update_ok(Board board) {
        em.createQuery("UPDATE Board b SET b.email=:email, b.subject=:subject, b.content=:content where b.seq=:seq",Board.class)
        .setParameter("email",board.getEmail())
        .setParameter("subject",board.getSubject())
        .setParameter("content",board.getContent())
        .setParameter("seq",board.getSeq())
        .executeUpdate();
        
        return board;
    }

    @Override
    public boolean delete(long seq) { 
        Board board = findBySeq(seq);
        em.remove(board);
        return true;
    }
}

