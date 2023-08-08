package hd.backend.service;

import hd.backend.domain.Board;
import hd.backend.repository.SpringDataJpaOracleAddressRepository;
import hd.backend.repository.SpringDataJpaOracleBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Calendar;

import java.sql.Date;
import java.util.List;

//@Service
public class SpringDataJpaBoardService implements BoardService {
    //@Autowired
    private final SpringDataJpaOracleBoardRepository repository;
    //@Autowired
     public SpringDataJpaBoardService(SpringDataJpaOracleBoardRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Board> listS() {

         return repository.findAll(Sort.by(Sort.Direction.DESC,"seq"));
    }

    @Override
    public Board insertS(Board board) {
         board = repository.save(board);
         return board;
    }

    @Override
    public Board update_ok(Board board) {
            Board boardlist = repository.getReferenceById(board.getSeq());
            boardlist.setSeq(board.getSeq());
            boardlist.setEmail(board.getEmail());
            boardlist.setSubject(board.getSubject());
            boardlist.setContent(board.getContent());

            return repository.save(boardlist);

    }

    @Override
    public Board updateshow(long seq) {
        return repository.findBySeq(seq);
    }

    @Override
    public boolean deleteS(long seq) {
         repository.deleteById(seq);
         return true;
    }
}
