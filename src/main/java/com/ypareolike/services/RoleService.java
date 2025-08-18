package com.ypareolike.services;

import com.ypareolike.dtos.RoleRequestDto;
import com.ypareolike.dtos.RoleResponseDto;

import java.util.List;

public interface RoleService {
    List<RoleResponseDto> getAllRoles();
    RoleResponseDto getRoleById(Long id);
    RoleResponseDto createRole(RoleRequestDto roleRequestDto);
    void deleteRole(Long id);
}
