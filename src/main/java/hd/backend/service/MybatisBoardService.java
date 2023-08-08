package hd.backend.service;

import hd.backend.domain.Board;
import hd.backend.mapper.AddressMapper;
import hd.backend.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class MybatisBoardService implements BoardService {
//    @Autowired
    private final BoardMapper mapper;
//    @Autowired
    public MybatisBoardService(BoardMapper mapper){
        this.mapper = mapper;
    }
    @Override
    public List<Board> listS() {

        return mapper.list();
    }

    @Override
    public Board insertS(Board board) {
        mapper.insertSelectKey(board);
        long seq = board.getSeq();
        board = mapper.selectBySeq(seq);

        return board;
    }

    @Override
    public Board update_ok(Board board) {
        mapper.update_ok(board);
        return board;
    }

    @Override
    public Board updateshow(long seq) {
        Board board = mapper.selectBySeq(seq);
        return board;
    }

    @Override
    public boolean deleteS(long seq) {
        mapper.delete(seq);
        return true;
    }
}
