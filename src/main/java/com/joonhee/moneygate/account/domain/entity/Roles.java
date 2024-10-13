package com.joonhee.moneygate.account.domain.entity;

import com.joonhee.moneygate.account.domain.dto.RolesDto;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Roles {
    private List<Role> roles;

    public Roles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean contains(Role role) {
        return roles.contains(role);
    }

    public RolesDto toDto() {
        return new RolesDto(roles);
    }
}
