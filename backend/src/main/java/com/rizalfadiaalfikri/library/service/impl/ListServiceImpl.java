package com.rizalfadiaalfikri.library.service.impl;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.rizalfadiaalfikri.library.dto.ListDto;
import com.rizalfadiaalfikri.library.entity.List;
import com.rizalfadiaalfikri.library.entity.User;
import com.rizalfadiaalfikri.library.repository.ListRepository;
import com.rizalfadiaalfikri.library.repository.UserRepository;
import com.rizalfadiaalfikri.library.service.ListService;

@Service
public class ListServiceImpl implements ListService {

    @Autowired
    private ListRepository listRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public java.util.List<com.rizalfadiaalfikri.library.entity.List> getAll() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByUsername(authentication.getName()).get();

        java.util.List<List> lists = listRepository.findByUserId(user.getId());
        return lists;
    }

    @Override
    public com.rizalfadiaalfikri.library.entity.List createList(ListDto dto) {

        List todoList = new List();
        todoList.setTitle(dto.getTitle());
        todoList.setDescription(dto.getDescription());
        todoList.setStatus(false);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByUsername(authentication.getName()).get();

        todoList.setUser(user);

        listRepository.save(todoList);

        return todoList;

    }

    @Override
    public List updateList(Long id, ListDto dto) {
        List list = listRepository.findById(id).get();

        if (list == null) {
            throw new RuntimeException("List Not found");
        }

        list.setTitle(dto.getTitle());
        list.setDescription(dto.getDescription());
        listRepository.save(list);

        return list;
    }

    @Override
    public List deleteList(Long id) {

        List list = listRepository.findById(id).get();

        listRepository.delete(list);

        return list;

    }

    @Override
    public List updateStatus(Long id) {
        List list = listRepository.findById(id).get();

        list.setStatus(true);

        return list;
    }

}
