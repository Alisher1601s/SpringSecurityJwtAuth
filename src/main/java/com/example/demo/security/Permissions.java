package com.example.demo.security;

public enum Permissions {
    person_read("person:read"),
    person_write("person:write");
    private String permission;

    Permissions(String permission) {
        this.permission=permission;
    }
    public String getPermission()
    {
        return this.permission;
    }
}
