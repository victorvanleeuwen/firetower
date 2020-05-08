package com.firetower.auth_service.common.security;

import com.google.common.collect.Sets;

import java.util.Set;
import java.util.stream.Collectors;

import static com.firetower.auth_service.common.security.UserPermissions.USER_READ;
import static com.firetower.auth_service.common.security.UserPermissions.USER_WRITE;


public enum UserRole {
    // ADD all the user roles you want, and bind them to the permissions you defined.
    USER(Sets.newHashSet(USER_READ)),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<UserPermissions> permissions;

    UserRole(Set<UserPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermissions> getPermissions() {
        return permissions;
    }

    public Set<CustomGrantedAuthority> getGrantedAuthorities(){
        Set<CustomGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new CustomGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new CustomGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
