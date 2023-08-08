package hd.backend.mapper;

import hd.backend.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface BoardMapper {
    List<Board> list();
    Board selectBySeq(long seq);
    void insertSelectKey(Board board);
    Board contentSelectKey(long seq);

    void update_ok(Board board);

    void delete(long seq);

}
