package hd.backend.service;

import hd.backend.domain.Address;
import hd.backend.repository.SpringDataJpaOracleAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class SpringDataJpaAddressService implements AddressService {
    //@Autowired
    private final SpringDataJpaOracleAddressRepository repository;
    //@Autowired
    public SpringDataJpaAddressService(SpringDataJpaOracleAddressRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Address> listS() {
        pln("@listS() by SpringDataJpa");
        return repository.findAll(Sort.by(Sort.Direction.DESC,"seq"));
    }
    @Override
    public Address insertS(Address address) {
        pln("@insertS() by SpringDataJpa");
        address = repository.save(address);
        pln("@insertS() by SpringDataJp address: " + address);
        return address;
    }

    @Override
    public boolean deleteS(long seq) {
        pln("@deleteS() by SpringDataJpa");
        repository.deleteById(seq);
        return true;
    }
    public List<Address> findByName(String name){
        List<Address> list = repository.findByName(name);
        pln("@findByName() by SpringDataJpa list: " + list);
        return list;
    }
    public List<Address> findByNameAndAddr(String name, String addr){
        List<Address> list = repository.findByNameAndAddr(name, addr);
        pln("@findByNameAndAddr() by SpringDataJpa list: " + list);
        return list;
    }
    public List<Address> findByNameContaining(String name){
        List<Address> list = repository.findByNameContaining(name);
        pln("@findByNameContaining() by SpringDataJpa list: " + list);
        return list;
    }
    void pln(String str){
        System.out.println(str);
    }
}
