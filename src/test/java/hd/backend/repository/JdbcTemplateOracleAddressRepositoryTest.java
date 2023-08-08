package hd.backend.repository;

import hd.backend.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcTemplateOracleAddressRepositoryTest {
    @Autowired
    JdbcTemplateOracleAddressRepository repository;
    @Test
    void getRepository(){
        pln("#repository: "+ repository);
    }
    @Test
    void list() {
        List<Address> list = repository.list();
        pln("#list: "+ list);

    }
    @Test
    void insert() {
        Address address =  new Address(-1, "가", "나",null);
        Address addressDb = repository.insert(address);
        pln("#addressDb: "+ addressDb);
    }

    @Test
    void delete() {
        boolean flag = repository.delete(21);
        pln("#flag: "+flag);
    }
    void pln(String str){
        System.out.println(str);
    }
}