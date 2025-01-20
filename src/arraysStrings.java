package src;

import java.util.*;

public class arraysStrings {
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^а-яА-Я]", "").toLowerCase();
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    public static int countCharacters(String str, char[] chars) {
        int count = 0;
        for (char c : str.toCharArray()) {
            for (char target : chars) {
                if (c == target) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static String removeDuplicates(String str) {
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static String replaceSubstring(String str, String target, String replacement) {
        return str.replace(target, replacement);
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static void printStringsWithLengths(String[] strings) {
        for (String str : strings) {
            System.out.println("Строка: \"" + str + "\", длина: " + str.length());
        }
    }

    public static String[] generateRandomStrings(int size, int maxLength, double emptyProbability) {
        Random random = new Random();
        String[] strings = new String[size];
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < size; i++) {
            if (random.nextDouble() < emptyProbability) {
                strings[i] = "";
            } else {
                int length = random.nextInt(maxLength) + 1;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < length; j++) {
                    char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
                    sb.append(randomChar);
                }
                strings[i] = sb.toString();
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        System.out.println("1. Короткие и длинные строки");
        String[] strings = {
                "Менеджер, программист и тестировщик попали в ДТП, несясь с горы, из-за отказа тормозов",
                "Менеджер предложил сформировать группу обсуждения проблемы с тормозами",
                "Программист предложил проверить каждый винтик",
                "Тестировщик предложил затолкать машину в гору и повторить баг"
        };
        printStringsWithLengths(strings);
        String longest = strings[0];
        String shortest = strings[0];
        for (String str : strings) {
            if (str.length() > longest.length()) {
                longest = str;
            }
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }
        System.out.println("Самая длинная строка: \"" + longest + "\" Длина: " + longest.length());
        System.out.println("Самая короткая строка: \"" + shortest + "\" Длина: " + shortest.length());

        System.out.println("\n2. Обратный порядок");
        for (String str1 : strings) {
            System.out.println("Строка: " + str1 + "\nСтрока в обратном порядке: " + reverseString(str1) + "\n ");
        }

        System.out.println("\n3.Палиндром");
        String[] palindromeStrings = {
                "Ежу хуже",
                "Лев осовел",
                "Кошмар, срам, шок",
                "Кирилл лирик"
        };
        for (String str2 : palindromeStrings) {
            System.out.println("\"" + str2 + "\"" + (isPalindrome(str2) ? " является палиндромом"
                    : " не является палиндромом"));
        }

        System.out.println("\n4. Массив строк");
        char[] vowels = "аеёиоуыэюяАЕЁИОУЫЭЮЯ".toCharArray();
        for (String str3 : strings) {
            int vowelCount = countCharacters(str3, vowels);
            System.out.println("Строка: \"" + str3 + "\"");
            System.out.println("Количество гласных: " + vowelCount);
            System.out.println("Верхний регистр: " + str3.toUpperCase());
            System.out.println("Нижний регистр: " + str3.toLowerCase());
        }

        System.out.println("\n5. Массив с ФИО");
        String[] names = {
                "Синица Дарья Владимировна",
                "Барсук Александр Владимирович",
                "Шевченко Евгения Николаевна",
                "Беккер Лилия Александровна",
                "Жирякова Арина Александровна",
                "Ушакова Светлана Александровна",
                "Милковский Роман Николаевич",
                "Агафонов Дмитрий Дмитриевич",
                "Гордеева Дарья Анатольевна",
                "Шишляков Никита Евгеньевич"
        };
        Arrays.sort(names);
        System.out.println("ФИО в алфавитном порядке:");
        for (String name : names) {
            System.out.println(name);
        }
        System.out.println("\nФамилии + инициалы:");
        for (String name : names) {
            String[] parts = name.split(" ");
            System.out.printf("%s %c.%c.%n", parts[0], parts[1].charAt(0), parts[2].charAt(0));
        }
        System.out.println("\nФамилии, начинающиеся с гласных:");
        for (String name : names) {
            String[] parts = name.split(" ");
            String surname = parts[0];
            char firstChar = name.charAt(0);
            if ("АЕЁИОУЫЭЮЯаеёиоуыэюя".indexOf(firstChar) != -1) {
                System.out.println(surname);
            }
        }
        System.out.println("\nИмена, заканчивающиеся на согласные:");
        for (String name : names) {
            String[] parts = name.split(" ");
            String firstName = parts[1];
            char lastChar = parts[1].charAt(parts[1].length() - 1);
            if ("БВГДЖЗЙКЛМНПРСТФХЦЧШЩбвгджзйклмнпрстфхцчшщ".indexOf(lastChar) != -1) {
                System.out.println(firstName);
            }
        }
        System.out.println("\nФИО без повторяющихся символов:");
        for (String name : names) {
            System.out.println(removeDuplicates(name));
        }

        System.out.println("\n6. Строки и массив слов");
        String sentence = "Зима в этом году снежная и теплая";
        String[] words = sentence.split(" ");
        System.out.println("Строка: \"" + sentence + "\"" + "\nСлова: " + Arrays.toString(words)
                + "\nКоличество слов: " + words.length);

        System.out.println("\n7. Пустые строки");
        int arraySize = 10;
        int maxStringLength = 10;
        double emptyStringProbability = 0.5;
        String[] randomStrings = generateRandomStrings(arraySize, maxStringLength, emptyStringProbability);
        System.out.println("Оригинальный массив:" + Arrays.toString(randomStrings));
        System.out.println("Позиции пустых строк:");
        for (int i = 0; i < randomStrings.length; i++) {
            if (randomStrings[i].isEmpty()) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("\n8. StringBuilder");
        String[] exampleStrings = {
                "Я у мамы программист",
                "Ежу хорошо",
                "Тестировщик предложил затолкать машину в гору и повторить баг"
        };
        for (String str4 : exampleStrings) {
            System.out.println("Оригинал: " + str4);
            System.out.println("С _ вместо пробелов: " + replaceSubstring(str4, " ", "_"));
        }
    }
}