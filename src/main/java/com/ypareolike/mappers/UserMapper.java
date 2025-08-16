package com.ypareolike.mappers;

import com.ypareolike.dtos.UserRequestDto;
import com.ypareolike.dtos.UserResponseDto;
import com.ypareolike.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public User convertDtoToEntity (UserRequestDto userRequestDto) {
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .username(userRequestDto.getUsername())
                .email(userRequestDto.getEmail())
                .password(userRequestDto.getPassword())
                .build();
    }

    public UserResponseDto convertEntityToDto (User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    public void copyDtoToEntity (UserRequestDto userRequestDto, User user) {
        user.setFirstName(userRequestDto.getFirstName().trim());
        user.setLastName(userRequestDto.getLastName().trim());
        user.setUsername(userRequestDto.getUsername().trim());
        user.setEmail(userRequestDto.getEmail().trim());
        user.setPassword(userRequestDto.getPassword().trim());
    }
}
