package new_sem.lab_6;

// Объявляем строки шаблонов и строки текстов в качестве аргуметов,далее объявляем символьные массивы и передаём в них ранее введёные данные, затем ищем строки шаблона в текстовых строках, и выводим первые вхождения шаблона в текстовых строках
public class test {
    public static void main(String[] args) {

        String pat = "AAB";
        String pat2 = "DAA";

        String txt = "AABAACAADAABAABA";
        String txt2 = "AABAACAADAABAABA";

        char[] pattern = pat.toCharArray(); // Переводим первую строку шаблона в массив чаров
        char[] pattern2 = pat2.toCharArray(); // Переводим вторую строку шаблона в массив чаров

        char[] text = txt.toCharArray(); // Переводим первую строку текста в массив чаров
        char[] text2 = txt2.toCharArray(); // Переводим втроую строку текста в массив чаров

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Бойера-Мура: \n");
        
        BoyerMoore boyermoore = new BoyerMoore(pattern, 256);
        BoyerMoore boyermoore2 = new BoyerMoore(pattern2, 256);

        int offset1 = boyermoore.search(text);
        int offset1_2 = boyermoore2.search(text2);

        System.out.println("Текст:  " + txt);

        System.out.print("Шаблон: ");
        for (int i = 0; i < offset1; i++)
            System.out.print(" ");
        System.out.println(pat);

        System.out.println();

        System.out.println("Текст:  " + txt2);

        System.out.print("Шаблон: ");
        for (int i = 0; i < offset1_2; i++)
            System.out.print(" ");
        System.out.println(pat2);

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Рабина-Карпа: \n");

        RabinKarp rabinkarp = new RabinKarp(pat);
        RabinKarp rabinkarp2 = new RabinKarp(pat2);

        int offset2 = rabinkarp.search(txt);
        int offset2_2 = rabinkarp2.search(txt2);

        System.out.println("Текст:  " + txt);

        System.out.print("Шаблон: ");
        for (int i = 0; i < offset2; i++)
            System.out.print(" ");
        System.out.println(pat);

        System.out.println();

        System.out.println("Текст:  " + txt2);

        System.out.print("Шаблон: ");
        for (int i = 0; i < offset2_2; i++)
            System.out.print(" ");
        System.out.println(pat2);

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");

        System.out.println("Алгоритм Кнута-Морриса-Пратта: \n");

        KMP kmp = new KMP(pattern, 256);
        KMP kmp2 = new KMP(pattern2, 256);

        int offset3 = kmp.search(text);
        int offset3_2 = kmp2.search(text2);

        System.out.println("Текст:  " + txt);

        System.out.print("Шаблон: ");
        for (int i = 0; i < offset3; i++)
            System.out.print(" ");
        System.out.println(pat);

        System.out.println();

        System.out.println("Текст:  " + txt2);

        System.out.print("Шаблон: ");
        for (int i = 0; i < offset3_2; i++)
            System.out.print(" ");
        System.out.println(pat2);

        System.out.println("\n");
        System.out.println("────────────────────────────────────────────────────────");
        System.out.println("\n");
        
    }
}
