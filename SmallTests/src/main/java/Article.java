import java.util.HashSet;

public class Article {
    /**
     * Хранилище слов.
     */
    private static HashSet<String> hashSet;

    /**
     * Метод проверки соответствия старого и нового текста.
     *
     * @param oldText старый текст.
     * @param newText новый текст.
     * @return соответствие.
     */
    public static boolean generateBy(String oldText, String newText) {
        hashSet = new HashSet<>();
        addOldTextToSet(oldText);
        return validateNewText(newText);
    }

    /**
     * Добавить слова из старого текста в хранилищею
     *
     * @param oldText старый текст.
     */
    private static void addOldTextToSet(String oldText) {
        String[] arr = oldText.split("(?U)\\W+");
        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
    }

    /**
     * Проверка на присутствие всех слов из нового текста в старом.
     *
     * @param newText новый текст.
     * @return соответствие.
     */
    private static boolean validateNewText(String newText) {
        boolean isValid = true;
        String[] newTextArr = newText.split("(?U)\\W+");
        for (int i = 0; i < newTextArr.length; i++) {
            if (hashSet.add(newTextArr[i])) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }
}
