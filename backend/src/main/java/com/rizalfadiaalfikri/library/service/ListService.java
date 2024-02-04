package com.rizalfadiaalfikri.library.service;

import java.util.List;

import com.rizalfadiaalfikri.library.dto.ListDto;

public interface ListService {
    List<com.rizalfadiaalfikri.library.entity.List> getAll();

    com.rizalfadiaalfikri.library.entity.List createList(ListDto dto);

    com.rizalfadiaalfikri.library.entity.List updateList(Long id, ListDto dto);

    com.rizalfadiaalfikri.library.entity.List deleteList(Long id);

    com.rizalfadiaalfikri.library.entity.List updateStatus(Long id);
}
