package com.hb.platform.notemanager.repository;

import com.hb.platform.notemanager.domain.note.Note;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends PagingAndSortingRepository<Note, Long> {
   // select * from note  where note.user_id = 2 limit 4 offset 10;

   @Query(value = "select * from note where note.user_id=:id limit :limit offset :offset;", nativeQuery = true)
   List<Note> findByUserIdAndPagination(@Param("id")Long id,@Param("offset") Long offset,@Param("limit")Long limit);

    @Query("select note from Note note where note.user.id = :userId")
    List<Note> findByUserId(@Param("userId") Long userId);

    @Query("select note from Note note where note.text like %:search%")
    List<Note> noteSearch(@Param("search") String noteSearch);

    @Query(value = "select * from note_manager.note  where note.user_id = :userId and" +
 " text like %:search% limit :limit offset :offset ;", nativeQuery = true)
    List<Note> noteSearchId(@Param("userId") Long id,@Param("search") String noteSearch,
                            @Param("limit")Long limit,@Param("offset")Long offset);
//
}
