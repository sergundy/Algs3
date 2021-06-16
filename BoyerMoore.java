package new_sem.lab_6;

public class BoyerMoore {
    private final int R;     // Переменная для хранения размера алфавита
    private int[] right;     // Массив для хранения первого вхождения

    private char[] pattern;  // Массив для хранения шаблона
    private String pat;      // Строка шаблона

    // Функция предварительно обрабатывает строку шаблона
    public BoyerMoore(String pat) {
        this.R = 256;
        this.pat = pat;

        // Позиция крайнего правого вхождения в шаблоне
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pat.length(); j++)
            right[pat.charAt(j)] = j;
    }

    // Функция предварительно обрабатывает массив шаблона
    public BoyerMoore(char[] pattern, int R) {
        this.R = R;
        this.pattern = new char[pattern.length];
        for (int j = 0; j < pattern.length; j++)
            this.pattern[j] = pattern[j];

        // Позиция крайнего правого вхождения в шаблоне
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < pattern.length; j++)
            right[pattern[j]] = j;
    }

    // Функция возвращает индекс первого вхождения строки шаблона в текстовой строке (эта функция работает со строкой)
    public int search(String txt) {
        int m = pat.length(); // Передаём в переменную значение длины строки шаблона
        int n = txt.length(); // Передаём в переменную значение длины строки текста
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i+j)) {
                    skip = Math.max(1, j - right[txt.charAt(i+j)]);
                    break;
                }
            }
            if (skip == 0) return i;    // Если найден
        }
        return n;                       // Если не найден
    }

    // Функция возвращает индекс первого вхождения строки шаблона в текстовой строке (эта функция работает с символьным массивом)
    public int search(char[] text) {
        int m = pattern.length; // Передаём в переменную значение размера массива шаблона
        int n = text.length; // Передаём в переменную значение размера массива текста
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m-1; j >= 0; j--) {
                if (pattern[j] != text[i+j]) {
                    skip = Math.max(1, j - right[text[i+j]]);
                    break;
                }
            }
            if (skip == 0) return i;    // Если найден
        }
        return n;                       // Если не найден
    }
}