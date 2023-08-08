package hd.backend.controller;

import hd.backend.domain.Address;
import hd.backend.service.AddressAjaxService;
import hd.backend.service.AddressAjaxServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@AllArgsConstructor
@RequestMapping("ajax3")
@Controller
public class AjaxTest3Controller {
    private AddressAjaxService addressAjaxService;
    @GetMapping("search1.do")
    @ResponseBody
    public Address serach1(long seq){
        Address address = addressAjaxService.getBySeqS(seq);
        return address;
    }
    @PostMapping("serach2.do")
    @ResponseBody
    public List<Address> serach2(String name){
        List<Address> list = getListByNames(name);
        return list;
    }

    private List<Address> getListByNames(String name) {
        return addressAjaxService.getListByNames(name);
    }

//    @GetMapping("test.do")
//    public String test(){
//        return "/index"; //XXX.jsp
//    }
}
