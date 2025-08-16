package com.ypareolike.services.implementations;

import com.ypareolike.dtos.UserRequestDto;
import com.ypareolike.dtos.UserResponseDto;
import com.ypareolike.entities.User;
import com.ypareolike.mappers.UserMapper;
import com.ypareolike.repositories.UserRepository;
import com.ypareolike.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public UserResponseDto getUserById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::convertEntityToDto)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        User newUser = userMapper.convertDtoToEntity(userRequestDto);
        User savedUser = userRepository.save(newUser);
        return userMapper.convertEntityToDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
        userMapper.copyDtoToEntity(userRequestDto, existingUser);
        User updatedUser = userRepository.save(existingUser);
        return userMapper.convertEntityToDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
