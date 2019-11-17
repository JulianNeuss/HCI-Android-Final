package com.example.hciandroid.ui.security;

public class SecurityAdapter {
    private static final SecurityAdapter ourInstance = new SecurityAdapter();

    public static SecurityAdapter getInstance() {
        return ourInstance;
    }

    private SecurityAdapter() {
    }
}
