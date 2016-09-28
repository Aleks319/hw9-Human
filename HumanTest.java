package lesson9.hw.human;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class HumanTest {
    public static void main(String[] args)  {

        HashSet<Human> listPeople = new HashSet<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your path to file:");
        String path = sc.nextLine();

        if(new File(path).isFile()) {
            if (new File(path).length()==0) {
                System.out.println("Input info about 10 people:");
                for (int i = 1; i <= 3; i++) {
                    System.out.println("Human " + i + ":");
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter last name: ");
                    String lastname = sc.nextLine();
                    System.out.print("Enter gender (male/female): ");
                    String gender = sc.nextLine();
                    System.out.print("Enter profession: ");
                    String profession = sc.nextLine();
                    System.out.print("Enter age (years): ");
                    int age = sc.nextInt();
                    System.out.print("Enter height (cm.): ");
                    int height = sc.nextInt();
                    System.out.print("Enter weight (kg.): ");
                    int weight = sc.nextInt();

                    listPeople.add(new Human(name, lastname, gender, profession, age, height, weight));
                }
                try {
                    writer(listPeople, path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("LIST OF PEOPLE:");
                try {
                    reader(path);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Wrong path or file!");
        }
    }

    public static void writer (HashSet<Human>  set, String file) throws IOException {

        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Human h: set) {
            oos.writeObject(h);
            oos.flush();
        }
        oos.close();
    }

    public static void reader (String file) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        boolean b = true;

        while (b) {
            try {
                System.out.println(ois.readObject().toString());
            } catch (EOFException e) {
                b = false;
            }

        }
    }
}