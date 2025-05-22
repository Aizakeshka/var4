package com.example.var4;

import javafx.fxml.FXML;

import java.util.Random;

public class CharacterGenerator {
    private static final String[] maleNames = {"Артур", "Борис", "Влад", "Глеб", "Данила", "Егор"};
    private static final String[] femaleNames = {"Алина", "Белла", "Вера", "Галина", "Диана", "Ева"};

    private static final String[] races = {"Человек", "Эльф", "Орк", "Гном", "Демон", "Нежить"};
    private static final String[] classes = {"Воин", "Маг", "Ассасин", "Лучник", "Жрец", "Варвар", "Некромант"};
    private static final String[] genders = {"Мужской", "Женский"};

    private static final Random random = new Random();

    public static int random(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    @FXML
    public static String randomName(String gender) {
        if ("Женский".equals(gender)) {
            return femaleNames[random.nextInt(femaleNames.length)];
        } else {
            return maleNames[random.nextInt(maleNames.length)];
        }
    }

    public static Character generateRandomCharacter() {
        String gender = genders[random.nextInt(genders.length)];
        String name = randomName(gender);
        String race = races[random.nextInt(races.length)];
        String clazz = classes[random.nextInt(classes.length)];
        int level = random(1, 50);

        return new Character(
                name,
                gender,
                race,
                clazz,
                random(1, 20),
                random(1, 20),
                random(1, 20),
                random(1, 20),
                random(1, 20),
                random(1, 10),
                level
        );
    }
}
