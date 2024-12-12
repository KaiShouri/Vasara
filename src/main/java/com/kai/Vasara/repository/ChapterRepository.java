package com.kai.Vasara.repository;

import com.kai.Vasara.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChapterRepository extends JpaRepository<Chapter, Long> {

    int countByStoryId(Long storyId);

    @Query("SELECT c FROM Chapter c WHERE c.storyId = :storyId and chapterNo = :chapterNo")
    Optional<Chapter> findByStoryIdAndNumberNo(Long storyId, Long chapterNo);
}
