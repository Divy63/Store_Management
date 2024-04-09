/**
 * App.java
 *
 * COMP 2150 SECTION A01
 * INSTRUCTOR Heather Matheson
 * Project Project
 * 
 * @author Het Patel, 7972424
 * @author Divy Patel,7951650
 * @author Vince Ibero, //TODO Vince needs to write student number
 * @version 2024-04-10
 *
 *          REMARKS: Program that provides interface to user to get connected to the database and perform analysis on it
 */
package application;

import application.mydatabase.Database;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class App {
    public static void main(String[] args) {
        String reponse;
        Database db = new Database();
        reponse = db.startup();

        if (reponse != null) {
            System.out.println(reponse);
        } else {
            simulate(db);
        }

        System.out.println("\nEnd of processing\n");
    }

    /**
     * Method that gets the Database object and then calls other methods in this
     * class for simulation purposes.
     * It takes user input and calls the methods according to the user input and
     * provides user with the data
     * they want.
     * 
     * @param db
     */
    private static void simulate(Database db) {

        Scanner consoleIn = new Scanner(System.in);// Scanner that takes input from console
        System.out.println();// Getting on a new line
        System.out.println("Welcome to Store Management!");// label

        System.out.print("To get started, ENTER 'm' for Menu: ");
        String cmd = nextNonEmptyLine(consoleIn, "To get started, ENTER 'm' for Menu: ");

        String[] parts;
        boolean cont = true;
        String message;

        while (cont) {
            processCommand(db, cmd);
            cmd = nextNonEmptyLine(consoleIn, "Choice >> ");
            cont = cmd != null && !cmd.equalsIgnoreCase("e");
        }

        System.out.println("\nExiting Store Management interface. Have a great day!\n");
        consoleIn.close();

    }

    private static String processSPC(Database db, String[] args) {
        String response;

        if (args.length >= 2) {
            try {
                int limit = Integer.parseInt(args[1]);
                System.out.println(
                        "\nSearching the database for Profit across stores for top \'" + limit
                                + "\' country");
                System.out.println(
                        "--------------------------------------------------------------------------------------");
                response = db.storeProfitByCountry(limit);
            } catch (NumberFormatException nfe) {
                response = "Limit must be an integer.";
            }
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processTopProducts(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println("\nSearching the database for top most inventory holding store in " + args[1]
                    + " for each category:");
            System.out.println(
                    "-------------------------------------------------------------------------------------------------");
            response = db.topProducts(args[1]);
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processRC(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println(
                    "\nSearching database for number of items returned by customer with id \'" + args[1] + "\'");
            System.out
                    .println(
                            "--------------------------------------------------------------------------------------\n");
            response = db.returnedItemCount(args[1]);
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processDP(Database db, String[] args) {
        String response;
        if (args.length >= 4) {
            System.out.println(
                    "\nSearching database discounted items in category \"" + args[1] + " " + args[2]
                            + "\" with discount greater than or equal to " + Double.parseDouble(args[3])
                            + " % : ");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------");
            response = db.discountedProducts(args[1] + " " + args[2], Double.parseDouble(args[3]));
        } else if (args.length == 3) {
            System.out.println(
                    "\nSearching database discounted items in category \"" + args[1]
                            + "\" with discount greater than or equal to " + Double.parseDouble(args[2])
                            + " % : ");
            System.out.println(
                    "----------------------------------------------------------------------------------------------------------------");
            response = db.discountedProducts(args[1], Double.parseDouble(args[2]));
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processSD(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println("\nSearching database for order with ID \'" + args[1] + "\'");
            System.out
                    .println(
                            "--------------------------------------------------------------------------------------");
            response = db.shippingDetails(args[1]);
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processSS(Database db) {
        System.out.println("\nSearching database for total sales of each category :");
        System.out
                .println("--------------------------------------------------------------------------------------");

        return db.salesSummaryByCategory();
    }

    private static String processSubCP(Database db) {
        System.out.println("\nSearching database for distinct products in each sub category :");
        System.out
                .println("--------------------------------------------------------------------------------------");
        return db.subCategoryInventory();
    }

    private static String processRP(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println(
                    "\nSearching database for returned products of customer with customer ID \"" + args[1]
                            + "\" :");
            System.out
                    .println(
                            "-------------------------------------------------------------------------------------------");
            response = db.returnedProducts(args[1]);
        } else {
            response = "Require an argument for this command";
        }
        return response;
    }

    private static String processRPR(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println(
                    "\nSearching database for returned products in region \"" + args[2] + "\" :");
            System.out
                    .println(
                            "-------------------------------------------------------------------------------------------");
            response = db.returnedByRegion(args[1]);
        } else {
            response = "Require an argument for this command";
        }
        return response;
    }

    private static String processAVGP(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println(
                    "\nSearching the database for Avergae Price of Products in category with category ID \""
                            + args[2] + "\" :");
            System.out.println(
                    "----------------------------------------------------------------------------------------------");
            response = db.averagePrice(Integer.parseInt(args[1]));
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processExceed(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println(
                    "\nSearching the database for ship modes of order quantities greater than " + args[2] + " :");
            System.out.println(
                    "----------------------------------------------------------------------------------------------");
            response = db.exceedXShipMode(Integer.parseInt(args[2]));
        } else {
            response = "Require an argument for this command";
        }
        return response;
    }

    private static String processLRA(Database db, String[] args) {
        String response;
        if (args.length >= 2) {
            System.out.println(
                    "\nSearching the database for order with largest total for each country which were returned");
            System.out.println(
                    "----------------------------------------------------------------------------------------------");
            response = db.largestReturnedAmount(Integer.parseInt(args[1]));
        } else {
            response = "Require an argument for this command";
        }

        return response;
    }

    private static String processSC(Database db) {
        System.out.println("\nSearching the database for countries");
        System.out.println(
                "------------------------------------------------");
        System.out.println("List of available countries:");
        return db.showCountries();
    }

    private static String processGCID(Database db, String[] args) {\
        String response;
        if (args.length >= 2) {
            System.out.println("Searching the database for people with \"" + args[1] + "\" in their name");
            System.out.println(
                    "------------------------------------------------------------------------------");
            System.out.println("List of available people:");
            response = db.showPeople(args[1]);
        } else {
            response = "Require an argument for this command";
        }
        return response;
    }

    private static String process

    private static String processCommand(Database db, String cmd) {
        String[] args = cmd.split("\\s+");
        // if (command.indexOf(" ") > 0)
        // arg = command.substring(command.indexOf(" ")).trim();

        if (args[0].equalsIgnoreCase("m")) {
            displayMenu();
        }
        
        else if (args[0].equalsIgnoreCase("spc")) {
            return processSPC(db, args);
        }

        else if (args[0].equalsIgnoreCase("topproducts")) {
            return processTopProducts(db, args);
        }

        else if (args[0].equalsIgnoreCase("rc")) {
            return processRC(db, args);
        }

        else if (args[0].equalsIgnoreCase("dp")) {
            return processDP(db, args);
        }

        else if (args[0].equalsIgnoreCase("sd")) {
            return processSD(db, args);
        }

        else if (args[0].equalsIgnoreCase("ss")) {
            return processSS(db);
        }

        else if (args[0].equalsIgnoreCase("subcp")) {
            return processSubCP(db);
        }

        else if (args[0].equalsIgnoreCase("rp")) {
            return processRP(db, args);
        }
        
        else if (args[0].equalsIgnoreCase("rpr")) {
            return processRPR(db, args);
        }
        
        else if (args[0].equalsIgnoreCase("avgp")) {
            return processAVGP(db, args);
        }
        
        else if (args[0].equalsIgnoreCase("exceed")) {
            return processExceed(db, args);
        }
        
        else if (args[0].equalsIgnoreCase("lra")) {
            return processLRA(db, args);
        }
        
        else if (args[0].equalsIgnoreCase("sc")) {
            return processSC(db);
        }
        
        else if (args[0].equalsIgnoreCase("gcID")) {
            return processGCID(db, args);
        }
        
        else if (args[0].equalsIgnoreCase("scategories")) {
            
        } else if (args[0].equals("sSubCategories")) {
            if (args.length >= 3) {
                System.out.println("\nSearching the database for categories");
                System.out.println(
                        "------------------------------------------------");
                System.out.println("List of available sub-categories with their IDs:");
                db.showSubCategories(args[1] + " " + args[2]);
            } else if (args.length == 2) {
                System.out.println("\nSearching the database for categories");
                System.out.println(
                        "------------------------------------------------");
                System.out.println("List of available sub-categories with their IDs:");
                db.showSubCategories(args[1]);
            } else {
                System.out.println("Require an argument for this command");
            }
        } else if (args[0].equals("sRegions")) {
            System.out.println("\nSearching the database for Regions");
            System.out.println(
                    "------------------------------------------------");
            db.showRegions();
        } else if (args[0].equalsIgnoreCase("i")) {
            String message = db.initializeDatabase();
            if (message != null) {
                System.out.println(message);
            }
        } else {
            System.out.println("Invalid choice. Enter 'm' for Menu");
        }

    }

    /*
     * Method that prints the menu to be displayed
     */
    private static void displayMenu() {
        System.out.println(
                "\tgcID <part of the name of customer> - Gets the Name of all the customer with 'part of the name of the customer' int their name");
        System.out.println(
                "\tsc - Show all the Countries along with their Country Code");
        System.out.println(
                "\tsRegions - Show all the Regions");
        System.out.println(
                "\tscategories - Show all the Categories");
        System.out.println(
                "\tsSubCategories - Show all the Sub-Categories along with their Category");
        System.out.println(
                "\tspc <country limit> - Stores and Profit by Country");
        System.out.println(
                "\ttopproducts <country code> - Top Product Holders by Category");
        System.out.println(
                "\trc <customerID>  - Customer Returned Item Count Analysis");
        System.out.println(
                "\tdp <category name> <minimum discount> - Discounted Products in Specific Category");
        System.out.println(
                "\tsd <orderID> - Shipping Details for Ordered Products");
        System.out.println(
                "\tss - Category Sales Summary");
        System.out.println(
                "\tsubcp - Sub-Category Product Inventory and Sales Overview");
        System.out.println(
                "\trp <custID> - Products Returned by Customer");
        System.out.println(
                "\trpr <region> - Product Returns by Region");
        System.out.println(
                "\tavgp <categoryID> - Average Product Price in Category");
        System.out.println(
                "\texceed <numProducts>- Order Shipping Mode Details for Orders Exceeding 7 Items");
        System.out.println(
                "\tlra <country limit> - Country-wise Largest Returned Order Amount");
        System.out.println("\ti - Initialize the database");
        System.out.println("\tm - Display the Menu.");
        System.out.println("\te - Exit the system.");

    }

    /**
     * Helper method for Scanner to skip over empty lines.
     * Print the prompt on each line of input.
     */
    private static String nextNonEmptyLine(Scanner in, String prompt) {
        String line = null;

        System.out.print(prompt);
        while (line == null && in.hasNextLine()) {
            line = in.nextLine();
            if (line.trim().length() == 0) {
                line = null;
                System.out.print(prompt);
            }
        }

        return line;
    }
}
