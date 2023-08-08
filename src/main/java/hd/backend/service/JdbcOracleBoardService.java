package hd.backend.service;

import hd.backend.domain.Board;
import hd.backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class JdbcOracleBoardService implements BoardService {
    //@Autowired
    private final BoardRepository repository;
    //@Autowired
    public JdbcOracleBoardService(BoardRepository repository){

        this.repository = repository;
    }
    @Override
    public List<Board> listS() {

        return repository.list();
    }

    @Override
    public Board insertS(Board board) {

        return repository.insert(board);
    }
    @Override
    public Board update_ok(Board board) {

        return repository.update_ok(board);
    }
    @Override
    public Board updateshow(long seq) {

        return repository.updateshow(seq);
    }
    @Override
    public boolean deleteS(long seq) {

        return repository.delete(seq);
    }
}
