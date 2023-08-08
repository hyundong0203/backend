package hd.backend.repository;

import hd.backend.domain.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> list();
    Address insert(Address address);
    boolean delete(long seq);
}

