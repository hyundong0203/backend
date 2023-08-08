package hd.backend.service;

import hd.backend.domain.Address;
import hd.backend.dto.AddressListResult;
import hd.backend.repository.SpringDataJpaOracleAddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//@Transactional(readOnly = true) //DML커밋을 막음
@Transactional
@RequiredArgsConstructor
@Service
public class SpringDataJpaPageAddressService implements PageAddressService {
    @Autowired
    private final SpringDataJpaOracleAddressRepository repository;

    @Override
    public Page<Address> findAll(Pageable pageable) {
        pln("@findAll() pageable: " + pageable);
        return repository.findByOrderBySeqDesc(pageable);
    }
    @Override
    public AddressListResult getAddressListResult(Pageable pageable) {
        Page<Address> list = findAll(pageable);
        int page = pageable.getPageNumber();
        long totalCount = repository.count();
        int size = pageable.getPageSize();
        pln("@getAddressListResult() page: "
                +page+", totalCount: "+totalCount+", size: "+size);

        return new AddressListResult(page, totalCount, size, list);
    }
    @Override
    public Address insertS(Address address) {
        address = repository.save(address);
        return address;
    }
    @Override
    public void deleteS(long seq) {
        repository.deleteById(seq);
    }

    void pln(String str){
        System.out.println(str);
    }
}

