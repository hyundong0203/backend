package hd.backend.controller;


import hd.backend.domain.Address;
import hd.backend.service.AddressAjaxService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("auto")
@Controller
@AllArgsConstructor
public class AutoController {

    private AddressAjaxService addressAjaxService;
    @GetMapping("auto.do")
    public String showView(){
        return "auto/autocomplete";
    }
    @PostMapping("autoData.do")
    public @ResponseBody List<Address> getAddressList(@RequestParam("writer") String writer){
        System.out.println("@AutoController getAddressList() writer: " + writer);
        List<Address> list = addressAjaxService.getListByNames(writer);
        return list;
    }
}
