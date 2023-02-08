package com.example.library.controller;

import com.example.library.model.Library;
import com.example.library.service.LibraryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/library-app")
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping("/add-library")
    public void addLibrary(@RequestBody Library library) {
        libraryService.addLibrary(library);
    }

    @GetMapping("/find-library/id/{id}")
    public Library findById(@PathVariable int id) {
        return libraryService.findById(id);
    }

    @GetMapping("/find-all")
    public List<Library> findAllLibraries() {
        return libraryService.findAll();
    }

    @PutMapping("/update-library/id/{id}")
    public void updateLibrary(@PathVariable int id, @RequestBody Library library) {
        libraryService.updateLibrary(id, library);
    }

    @DeleteMapping("/delete-library/id/{id}")
    public void deleteLibrary(@PathVariable int id) {
        libraryService.deleteLibrary(id);
    }
}