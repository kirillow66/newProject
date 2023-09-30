import java.io.*;
import java.util.Scanner;


public class Project {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        Counter counter = new Counter();
        //Загружаем значение счетчика
    try {
        FileInputStream fileInputStream = new FileInputStream("memory");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        counter = (Counter) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println("Счетчик загружен, значение " + counter.getValue());
       }
    catch (FileNotFoundException e){
        System.out.println("Счетчик запущен впервые");
}
    //Проводим операции со счетчиком
        String instruction;
        do {
            do {
                System.out.print("Введите команду: ");
                instruction = input.nextLine();
            }
            while (!(instruction.equals("inc") || instruction.equals("reset") || instruction.equals("stop")));
            switch (instruction) {
                case "inc":
                    counter.inc();
                    break;
                case "reset":
                    counter.reset();
                    break;
                case "stop":
                    break;
            }

        }
        while(!(instruction.equals("stop")));
        counter.statusValue();
        System.out.println("Завершаю работу");

        //Сохраняем значение счетчика
        FileOutputStream fileOutputStream = new FileOutputStream("memory");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(counter);
        objectOutputStream.close();
    }
}
