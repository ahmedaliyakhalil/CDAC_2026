package cdac;

import java.util.Scanner;

public class EncryptionMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FileEncryption encryption = new FileEncryption();
        Decryption decryption = new Decryption();

        int choice;

        do {
            System.out.println("\n===== FILE ENCRYPTION MENU =====");
            System.out.println("1. Encrypt File");
            System.out.println("2. Decrypt File");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Enter file name: ");
                String encryptFile = sc.nextLine();

                encryption.encrypt(encryptFile);
                break;

            case 2:
                System.out.print("Enter file name: ");
                String decryptFile = sc.nextLine();

                decryption.decrypt(decryptFile);
                break;

            case 3:
                System.out.println("Program exited.");
                break;

            default:
                System.out.println("Invalid choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}