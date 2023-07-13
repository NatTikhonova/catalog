package com.example.demo.models;

import java.util.regex.Pattern;

public class FormCheck {
    public final static String EMAIL_RULE = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+" +
            "@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    public final static String NUMBER_RULE = "^\\+79\\d{9}$";
    public final static String PASSWORD_RULE = "^[\\da-zA-Z!@#$%^&*]{6,}$";
    public final static String NAME_RULE = "^[a-zа-яA-ZА-Я]+$";

    public static boolean isSuccessCheck(String rule, String text) {
        return Pattern.compile(rule, Pattern.CASE_INSENSITIVE).matcher(text).matches();
    }
}
