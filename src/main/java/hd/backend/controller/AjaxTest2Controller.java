package hd.backend.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hd.backend.domain.Address;
import hd.backend.service.AddressAjaxService;
import hd.backend.service.AddressAjaxServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@AllArgsConstructor
@RequestMapping("ajax2")
@Controller
public class AjaxTest2Controller {
    private AddressAjaxService addressAjaxService;
    @GetMapping("search1.do")
    public void search1(long seq, HttpServletResponse response){
        Address address = addressAjaxService.getBySeqS(seq);
        //pln("#AjaxTest1Controller search1() address: " + address);

        ObjectMapper om = new ObjectMapper();
        try{
            String addressJson = om.writeValueAsString(address);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println(addressJson);
        }catch(JsonProcessingException je){
        }catch(IOException ie){}
    }
    @PostMapping("search2.do")
    public void search2(String name, HttpServletResponse response){
        List<Address> list = addressAjaxService.getListByNames(name);
        //pln("#AjaxTest1Controller search2() list: " + list);

        ObjectMapper om = new ObjectMapper();
        try {
            String addressJson = om.writeValueAsString(list);
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println(addressJson);
        }catch(JsonProcessingException je) {
        }catch(IOException ie) {}
    }

    void pln(String str){
        System.out.println(str);
    }
}
