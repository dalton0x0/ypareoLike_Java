package com.ypareolike.dtos;

import com.ypareolike.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleRequestDto {
    private Long id;
    private RoleType name;
}
