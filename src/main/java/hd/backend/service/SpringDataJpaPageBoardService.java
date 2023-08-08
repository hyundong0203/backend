package hd.backend.service;

import hd.backend.domain.Board;
import hd.backend.dto.BoardListResult;
import hd.backend.repository.SpringDataJpaOracleBoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class SpringDataJpaPageBoardService implements PageBoardService {
    @Autowired
    private final SpringDataJpaOracleBoardRepository repository;

    @Override
    public Page<Board> findAll(Pageable pageable) {

        return repository.findByOrderBySeqDesc(pageable);
    }

    @Override
    public BoardListResult getBoardListResult(Pageable pageable) {
        Page<Board> list = findAll(pageable);
        int page = pageable.getPageNumber();
        long totalCount = repository.count();
        int size = pageable.getPageSize();
        return new BoardListResult(page, totalCount, size, list);
    }

    @Override
    public Board insertS(Board board) {
        board = repository.save(board);
        return board;
    }

    @Override
    public Board updateS(Board board) {
        Board boardlist = repository.getReferenceById(board.getSeq());
        boardlist.setSeq(board.getSeq());
        boardlist.setEmail(board.getEmail());
        boardlist.setSubject(board.getSubject());
        boardlist.setContent(board.getContent());
        return boardlist;
    }

    @Override
    public Board ContentBoard(long seq) {
        return repository.findBySeq(seq);
    }

    @Override
    public void deleteS(long seq) {
        repository.deleteById(seq);
    }
}
