import java.util.Scanner;

public class Lab1 {
    private String text;

    public Lab1(String text) {
        this.text = text;
    }

    public String[] extractWords(int length, boolean consonantStart) {
        // Используем регулярное выражение для разделения слов с учетом символов препинания
        String[] words = text.split("[\\s.!?:]+");  // Убрана запятая из разделителей
        StringBuilder resultBuilder = new StringBuilder();

        for (String word : words) {
            if (word.length() == length) {
                // Получаем первый символ слова и преобразуем его в нижний регистр
                char firstChar = Character.toLowerCase(word.charAt(0));
                // Проверяем, начинается ли слово с согласной или гласной в зависимости от параметра
                if ((consonantStart && isConsonant(firstChar)) ||
                        (!consonantStart && !isConsonant(firstChar))) {
                    // Добавляем слово к resultBuilder, используя запятую в качестве разделителя
                    resultBuilder.append(word).append(",");
                }
            }
        }

        // Преобразуем в строку и удаляем знаки препинания в конце
        String result = resultBuilder.toString().replaceAll("[.,]$", "");

        // Разделяем слова по запятой и возвращаем результат
        return result.split(",");
    }

    // Вспомогательный метод для проверки, является ли символ согласной буквой
    private boolean isConsonant(char ch) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        Lab1 wordScanner = new Lab1(text);

        System.out.println("Введите длину слова:");
        int length = scanner.nextInt();

        // Выводим слова, начинающиеся с согласной буквы, для указанной длины
        System.out.println("Слова, начинающиеся с согласной:");
        // Извлекаем и выводим слова, начинающиеся с согласной
        String[] result = wordScanner.extractWords(length, true);
        for (String word : result) {
            System.out.println(word);
        }

        // Выводим слова, начинающиеся с гласной буквы, для указанной длины
        System.out.println("Слова, начинающиеся с гласной:");
        // Извлекаем и выводим слова, начинающиеся с гласной
        result = wordScanner.extractWords(length, false);
        for (String word : result) {
            System.out.println(word);
        }
    }
}
