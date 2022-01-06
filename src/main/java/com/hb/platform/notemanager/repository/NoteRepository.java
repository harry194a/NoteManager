package com.hb.platform.notemanager.repository;

import com.hb.platform.notemanager.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note,Long> {
}
