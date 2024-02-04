package com.rizalfadiaalfikri.library.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rizalfadiaalfikri.library.dto.CreatedResponse;
import com.rizalfadiaalfikri.library.dto.HttpResponse;
import com.rizalfadiaalfikri.library.dto.ListDto;
import com.rizalfadiaalfikri.library.service.ListService;

@RestController
@RequestMapping("/api/list")
public class ListController {

    @Autowired
    private ListService listService;

    @GetMapping
    public ResponseEntity<HttpResponse> getAll() {
        List<com.rizalfadiaalfikri.library.entity.List> lists = listService.getAll();

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .status("true")
                        .message("success")
                        .data(lists)
                        .build());
    }

    @PostMapping("/add")
    public ResponseEntity<CreatedResponse> createlist(@RequestBody ListDto dto) {
        com.rizalfadiaalfikri.library.entity.List list = listService.createList(dto);

        return ResponseEntity.created(URI.create("")).body(
                CreatedResponse.builder()
                        .status("true")
                        .message("Created Success")
                        .data(list)
                        .build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CreatedResponse> updateList(@PathVariable("id") Long id, @RequestBody ListDto dto) {
        com.rizalfadiaalfikri.library.entity.List list = listService.updateList(id, dto);

        return ResponseEntity.created(URI.create("")).body(
                CreatedResponse.builder()
                        .status("true")
                        .message("Update Success")
                        .data(list)
                        .build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CreatedResponse> deleteList(@PathVariable("id") Long id) {
        com.rizalfadiaalfikri.library.entity.List list = listService.deleteList(id);

        return ResponseEntity.ok().body(
                CreatedResponse.builder()
                        .status("true")
                        .message("Delete Success")
                        .data(list)
                        .build());
    }

}
