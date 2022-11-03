package com.example.moodle.models;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    STUDENT(Set.of(Permission.DEVELOPERS_READ)), TEACHER(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));
    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissions().stream()
                .map(elem -> new SimpleGrantedAuthority(elem.getPermission())).collect(Collectors.toSet());
    }
}
