package hd.backend.controller;

import hd.backend.service.BoardService;
import hd.backend.domain.Board;
import hd.backend.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("rest_board")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class BoardRestController {

    private BoardService boardService;

    @PostMapping("create1")
    public void create1(Board board){//파라미터를 jsObj으로 받을 때

        boardService.insertS(board);
    }
    @PostMapping("create2")
    public void create2(@RequestBody Board board){//파라미터를 JSON으로 받을 때

        boardService.insertS(board);
    }
    @GetMapping("read")
    public List<Board> read(){
        List<Board> list = boardService.listS();
        return list;
    }
    @GetMapping("read/{seq}")
    public Board read(@PathVariable long seq){
        Board board = boardService.updateshow(seq);
        return board;
    }
    @GetMapping("delete/{seq}")
    public boolean deleteS(@PathVariable long seq){
        boardService.deleteS(seq);
        return true;
    }

}
