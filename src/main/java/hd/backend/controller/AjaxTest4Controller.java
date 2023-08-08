package hd.backend.controller;

import hd.backend.domain.Address;
import hd.backend.service.AddressAjaxService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("ajax4")
@RestController  //String good이 나옴 view 페이지를 부를수없음
public class AjaxTest4Controller {
    private AddressAjaxService addressAjaxService;
    @GetMapping("search1.do")
    public Address search1(long seq){
        Address address = addressAjaxService.getBySeqS(seq);
        return address;
    }
    @PostMapping("search2.do")
    public List<Address> search2(String name){
        List<Address> list = addressAjaxService.getListByNames(name);
        return list;
    }

    @GetMapping("txt")
    public String getText(){ //template 을 리턴하는게아니라 String을 리턴함 jsp를 리턴하지않음
        return "good";
    }
}

