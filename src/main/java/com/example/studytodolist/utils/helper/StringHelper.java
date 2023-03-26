package com.example.studytodolist.utils.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {
    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        // Видаляємо пробіли на початку та в кінці рядка
        str = str.trim();

        char firstChar = str.charAt(0);
        if (Character.isUpperCase(firstChar)) {
            // Перша літера вже велика, тому нічого робити не потрібно
            return str;
        }

        return Character.toUpperCase(firstChar) + str.substring(1);
    }
}
