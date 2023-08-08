package hd.backend.controller;

import hd.backend.domain.Address;
import hd.backend.dto.AddressListResult;
import hd.backend.service.PageAddressService;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@RequestMapping("address_page")
@Controller
public class PageAddressController {
    private final PageAddressService service; //AutoInjection

    @GetMapping("list.do")
    public String list(@PageableDefault(size=3, sort="seq", direction= Sort.Direction.DESC) Pageable pageable,
                       Model model){
        AddressListResult listResult = service.getAddressListResult(pageable);
        model.addAttribute("listResult", listResult);
        return "/address_page/list";
    }
    @GetMapping("write.do")
    public String write(){
        return "/address_page/write";
    }
    @PostMapping("write.do")
    public String write(Address address){
        service.insertS(address);
        return "redirect:list.do";
    }
    @GetMapping("del.do")
    public String delete(long seq, ServletContext application, HttpSession session,
                         HttpServletRequest request, Object page, HttpServletResponse response){
        //pln("@@application: " + application); //Auto Injection불가!!
        application = session.getServletContext();
        pln("##application: " + application);
        pln("@@session: " + session);
        pln("@@request: " + request);
        pln("@@page: " + page);
        pln("@@response: " + response);

        service.deleteS(seq);
        return "redirect:list.do";
    }

    void pln(String str){
        System.out.println(str);
    }
}

