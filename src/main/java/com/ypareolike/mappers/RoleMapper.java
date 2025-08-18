package com.ypareolike.mappers;

import com.ypareolike.dtos.RoleRequestDto;
import com.ypareolike.dtos.RoleResponseDto;
import com.ypareolike.entities.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleMapper {

    public Role convertDtoToEntity (RoleRequestDto roleRequestDto) {
        return Role.builder()
                .name(roleRequestDto.getName())
                .build();
    }

    public RoleResponseDto convertEntityToDto (Role role) {
        return RoleResponseDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
    }

    public void copyDtoToEntity (RoleRequestDto roleRequestDto, Role role) {
        role.setId(roleRequestDto.getId());
        role.setName(roleRequestDto.getName());
    }
}
