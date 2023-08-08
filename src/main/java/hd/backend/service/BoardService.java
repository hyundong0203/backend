package hd.backend.service;

import hd.backend.domain.Board;

import java.util.List;

public interface BoardService {
    List<Board> listS();
    Board insertS(Board board);
    Board update_ok(Board board);
    Board updateshow(long seq);

    boolean deleteS(long seq);
}
