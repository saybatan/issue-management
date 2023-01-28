package com.saybatan.issuemanagement.service;

import com.saybatan.issuemanagement.dto.UserDTO;
import com.saybatan.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserDTO save(UserDTO userDTO);
    UserDTO getById(Long id);
    Page<UserDTO> getAllPageable(Pageable pageable);
    Boolean delete(UserDTO userDTO);
    UserDTO getByUsername(String username);

}
