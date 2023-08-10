package hd.backend.repository;

import hd.backend.domain.Address;
import hd.backend.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaOracleBoardRepository extends JpaRepository<Board,Long> {
    List<Board> findByseq(long seq);
    Board findBySeq(long seq);
//    List<Board> findByNameContaining(String name);
    Page<Board> findByOrderBySeqDesc(Pageable pageable);
}
