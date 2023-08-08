package hd.backend.service;

import hd.backend.domain.Board;
import hd.backend.dto.BoardListResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PageBoardService {
    Page<Board> findAll(Pageable pageable);
    BoardListResult getBoardListResult(Pageable pageable);
    Board insertS(Board board);
    Board updateS(Board board);
    Board ContentBoard(long seq);

    void deleteS(long seq);
}

