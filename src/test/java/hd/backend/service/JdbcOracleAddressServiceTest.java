package hd.backend.service;

import hd.backend.domain.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JdbcOracleAddressServiceTest {
    @Autowired
    AddressService service;
    @Test
    void listS() {
        List<Address> list = service.listS();
        pln("@list: "+ list);
    }

    @Test
    void insertS() {
        Address address = new Address(-1, "수경","서울",null);
        Address addressDb =  service.insertS(address);
        pln("@addressDb: "+addressDb);
    }

    @Test
    void deleteS() {
        long seq = 9;
        boolean flag = service.deleteS(seq);
        pln("@flag: " + flag);
    }
    void pln(String str){
        System.out.println(str);
    }
}