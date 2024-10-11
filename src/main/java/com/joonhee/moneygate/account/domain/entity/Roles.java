package com.joonhee.moneygate.account.domain.entity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Roles {
    private List<Role> roles;

    public Roles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean contains(Role role) {
        return roles.contains(role);
    }

    public String listAsString() {
        return roles.stream()
            .map(Role::name)
            .collect(Collectors.joining(","));
    }

    public static Roles fromString(String rolesString) {
        List<Role> roles = Arrays.stream(rolesString.split(","))
            .map(Role::valueOf)
            .collect(Collectors.toList());
        return new Roles(roles);
    }
}
