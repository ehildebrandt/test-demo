package com.example.spock.demo_07_combinations;

import java.util.regex.Pattern;

public class ImageNameValidator {

    private final Pattern PATTERN = Pattern.compile("^\\w*.[j|J][p|P][e|E]?[g|G]$");

    public boolean isValidImageExtension(String imageExtension) {
        return PATTERN.matcher(imageExtension).matches();
    }

}
