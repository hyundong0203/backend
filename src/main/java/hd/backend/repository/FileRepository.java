package hd.backend.repository;

import hd.backend.domain.FileUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileUp,Long> {

}
