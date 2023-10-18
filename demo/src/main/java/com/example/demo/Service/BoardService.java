package com.example.demo.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.DTO.BoardDTO;
import com.example.demo.Domain.BoardEntity;
import com.example.demo.Repository.JpaBoardRepository;

import jakarta.transaction.Transactional;

@Transactional
public class BoardService {
    private final JpaBoardRepository boardRepository;
    public BoardService(JpaBoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public void save(BoardDTO boardDTO){
        BoardEntity boardEntity = BoardEntity.toBoardEntity(boardDTO);
        boardRepository.save(boardEntity);
    }

    public List<BoardDTO> findAll(){
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public void updateHits(Long id) {
        boardRepository.updateHits(id);
    }

    public BoardDTO findById(Long id) {
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            BoardEntity boardEntity = optionalBoardEntity.get();
            BoardDTO boardDTO = BoardDTO.toBoardDTO(boardEntity);
            return boardDTO;
        } else {
            return null;
        }
    }
}
