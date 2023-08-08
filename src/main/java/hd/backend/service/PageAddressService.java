package hd.backend.service;

import hd.backend.domain.Address;
import hd.backend.dto.AddressListResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PageAddressService {
    Page<Address> findAll(Pageable pageable);
    AddressListResult getAddressListResult(Pageable pageable);
    Address insertS(Address address);
    void deleteS(long seq);
}