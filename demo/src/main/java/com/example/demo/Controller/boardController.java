package com.example.demo.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.DTO.BoardDTO;
import com.example.demo.Service.BoardService;

@Controller
@RequestMapping("/board")
public class boardController {
    private final BoardService boardService;
    public boardController(BoardService boardService) {

        this.boardService = boardService;

    }

    @GetMapping("/main")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList", boardDTOList);
        System.out.println("hello0115");
        return "board/main";
    }

    @GetMapping("/write")
    public String write(){
        return "board/write";
    }

    @PostMapping("/write")
    public String write(BoardDTO boardDTO){
        boardService.save(boardDTO);
        return "board/main";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model){
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        
        return "board/view";
    }
}
