package hd.backend.controller;

import hd.backend.domain.Address;
import hd.backend.service.AddressAjaxService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("rest_addr")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AddressRestController {
    private AddressAjaxService addressAjaxService;

    //(1) Create( insert )
    @PostMapping("create1")
    public void create1(Address address){//파라미터를 jsObj으로 받을 때
        //pln("@@AddressRestController create1() address: " + address);
        addressAjaxService.insertS(address);
    }
    //@GetMapping("create1")로 테스팅
    //http://127.0.0.1:8080/rest_addr/create1?name=오늘은&addr=수요일

    @PostMapping("create2")
    public void create2(@RequestBody Address address){//파라미터를 JSON으로 받을 때

        addressAjaxService.insertS(address);
    }
    //http://127.0.0.1:8080/rest_addr/create2
    //{"seq":-1, "name":"현동", "addr":"오예스"}
    //{"name":"현동2", "addr":"오예스2"}

    //(2) Read ( select )
    @GetMapping("read")
    public List<Address> read(){
        List<Address> list = addressAjaxService.listS();
        return list;
    }
    //http://127.0.0.1:8080/rest_addr/read
    @GetMapping("read/{seq}")
    public Address read(@PathVariable long seq){
        Address address = addressAjaxService.getBySeqS(seq);
        return address;
    }
    //http://127.0.0.1:8080/rest_addr/2

    @GetMapping(value="read",params = {"na"})
    public List<Address> read(@RequestParam("na") String name){
        List<Address> list =  addressAjaxService.getListByNames(name);
        return list;
    }
    //http://127.0.0.1:8080/rest_addr/read?na=홍

    //아래의 방법도 가능은 하지만.. @GetMapping("read/{seq}")와 공존할 순 없음
    /*@GetMapping("read/{na}")
    public List<Address> read(@PathVariable String na){
        List<Address> list = service.selectByNameS(na);
        return list;
    }*/
    //http://127.0.0.1:8080/rest_addr/read/홍

    @GetMapping("delete/{seq}")
    public void delete(@PathVariable long seq){

        addressAjaxService.deleteS(seq);
    }
    //http://127.0.0.1:8080/rest_addr/delete/8
    private void pln(String str){
        System.out.println(str);
    }
}
