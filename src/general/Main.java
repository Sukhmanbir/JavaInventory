/**
 * This class Main creates employee and/or product object and stores it in
 * respective arrayLists and lets the user search specific object in both lists
 * using menu.
 *
 * @author Sukhmanbir Kaur
 */
package general;

import java.util.ArrayList;
import hr.*;
import inventory.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //variable to read user input and toggle menu
        int select;

        //variables for creating employee object
        String firstName, lastName;
        int age;
        String position;
        int year, month, day;
        double commissionRate, grossSale;

        //variables for creating product object
        String productId, productName, category, manufacturer, description, partNum;
        double productCost, productPrice, productMarkup;

        //arraylist to store employees
        ArrayList<Employee> employeeList = new ArrayList<>();

        //arraylist to store products
        ArrayList<Product> productList = new ArrayList<>();

        //user makes selection from menu
        do {
            System.out.println("Please choose one of the options:\n"
                    + "1 - Add an Employee.\n"
                    + "2 - Add a Product.\n"
                    + "3 - Search an Employee.\n"
                    + "4 - Search a Product.\n"
                    + "5 - Exit");

            Scanner scanner = new Scanner(System.in);
            select = scanner.nextInt();

            //switch is used to toggle between menu items
            switch (select) {
                case 1://creating employee object
                {
                    System.out.print("Please enter Employee\'s first name: ");
                    firstName = scanner.next();//store user's input in class variable to store in arrayList

                    System.out.print("\nPlease enter Employee\'s last name: ");
                    lastName = scanner.next();

                    System.out.print("\nPlease enter Employee\'s age: ");
                    age = scanner.nextInt();
                    
                    System.out.print("\nPlease enter Employee\'s position: ");
                    position = scanner.next();

                    System.out.print("\nPlease enter Employee\'s year of hire: ");
                    year = scanner.nextInt();

                    System.out.print("\nPlease enter Employee\'s month of hire: ");
                    month = scanner.nextInt();

                    System.out.print("\nPlease enter Employee\'s day of hire: ");
                    day = scanner.nextInt();
                    
                    System.out.print("\nPlease enter Employee\'s Commission Rate: ");
                    commissionRate = scanner.nextDouble();
                    
                    System.out.print("\nPlease enter Employee\'s Gross Sales: ");
                    grossSale = scanner.nextDouble();

                    //add employee object to employeeLisr
                    employeeList.add(new CommissionSalesEmployee(firstName, lastName, age, position, month, year, day, commissionRate, grossSale));
                }
                break;
                case 2://creating product object
                {
                    System.out.print("\nPlease enter Product\'s Name: ");
                    productName = scanner.next();

                    System.out.print("\nPlease enter Product\'s Category: ");
                    category = scanner.next();

                    System.out.print("\nPlease enter Product\'s Manufacturer: ");
                    manufacturer = scanner.next();

                    System.out.print("\nPlease enter Product\'s description: ");
                    description = scanner.next();

                    System.out.print("\nPlease enter Product\'s Part Num: ");
                    partNum = scanner.next();

                    System.out.print("\nPlease enter Product\'s Cost: ");
                    productCost = scanner.nextInt();

                    System.out.print("\nPlease enter Product\'s Price: ");
                    productPrice = scanner.nextInt();

                    System.out.print("\nPlease enter Product\'s Markup: ");
                    productMarkup = scanner.nextInt();

                    //add product object to productList
                    productList.add(new Product(productName, category, manufacturer, description, partNum, productCost,
                            productPrice, productMarkup));
                }
                break;
                case 3: {
                    String empName;
                    System.out.print("Please enter full/first/last name of Employee: ");
                    empName = scanner.next();
                    if (employeeList.isEmpty()) {
                        System.out.println("There are no employees in the list!");
                    } else {
                        for (Employee emp : employeeList) {
                            if (empName != null && emp.getFullName().contains(empName)) {
                                System.out.println(emp);
                            } else //                        if(emp.contains(scanner.next()))
                            //                    {
                            //                        System.out.print(emp);
                            //                    }else
                            {
                                System.out.println("Sorry no Employee found as per the information entered! :(");
                            }
                        }
                    }
                }
                break;
                case 4: {
                    String pName;
                    System.out.print("Please enter name of Product: ");
                    pName = scanner.next();

                    if (productList.isEmpty()) {
                        System.out.println("There are no products in the list!");
                    } else {
                        for (Product p : productList) {
                            if (pName != null && p.getProductName().equalsIgnoreCase(pName)) {
                                System.out.println(p);
                            } else //                        if(p.contains(scanner.next()))
                            //                    {
                            //                        System.out.print(p);
                            //                    }else
                            {
                                System.out.println("Sorry no Product found as per the information entered!");
                            }
                        }
                    }
                }
            }
        } while (select != 5);
        System.out.println("You exited the program. Bye - See you soon! :)");

        //show info stored
        System.out.println(employeeList);
        System.out.println(productList);

        

    }
}
