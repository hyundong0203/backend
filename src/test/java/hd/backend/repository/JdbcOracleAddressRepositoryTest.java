package hd.backend.repository;

import hd.backend.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcOracleAddressRepositoryTest {
    @Autowired
    JdbcOracleAddressRepository repository;
    @Test
    void testGetConnection() {
        pln("#repository: "+repository);
        pln("#con: "+repository.getConnection());
    }

    @Test
    void testList() {
        List<Address> list = repository.list();
        pln("#list: "+list);
    }

    @Test
    void testInsert() {
        Address address = new Address(-1L, "현주1","부산1",null);
        Address addressDb = repository.insert(address);
        pln("#addressDb: "+addressDb);
    }

    @Test
    void testDelete() {
        boolean flage = repository.delete(5);
                pln("#flage: "+ flage);
    }
    public void pln(String str){
        System.out.println(str);
    }
}