package hd.backend.controller;


import hd.backend.domain.Board;

import hd.backend.dto.BoardListResult;
import hd.backend.service.PageBoardService;
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
@RequestMapping("board_page")
@Controller
public class PageBoardController {
    private final PageBoardService service;

    @GetMapping("list.do")
    public String list(@PageableDefault(size=3, sort="seq", direction= Sort.Direction.DESC) Pageable pageable,
                       Model model){
        BoardListResult listResult = service.getBoardListResult(pageable);
        model.addAttribute("listResult", listResult);
        return "/board_page/list";
    }
    @GetMapping("write.do")
    public String write(){
        return "/board_page/write";
    }
    @PostMapping("write.do")
    public String write(Board board){
        service.insertS(board);
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