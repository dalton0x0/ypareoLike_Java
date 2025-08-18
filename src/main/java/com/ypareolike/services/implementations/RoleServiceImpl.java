package com.ypareolike.services.implementations;

import com.ypareolike.dtos.RoleRequestDto;
import com.ypareolike.dtos.RoleResponseDto;
import com.ypareolike.entities.Role;
import com.ypareolike.mappers.RoleMapper;
import com.ypareolike.repositories.RoleRepository;
import com.ypareolike.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(roleMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public RoleResponseDto getRoleById(Long id) {
        return roleRepository.findById(id)
                .map(roleMapper::convertEntityToDto)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
    }

    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        Role newRole = roleMapper.convertDtoToEntity(roleRequestDto);
        Role savedRole = roleRepository.save(newRole);
        return roleMapper.convertEntityToDto(savedRole);
    }

    @Override
    public void deleteRole(Long id) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found with id " + id));
        roleRepository.delete(existingRole);
    }
}
