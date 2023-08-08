package hd.backend.service;

import hd.backend.domain.Address;
import hd.backend.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public class JdbcOracleAddressService implements AddressService {

    private final AddressRepository repository;

    public JdbcOracleAddressService(AddressRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Address> listS() {
        return repository.list();
    }

    @Override
    public Address insertS(Address address) {

        return repository.insert(address);
    }

    @Override
    public boolean deleteS(long seq) {

        return repository.delete(seq);
    }
}
