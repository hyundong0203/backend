package hd.backend.mapper;

import hd.backend.domain.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AddressMapper {
    List<Address> list();
    Address selectBySeq(long seq);
    void insertSelectKey(Address address);
    void delete(long seq);

}
