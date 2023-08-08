package hd.backend.controller;

import hd.backend.domain.Board;
import hd.backend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("board")
@Controller
public class BoardController {
    @Autowired
    private BoardService service;

    @GetMapping("list.do")
    public String list(Model model){
        List<Board> list = service.listS();
        model.addAttribute("list", list);
        return "/board/list";
    }
    @GetMapping("write.do")
    public String write(){
        return "/board/write";
    }
    @PostMapping("write.do")
    public String write(Board board){
        service.insertS( board );
        return "redirect:list.do";
    }
    @GetMapping("del.do")
    public String delete(long seq){
        service.deleteS(seq);
        return "redirect:list.do";
    }
    @GetMapping("content.do")
    public String updateshow(long seq, Model model){
        Board board = service.updateshow(seq);
        model.addAttribute("board", board);
        return "/board/content";
    /*}
    @GetMapping("update_ok")
    public String update_ok(long seq, Model model) {
        Board board = service.updateshow(seq);
        model.addAttribute("content", board);
        return "/board/update";*/
    }
    @GetMapping("update.do")
    public String updatelist(long seq,Model model){
        Board board = service.updateshow(seq);
        model.addAttribute("board",board);
        return "/board/update";
    }
    @PostMapping("update.do")
    public String update_ok(Board board){
        service.update_ok( board);
        return "redirect:list.do";
    }
}

