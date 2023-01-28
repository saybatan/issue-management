package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);
    User getById(Long id);
    Page<User> getAllPageable(Pageable pageable);
    Boolean delete(User user);
    User getByUsername(String username);

}