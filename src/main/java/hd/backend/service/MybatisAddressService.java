package hd.backend.service;

import hd.backend.domain.Address;
import hd.backend.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public class MybatisAddressService implements AddressService {
    //@Autowired
    private final AddressMapper mapper;
    //@Autowired
    public MybatisAddressService(AddressMapper mapper){
        this.mapper = mapper;
    }
    @Override
    public List<Address> listS() {
        pln("@listS() by mapper");
        return mapper.list();
    }
    @Override
    public Address insertS(Address address) {
        pln("@insertS() by mapper ");
        mapper.insertSelectKey(address); //db에서 만든거기때문에 sysdate가없음 rdate
        long seq = address.getSeq();
        pln("@insertS() address.getSeq(): "+ seq);
        address = mapper.selectBySeq(seq); // rdate가 추가됨
        pln("@insertS() address: "+ address);
        return address;
    }

    @Override
    public boolean deleteS(long seq) {
        pln("@deleteS() by mapper ");
        mapper.delete(seq);

        return true;  //의미없는 true
    }
    private void pln(String str){
        System.out.println(str);
    }
}
