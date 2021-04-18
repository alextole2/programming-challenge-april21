package com.movies.api.imports.controller;

import com.movies.api.imports.service.ImportService;
import liquibase.pro.packaged.T;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Inject
    private ImportService importService;

    @PostMapping
    public ResponseEntity<T> importFrom(@RequestParam("file") MultipartFile file) {
        importService.fillDataBaseFrom(file);
        return ResponseEntity.noContent().build();
    }
}
