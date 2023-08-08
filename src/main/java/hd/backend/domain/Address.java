package hd.backend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name="ADDRESS_SEQ_GENERATOR",sequenceName = "ADDRESS_SEQ", initialValue = 1, allocationSize = 1)
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ADDRESS_SEQ_GENERATOR")
    private long seq;
    //@Column(name="username1")  //DB컬럼이름이 username1 일경우 바꾸는 법
    private String name;
    private String addr;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = "Asia/Seoul")
    @CreationTimestamp // 추가
    private Date rdate;
}
