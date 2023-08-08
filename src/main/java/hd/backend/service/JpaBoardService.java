package hd.backend.service;

import org.springframework.stereotype.Service;

import hd.backend.domain.Board;
import hd.backend.repository.BoardRepository;
import jakarta.transaction.Transactional;


import java.util.List;

//@Service
@Transactional
public class JpaBoardService implements BoardService{
    //@Autowired
    private final BoardRepository repository;
    //@Autowired
    public JpaBoardService(BoardRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Board> listS() {

        return repository.list();
    }

    @Override
    public Board insertS(Board board) {
        
        board = repository.insert(board);
      
        return board;
    }
    @Override
    public boolean deleteS(long seq) {
       
        return repository.delete(seq);
    }
    @Override
    public Board updateshow(long seq) {
        
        return repository.updateshow(seq);
      
    }
    @Override
    public Board update_ok(Board board) {
        
        board = repository.update_ok(board);
      
        return board;
    }
}