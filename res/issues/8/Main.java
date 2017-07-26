package com.jun.blog;

/**
 * Created by jun on 7/21/2017.
 */
public class Main {

    public static void main(String[] args) {
        int count = 500000;
        boolean result1 = false,result2 = false;
        String a = "aabbahdhdghghdhdfghgGGHDVBNNSDfhgcccccqqqcczzzzzccc" +
                "cccccccdfhdgfhgfhgnnnQQnnnnnnn" +
                "nfhfghghghgfuokekaddQQQQdadddffff";
        String b = "ghdhdfgcccfffgbzbggggQ";

        long start = System.currentTimeMillis();
        for(int i=0; i<count; i++) {
            result1 = q1(a, b);
        }
        long t1 = System.currentTimeMillis();
        System.out.println(t1 - start);

        for(int i=0; i<count; i++) {
            result2 = q2(a, b);
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);

        System.out.println("q1 = " + result1);
        System.out.println("q2 = " + result2);
    }

    static public boolean q1(String a, String b){
        if(a != null && !a.isEmpty() && b != null && !b.isEmpty()) {
            boolean result = true;
            int index;
            StringBuffer source = new StringBuffer();
            StringBuffer sb = new StringBuffer();
            source.append(a);
            for (int i = 0; i < b.length(); i++) {
                String letter = String.valueOf(b.charAt(i));
                index = source.indexOf(letter);
                if (index > -1) {
                    sb.delete(0, sb.length());
                    sb.append(source.substring(0, index)).append(source.substring(index + 1));
                    source.delete(0, source.length());
                    source.append(sb);
                } else {
                    return false;
                }
            }
            return result;
        }else{
            return false;
        }
    }

    static public boolean q2(String a, String b){
        if(a != null && !a.isEmpty() && b != null && !b.isEmpty()) {
            boolean result = true;
            int[] lettersA = new int[60];
            int[] lettersB = new int[60];
            for (int i = 0; i < b.length(); i++) {
                lettersB[b.charAt(i) - 'A']++;
            }
            for (int i = 0; i < a.length(); i++) {
                lettersA[a.charAt(i) - 'A']++;
            }
            for (int i = 0; i < lettersA.length; i++) {
                if (lettersA[i] < lettersB[i]) {
                    return false;
                }
            }
            return result;
        }else{
            return false;
        }
    }


}
