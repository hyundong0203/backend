package hd.backend.repository;

import hd.backend.domain.Board;


import java.util.List;


public interface BoardRepository {
    List<Board> list();
    Board insert(Board board);
    Board updateshow(long seq);


    Board update_ok(Board board);
    boolean delete(long seq);
}
