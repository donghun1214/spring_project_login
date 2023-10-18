package com.example.demo.Repository;
import java.util.List;
import java.util.Optional;

import com.example.demo.Domain.BoardEntity;

import jakarta.persistence.EntityManager;

//<entity 값, key 자료형>
public class JpaBoardRepository {
    private final EntityManager em;
    public JpaBoardRepository(EntityManager em) {
        this.em = em;
    }

    public BoardEntity save(BoardEntity boardEntity){
        em.persist(boardEntity);
        return boardEntity;
    }

    public List<BoardEntity> findAll(){
        return em.createQuery("select m from BoardEntity m", BoardEntity.class)
                .getResultList();
    }

    public void updateHits(Long id) {
        em.createQuery("update BoardEntity b set b.boardHits = b.boardHits + 1 where b.id = :id")
            .setParameter("id", id)
            .executeUpdate();
    }

    public Optional<BoardEntity> findById(Long id) {
        BoardEntity boardEntity = em.find(BoardEntity.class, id);
        return Optional.ofNullable(boardEntity);
    }
    
}

