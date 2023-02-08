package com.example.library.service;

import com.example.library.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class LibraryService {
    private static List<Library> libraries=new ArrayList<>();
    private static int libraryCount=0;

    static {
        libraries.add(new Library(++libraryCount,"North Library ", "11 street", 123456, "Reading Rooms"));
        libraries.add(new Library(++libraryCount,"North Central Library ", "14 street", 654321, "Computer and Reading Rooms"));
        libraries.add(new Library(++libraryCount,"Peacefull Library", "10 street", 111111, "Childrens Section"));
        libraries.add(new Library(++libraryCount,"Eastern Library ", "19 street", 222222, "Community Area"));
        libraries.add(new Library(++libraryCount,"Western Library ", "15 street", 333333, "Launge and Reading Rooms"));
    }

    public List<Library> findAll() {
        return libraries;
    }

    public Library findById(int id) {
        for (Library library : libraries) {
            if (library.getId() == id) {
                return library;
            }
        }
        return null;
    }

    public Library addLibrary(Library library) {
        if (library.getId() == 0) {
            library.setId(++libraryCount);
        }
        libraries.add(library);
        return library;
    }

    public Library updateLibrary(int id, Library library) {
        int index = -1;
        for (int i = 0; i < libraries.size(); i++) {
            if (libraries.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return null;
        }
        library.setId(id);
        libraries.set(index, library);
        return library;
    }

    public void deleteLibrary(int id) {
        Library library = findById(id);
        if (library != null) {
            libraries.remove(library);
        }
    }
}