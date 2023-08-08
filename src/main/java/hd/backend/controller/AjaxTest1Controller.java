package hd.backend.controller;

import hd.backend.domain.Address;
import hd.backend.service.AddressAjaxService;
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
@RequestMapping("ajax1")
@Controller
public class AjaxTest1Controller {
    private AddressAjaxService addressAjaxService;

    @GetMapping("search1.do")
    public void search1(long seq, HttpServletResponse response){
        Address address = addressAjaxService.getBySeqS(seq);
        pln("#AjaxTest1Controller search1() address: " + address);

        String addressJson = null;
        if(address != null) {
            addressJson = "{\"seq\":"+address.getSeq()
                    +", \"name\":\""+address.getName()
                    +"\", \"addr\":\""+address.getAddr()
                    +"\", \"rdate\":\""+address.getRdate()
                    +"\"}";
        }

        try {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            pw.println(addressJson);
        }catch(IOException ie) {}
    }
    @PostMapping("search2.do")
    public void search2(String name, HttpServletResponse response) {
        List<Address> list = addressAjaxService.getListByNames(name);
        //pln("#AjaxTest1Controller search2() list: " + list);

        String addressJson = null;
        if (list.size() != 0) {
            addressJson = "[";
            for (Address address : list) {
                addressJson += "{\"seq\":" + address.getSeq()
                        + ", \"name\":\"" + address.getName()
                        + "\", \"addr\":\"" + address.getAddr()
                        + "\", \"rdate\":\"" + address.getRdate()
                        + "\"}";

                addressJson += ",";
            }
            addressJson = addressJson.substring(0, addressJson.length() - 1);
            addressJson += "]";
        } else {
            addressJson = "[]";
        }
    }
    public void pln(String str){
        System.out.println(str);
    }
}
