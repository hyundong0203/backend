package hd.backend.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Table(name="fileup")
@Entity
@SequenceGenerator(name="FILEUP_SEQ_GENERATOR", sequenceName = "FILEUP_SEQ", initialValue = 1, allocationSize = 1)
public class FileUp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FILEUP_SEQ_GENERATOR")
    @Column(name="file_id")
    private long id;
    private String orgnm;
    private String savednm;
    private String savedpath;

    @Builder
    public FileUp(long id, String orgnm, String savednm, String savedpath){
        this.id = id;
        this.orgnm = orgnm;
        this.savednm = savednm;
        this.savedpath = savedpath;
    }
}
