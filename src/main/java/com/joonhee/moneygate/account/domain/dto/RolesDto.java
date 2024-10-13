package com.joonhee.moneygate.account.domain.dto;

import com.joonhee.moneygate.account.domain.entity.Role;
import com.joonhee.moneygate.account.domain.entity.Roles;

import java.util.List;

public record RolesDto(
        List<Role> roles
) {
    public Roles toEntity() {
        return new Roles(roles);
    }
}
