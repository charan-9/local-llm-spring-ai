package com.local.project.local_llm_spring_ai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.local.project.local_llm_spring_ai.entity.ChatMessage;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySessionIdOrderByCreatedAtAsc(String SessionId);

    @Query("""
            SELECT c FROM ChatMessage c WHERE c.sessionId = :SessionId ORDER BY c.createdAt DESC LIMIT 10
            """)
    List<ChatMessage> findRecentMessages(String SessionId);

}
