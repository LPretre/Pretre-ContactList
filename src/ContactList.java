import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {

    private ArrayList<Person> contacts;

    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts(){
        return contacts;
    }
    public void add(Person newPerson){
        contacts.add(newPerson);
    }

    public void printContacts(){
        for (Person person : contacts){
            System.out.println(person.toString());
        }
    }

    public void sort(int sortBy) {
        int n = contacts.size();
        if (sortBy == 0) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        else if(sortBy == 1){
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
        else{
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                        Person temp = contacts.get(j);
                        contacts.set(j, contacts.get(j + 1));
                        contacts.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public Person searchByFirstName(String name){
        for (Person person : contacts){
            if (person.getFirstName().equals(name)){
                return person;
            }
        }
        return null;
    }
    public Person searchByLastName(String name){
        for (Person person : contacts){
            if (person.getLastName().equals(name)){
                return person;
            }
        }
        return null;
    }
    public Person searchByPhoneNumber(String number){
        for (Person person : contacts){
            if (person.getPhoneNumber().equals(number)){
                return person;
            }
        }
        return null;
    }

    public void listStudents(){
        for (Person person : contacts){
            if (person instanceof Student){
                System.out.println(person.toString());
            }
        }
    }

    public void run() {

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running == true) {
        System.out.println("\nMenu:");
        System.out.println("1 - Add Contact");
        System.out.println("2 - List all contacts by first name");
        System.out.println("3 - List all contacts by last name");
        System.out.println("4 - List all contacts by phone number");
        System.out.println("5 - List all students");
        System.out.println("6 - Search by first name");
        System.out.println("7 - Search by last name");
        System.out.println("8 - Search by phone number");
        System.out.println("0 - Exit");
        String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Select a type of contact to add:");
                System.out.println("1 - Student");
                System.out.println("2 - Athlete");
                System.out.print("Enter choice: ");
                String typeChoice = scanner.nextLine();

                System.out.print("Enter first name: ");
                String firstName = scanner.nextLine();
                System.out.print("Enter last name: ");
                String lastName = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.nextLine();

                if (typeChoice.equals("1")) {
                    System.out.print("Grade: ");
                    int grade = scanner.nextInt();
                    add(new Student(firstName, lastName, phoneNumber, grade));
                } else if (typeChoice.equals("2")) {
                    System.out.print("Sport: ");
                    String sport = scanner.nextLine();
                    add(new Athlete(firstName, lastName, phoneNumber, sport));
                }
                }else if (choice.equals("2")) {
                    sort(0);
                    printContacts();
                } else if (choice.equals("3")) {
                    sort(1);
                    printContacts();
                }
                else if (choice.equals("4")) {
                sort(2);
                printContacts();
            }
                else if (choice.equals("6")) {
                    System.out.print("Enter a name: ");
                    String name = scanner.nextLine();
                    if (searchByLastName(name) == null){
                        System.out.println(name + " is not in the list");
                    }
                    else{
                        System.out.println(searchByLastName(name).toString());
                    }
                } else if (choice.equals("7")) {
                    System.out.print("Enter a last name: ");
                    String name = scanner.nextLine();
                    if (searchByLastName(name) == null){
                        System.out.println(name + " is not in the list");
                    }
                    else{
                        System.out.println(searchByLastName(name).toString());
                    }
                } else if (choice.equals("8")) {
                    System.out.print("Enter a phone number: ");
                    String number = scanner.nextLine();
                    if (searchByLastName(number) == null){
                        System.out.println(number + " is not in the list");
                    }
                    else{
                        System.out.println(searchByLastName(number).toString());
                    }
                } else if (choice.equals("5")) {
                    listStudents();
                } else if (choice.equals("0")) {
                    running = false;
                } else {
                    System.out.println("Invalid option. Try again.");
                }

        }
    }

    public static void main(String[] args){
        ContactList list = new ContactList();
        list.run();
    }
}
