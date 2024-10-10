package com.joonhee.moneygate.account.exception;

import com.joonhee.moneygate.account.domain.entity.Role;

import java.util.List;

public class InvalidUserPermission extends IllegalArgumentException {
    public InvalidUserPermission(List<Role> hasRole, Role requiredRole) {
        super("사용자 권한이 유효하지 않습니다. | hasRole: " + hasRole + "| requiredRole:" + requiredRole);
    }
}
