package tf.qa.automation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Введите номер телефона:");
        Scanner sc = new Scanner(System.in);
        String phone = sc.nextLine();
        sc.close();

        String spacebr = "В номере есть пробелы и/или скобки";
        String wrongN="Введен некорректный номер";
        String replace = "Замена +7 на 8";
        String overfloat="Количество символов больше 11";
        String check="Список изменений и сработавших проверок на некорректность: ";
        if(phone.length()<11)
        {
            System.out.println(wrongN); //Введен некорректный номер
        }
        else { // если больше или равно 11
            phone = phone.replace("(", "");
            phone = phone.replace(")", "");
            phone = phone.replace(" ", "");

            if (phone.length() == 11) { //если =11
                phone = phone.replace("+7", "8");
                if (phone.length() < 11) {
                    System.out.println(wrongN); //Введен некорректный номер
                }
                else {
                    System.out.println(check+spacebr); //"В номере есть пробелы и/или скобки"
                }
            } else {
                if (phone.length() > 11) { // если все еще >11, хотя удалили все скобки
                      phone = phone.replace("+7", "8");
                    if (phone.length() == 11){
                        System.out.println(check+replace+"; "+spacebr); //"Замена +7 на 8";
                    }
                    else {
                        if (phone.length() > 11){
                            System.out.println(wrongN);
                            System.out.println(check+overfloat);
                        }
                        else {
                            System.out.println(phone); // изначально корректный номер
                            System.out.println(check+"Не было изменений");
                        }
                    }

                }
            }
        }



    }
}

