package com.saybatan.issuemanagement.service.impl;

import com.saybatan.issuemanagement.dto.PasswordChangeDTO;
import com.saybatan.issuemanagement.dto.UserCreateDTO;
import com.saybatan.issuemanagement.dto.UserDTO;
import com.saybatan.issuemanagement.dto.UserSaveDTO;
import com.saybatan.issuemanagement.entity.User;
import com.saybatan.issuemanagement.repository.UserRepository;
import com.saybatan.issuemanagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO update(Long id, UserSaveDTO userSaveDTO) {
        User user = userRepository.getOne(id);
        user.setNameSurname(userSaveDTO.getNameSurname());
        user.setEmail(userSaveDTO.getEmail());
        user.setPassword(userSaveDTO.getPassword());
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO save(UserCreateDTO userCreateDTO) throws Exception {
        User user = modelMapper.map(userCreateDTO, User.class);
        if (userRepository.findByUsername(userCreateDTO.getUsername()) != null) {
            throw new Exception("Bu userName alınmış!");
        }
        user = userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepository.getOne(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public Page<UserDTO> getAllPageable(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        userRepository.delete(user);
        return Boolean.TRUE;
    }

    @Override
    public UserDTO getByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return modelMapper.map(user, UserDTO.class);
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return Arrays.asList(modelMapper.map(users, UserDTO[].class));
    }

    public Boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    public Boolean changePassword(Long userId, PasswordChangeDTO passwordChangeDTO) throws Exception {
        User user = userRepository.getOne(userId);
        if (!user.getPassword().equals(passwordChangeDTO.getOldPassword())) {
            throw new Exception("Eski şifre hatalı!");
        }
        if (user.getPassword().equals(passwordChangeDTO.getNewPassword())) {
            throw new Exception("Yeni şifre eskisiyle aynı olamaz");
        }
        if (!passwordChangeDTO.getNewPassword().equals(passwordChangeDTO.getNewPasswordAgain())) {
            throw new Exception("Yeni şifre uyumsuz!");
        }
        user.setPassword(passwordChangeDTO.getNewPassword());
        userRepository.save(user);
        return true;
    }
}
