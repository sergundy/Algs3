package new_sem.lab_6;

import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {
    private long patHash;    // хеш-значение шаблона
    private int m;           // длина шаблона
    private long q;          // большое простое число
    private int R;           // переменная для хранения размера алфавита
    private long RM;         

    // Функция предварительно обрабатывает символьный массив шаблона
    public RabinKarp(char[] pattern, int R) {
        String.valueOf(pattern);
        this.R = R;        
    }

    // Функция предварительно обрабатывает строку шаблона
    public RabinKarp(String pat) {
        R = 256;
        m = pat.length(); // Передаём в переменную значение длины шаблона
        q = longRandomPrime(); // Передаём в переменную значение полученнов в методе longRandomPrime();

        // Предварительно вычисляем R ^ (m-1) % q для использования при удалении ведущей цифры
        RM = 1;
        for (int i = 1; i <= m-1; i++)
            RM = (R * RM) % q;
        patHash = hash(pat, m);
    } 

    // Вычисляем хэш для ключа [0..m-1] 
    private long hash(String key, int m) { 
        long h = 0; 
        for (int j = 0; j < m; j++) 
            h = (R * h + key.charAt(j)) % q;
        return h;
    }

    public boolean check(int i) {
    return true;
    }
 
    // Функция возвращает индекс первого вхождения строки шаблона в текстовой строке
    public int search(String txt) {
        int n = txt.length(); 
        if (n < m) return n;
        long txtHash = hash(txt, m); 

        // Проверяем совпадение по смещению 0
        if ((patHash == txtHash) && check(0))
            return 0;

        // В данном цикле проверяем совпадение хэша
        for (int i = m; i < n; i++) {

            // Удаляем начальную цифру, добавляем конечную цифру, проверяем соответствие 
            txtHash = (txtHash + q - RM*txt.charAt(i-m) % q) % q; 
            txtHash = (txtHash*R + txt.charAt(i)) % q; 

            // Если совпадает
            int offset = i - m + 1;
            if ((patHash == txtHash) && check(offset))
                return offset;
        }

        // Если не совпадает
        return n;
    }

    // Генерируем случайное 31-битное простое число
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random()); // Получаем 31-битное число с помощью утилиты random
        return prime.longValue();
    }
}

