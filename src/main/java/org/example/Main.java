package org.example;
/*
Bu program kredi kartı numarasının doğruluğunu Luhn algoritması kullanarak kontrol eder. Kredi kartı numarası girildikten sonra,
program öncelikle girilen numaradaki boşlukları kaldırır. Daha sonra, Luhn algoritması adı verilen bir algoritma kullanılarak
numaranın doğruluğu kontrol edilir.Luhn algoritması, bir kredi kartı numarasının geçerliliğini doğrulamak için kullanılan bir
algoritmadır. Bu algoritma, kredi kartı numarasının son hanesinin bir kontrol rakamı olduğunu ve bu kontrol rakamının diğer
hanelerin doğruluğunu belirlemek için kullanıldığını varsayar. Algoritma, numaranın belirli bir formülasyonu izlemesini
gerektirir ve doğru olup olmadığını kontrol etmek için kontrol rakamını hesaplar.
Program, Luhn algoritmasını kullanarak kontrol rakamını hesaplar ve sonuç olarak kredi kartı numarasının geçerli olup
olmadığını belirler. Eğer numara geçerliyse, "Girilen kredi kartı numarası doğru." mesajını görüntüler, aksi halde
"Girilen kredi kartı numarası yanlış." mesajını gösterir.
Bu program, kullanıcıya kredi kartı numarasının geçerliliğini hızlı ve kolay bir şekilde kontrol etme imkanı sağlar.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kredi kartı numarasını girin: ");
        String kartNumarasi = scanner.nextLine().replaceAll("\\s", ""); // Boşlukları kaldır

        if (luhnAlgoritmasi(kartNumarasi)) {
            System.out.println("Girilen kredi kartı numarası doğru.");
        } else {
            System.out.println("Girilen kredi kartı numarası yanlış.");
        }
    }

    public static boolean luhnAlgoritmasi(String kartNumarasi) {
        int toplam = 0;
        boolean tekBasamak = true;

        for (int i = kartNumarasi.length() - 1; i >= 0; i--) {
            char c = kartNumarasi.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            int rakam = c - '0';

            if (tekBasamak) {
                toplam += rakam;
            } else {
                rakam *= 2;
                if (rakam > 9) {
                    rakam -= 9;
                }
                toplam += rakam;
            }

            tekBasamak = !tekBasamak;
        }

        return toplam % 10 == 0;
    }
}