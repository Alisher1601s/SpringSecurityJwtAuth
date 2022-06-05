package com.example.demo.models;

public enum Permission {
	Doljnost_READ("doljnost:read"),
	Doljnost_WRITE("doljnost:write");
	private final String permission;
 Permission(String p)
{
	this.permission=p;
}
 
public String getPermission()
{
	return this.permission;
}

}
