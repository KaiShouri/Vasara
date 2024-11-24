package com.kai.Vasara.controller;

import com.kai.Vasara.entity.Chapter;
import com.kai.Vasara.model.ChapterDAO;
import com.kai.Vasara.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    private final ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Chapter>> getChapters() {
        return new ResponseEntity<>(chapterService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getChapter(@PathVariable Long id) {
        return new ResponseEntity<>(chapterService.getChapter(id), HttpStatus.OK);
    }

    @GetMapping("/read/{storyId}/{chapterNo}")
    public ResponseEntity<ChapterDAO> getChapterByStoryAndNumber(@PathVariable Long storyId, @PathVariable Long chapterNo) {
        return new ResponseEntity<>(chapterService.getChapterByStoryIdAndNumber(storyId, chapterNo), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Boolean> addChapter(@RequestBody Chapter chapter) {
        return new ResponseEntity<>(chapterService.saveChapter(chapter), HttpStatus.OK);
    }
}