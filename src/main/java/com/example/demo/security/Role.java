package com.example.demo.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    ADMIN(Set.of(Permissions.person_write,Permissions.person_read)),
    USER(Set.of(Permissions.person_read)),
    ;

    private Set<Permissions> permissionsSet;

     Role(Set<Permissions> permissionsSet) {
        this.permissionsSet=permissionsSet;
    }

    Set<SimpleGrantedAuthority>getAuthorities()
    {
        return permissionsSet.stream().map((permission)->new SimpleGrantedAuthority(permission.getPermission())).collect(Collectors.toSet());
    }
}
