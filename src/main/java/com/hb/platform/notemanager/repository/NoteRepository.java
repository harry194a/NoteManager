package com.hb.platform.notemanager.repository;

import com.hb.platform.notemanager.domain.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select note from Note note where note.user.id = :userId")
    List<Note> findByUserId(@Param("userId") Long userId);

    @Query("select note from Note note where note.text like %:search%")
    List<Note> noteSearch(@Param("search") String noteSearch);
}
