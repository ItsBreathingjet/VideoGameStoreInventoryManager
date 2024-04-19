
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();
        try {
            BufferedReader reader =  new BufferedReader(new FileReader("Inventory.csv")    );
            String line = reader.readLine();
                while (line != null) {
                    Game game = new Game("", "", 0.0, "", 0);
                    game = game.fromString(line);
                    if(line != null) {
                        games.add(game);
                    }
                    line = reader.readLine();
             }
                reader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        
        }catch (NullPointerException e) {
            System.err.println("Null Pointer exception occurred: " + e.getMessage());
            System.out.println("Continuing with program execution...");
        }
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the VideoGame Store Inventory System!\n----------------------------------------------------");
        while(true){
            try{
                
                System.out.println("\n------------------------------------------\nWhat would you like to do?");
                    System.out.println("1. See Available Xbox Games");
                    System.out.println("2. See Available Playstation Games");
                    System.out.println("3. See Out of Stock Games");
                    System.out.println("4. Restock Games");

                    
                int choice = scanner.nextInt();
        
        
                switch (choice) {
                    case 1:
                        System.out.println("Available Xbox Games:");
                        displayXboxGames(games);
                        
                        break;
                    case 2:
                        System.out.println("Available Playstation Games:");
                        displayPlaystationGames(games);
                        break;
                    case 3:
                        System.out.println("Out of Stock Games:");
                        displayOutOfStockGames(games);
                        break;
                    case 4:
                        System.out.println("\nAdd Games to Inventory:\n--------------------------");
                        addGamesToInventory(games, scanner);
                        break;
                    default:
                        System.out.println("Invalid choice!");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please only enter an Integer choice");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
    }
    
    private static void displayXboxGames(List<Game> games) {
        for(Game game:games) {
            if(game != null && "Xbox".equalsIgnoreCase(game.getType()) && game.getAmountInStock() > 0 ) {
                System.out.println(game);
            }
        }
    }
    private static void displayPlaystationGames(List<Game> games) {
        for(Game game:games) {
            if(game != null && "Playstation".equalsIgnoreCase(game.getType()) && game.getAmountInStock() > 0 ) {
                System.out.println(game);
            }
        }
    }
    

    private static void displayOutOfStockGames(List<Game> games) {
        for (Game game: games) {
            if(game != null && game.getAmountInStock() == 0) {
                System.out.println(game);
            }
        }
    }
    private static void addGamesToInventory(List<Game> games, Scanner scanner) {
        System.out.println("Adding Games to Inventory");
        System.out.println("Enter the details for the new game:");
        
        String type = "";
        while (true) {
            try {
                System.out.print("Type (Xbox/Playstation): ");
                type = scanner.next();
                if(!type.equalsIgnoreCase("Xbox")&& !type.equalsIgnoreCase("Playstation")) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter either 'Xbox' or 'Playstation'.");
                scanner.nextLine(); 
            }
        }

        String title = "";
        while (true) {
            try {
                System.out.print("Title: ");
                title = scanner.next();
                if(title.isEmpty()) {
                    throw new InputMismatchException();
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for title.");
                scanner.nextLine(); 
            }
        }    
        
        double price = 0.0;
        while (true) {
            try {
                System.out.print("Price:(*.**) ");
                price = scanner.nextDouble();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for price. Please enter a valid number.");
                scanner.nextLine();
            }
        }    

        
        String rating = "";
        while (true) {
            try {
                System.out.print("Rating:(E/T/M) ");
                rating = scanner.next().toUpperCase();
                if(!rating.equalsIgnoreCase("E") && !rating.equalsIgnoreCase("T") && !rating.equalsIgnoreCase("M")){
                    throw new InputMismatchException();
                }
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for rating.");
                scanner.nextLine(); 
            }
        }    

        int amountInStock = 0;
        while (true) {
            try {
                System.out.print("Amount in Stock: ");
                amountInStock = scanner.nextInt();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input for amount in stock. Please enter an integer.");
                scanner.nextLine(); 
            }
        }    

        

        Game newGame = new Game(type, title, price, rating, amountInStock);
        games.add(newGame);

        updateCSVFile(games);

        System.out.println("New game added to inventory successfully:");
        System.out.println(newGame);
    }

    private static void updateCSVFile(List<Game> games) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Inventory.csv"))) {
            for (Game game : games) {
                writer.println(game.toCSVString());
            }
            System.out.println("CSV file updated successfully.");
        } catch (IOException e) {
            System.out.println("Error updating CSV file: " + e.getMessage());
        }
    }


    
        
    
    
                
        


    
    
}