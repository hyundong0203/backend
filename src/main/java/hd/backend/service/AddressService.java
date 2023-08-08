package hd.backend.service;

import hd.backend.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> listS();
    Address insertS(Address address);
    boolean deleteS(long seq);
}
