package hd.backend.repository;

import hd.backend.domain.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaOracleAddressRepository extends JpaRepository<Address, Long> {
    //extends JpaRepository<Address, Long> 에서 Long은 seq의 타입
    List<Address>  findByName(String name); //테이블 컬럼에 의존적인 select는 직접 만들어줘야 함
    //JPQL -> select a from Address a where a.name=:name
    List<Address>  findByNameAndAddr(String name, String addr); //And, Or,..
    List<Address> findByNameContaining(String name); //XXXContaining()은 like연산자 역할
    Page<Address> findByOrderBySeqDesc(Pageable pageable); //for 페이징
}
