package com.example.demo.DTO;

import java.time.LocalDateTime;

import com.example.demo.Domain.BoardEntity;

public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreatedTime;
    private LocalDateTime boardUpdatedTime;

    public LocalDateTime getBoardCreatedTime() {
        return this.boardCreatedTime;
    }

    public void setBoardCreatedTime(LocalDateTime boardCreatedTime) {
        this.boardCreatedTime = boardCreatedTime;
    }

    public LocalDateTime getBoardUpdatedTime() {
        return this.boardUpdatedTime;
    }

    public void setBoardUpdatedTime(LocalDateTime boardUpdatedTime) {
        this.boardUpdatedTime = boardUpdatedTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return this.boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContents() {
        return this.boardContents;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public int getBoardHits() {
        return this.boardHits;
    }

    public void setBoardHits(int boardHits) {
        this.boardHits = boardHits;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdatedTime(boardEntity.getUpdatedTime());
        
        return boardDTO;
    }
}
