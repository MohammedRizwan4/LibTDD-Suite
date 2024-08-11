package com.rizwan.utils;

import com.rizwan.User;

public class UserValidator {
    public static void validateUser(User user, String message) {
        if (user == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
