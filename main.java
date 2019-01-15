import java.util.Scanner;

class Main {
  
  /*Initializes for colour usage*/
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_BLACK = "\u001B[30m"; 
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001B[37m";

  
/*sets up the initial game board with arrays*/
public static void main(String[] args) {
    String[][]MazeArray= new String[30][30];
    Scanner scanner = new Scanner(System.in);
    
    /*Game Description and Rules*/
    System.out.println(ANSI_BLUE + "Welcome to the Maze Game." + ANSI_RESET);
    System.out.println(ANSI_BLUE +"The rules..."+ ANSI_RESET);
    System.out.println(ANSI_BLUE +"Nothing!");
    System.out.println(ANSI_BLUE +"All you have to do is guide the robot through a 30 by 30 maze!"+ ANSI_RESET);
    
    /*Determines starting coordinates of robot*/
    /* Starting x coordinate */
    System.out.println(" ");
    System.out.println("Before we start, we need to determine the starting position of the robot. ");
    System.out.println("Enter the starting X coordinate.");
    int xPos1 = scanner.nextInt();
    //validates input
    if (xPos1 <= 0 || xPos1 > 30){
      boolean in = true;
      while (in = true) {
        System.out.println(ANSI_RED + "That is not a valid answer." + ANSI_RESET);
        System.out.println(ANSI_RED + "Please enter a number from 1 to 30." + ANSI_RESET);
        System.out.println("");
        System.out.println("Enter the starting X coordinate.");
        xPos1 = scanner.nextInt();
        if (xPos1 > 0 && xPos1 < 31){
        in = false;
        break;
        }
      }
    }
    else{
      System.out.println(ANSI_BLUE + "You entered number " + xPos1 + ANSI_RESET);
    }
    /* Starting y coordinate */
    System.out.println(" ");
    System.out.println("Enter the starting Y coordinate.");
    int yPos1 = scanner.nextInt();
    //validates input
    if (yPos1 <= 0 || yPos1 > 30){
      boolean in = true;
      while (in = true) {
        System.out.println(ANSI_RED + "That is not a valid answer." + ANSI_RESET);
        System.out.println(ANSI_RED + "Please enter a number from 1 to 30." + ANSI_RESET);
        System.out.println(" ");
        System.out.println("Enter the starting Y coordinate.");
        yPos1 = scanner.nextInt();
        if (yPos1 > 0 && yPos1 < 31){
        in = false;
        break;
        }
      }
    }
    else{
      System.out.println(ANSI_BLUE + "You entered number " + yPos1 + ANSI_RESET);
    }
  
  /*Determines Ending Coordinates*/
  /*Ending x coordinate*/
    System.out.println(" ");
    System.out.println("Let's now determine our robot's escape coordinate!");
    System.out.println("Enter the ending X coordinate.");
    int xPos2 = scanner.nextInt();
    //validates input
    if (xPos2 <= 0 || xPos2 > 30){
      boolean in = true;
      while (in = true) {
        System.out.println(ANSI_RED + "That is not a valid answer." + ANSI_RESET);
        System.out.println(ANSI_RED + "Please enter a number from 1 to 30." + ANSI_RESET);
        System.out.println("");
        System.out.println("Enter the ending X coordiante.");
        xPos2 = scanner.nextInt();
        if (xPos2 > 0 && xPos2 < 31){
        in = false;
        break;
        }
      }
    }
    else{
      System.out.println(ANSI_BLUE + "You entered number " + xPos2 + ANSI_RESET);
    }
  /*Ending y coordinate*/
    System.out.println(" ");
    System.out.println("Enter the ending Y coordinate.");
    int yPos2 = scanner.nextInt();
    //validates input    
    if (yPos2 <= 0 || yPos2 > 30){
      boolean in = true;
      while (in = true) {
        System.out.println(ANSI_RED + "That is not a valid answer." + ANSI_RESET);
        System.out.println(ANSI_RED + "Please enter a number from 1 to 30." + ANSI_RESET);
        System.out.println(" ");
        System.out.println("Enter the ending Y coordiante.");
        yPos2 = scanner.nextInt();
        if (yPos2 > 0 && yPos2 < 31){
        in = false;
        break;
        }
      }
    }
    else{
      System.out.println(ANSI_BLUE + "You entered number " + yPos2 + ANSI_RESET);
    }
    
    /*Creates background for maze board*/
    for(int y=0;y<30;y++){
      for(int x=0;x<30;x++){
        MazeArray[x][y]= ANSI_WHITE + "■" + ANSI_RESET;
      }
    }
    
    /* Creates starting position*/
    for (int y = 0; y<30; y++){
      String line = "";
      for (int x = 0; x <30; x++){
        line+="["+MazeArray[x][y]+"]";
        MazeArray[xPos1-1][yPos1-1] = ANSI_RED + "S" + ANSI_RESET;//Minus 1 because counter starts at 0 and not 1
      }
    }
    
    /* Prints ending postiion*/
    for (int y = 0; y<30; y++){
      String line = "";
      for (int x = 0; x <30; x++){
        line+="["+MazeArray[x][y]+"]";
        MazeArray[xPos2-1][yPos2-1] = ANSI_RED + "E" + ANSI_RESET;//Minus 1 because counter starts at 0 and not 1
      }
       System.out.println(line);/*Prints everything set above*/
    }
 
   String RobotGraphic = ""; 

  /*Creating Main Body Loop (Do-While)*/
  while (xPos1 != xPos2 || yPos1 != yPos2) {
  
  /*Asks user if robot is currently standing or sitting?*/
  /*Set RobotGraphic to proper value */
  System.out.println("Is the robot currently standing?" + ANSI_BLUE +  "Input Y/N" + ANSI_RESET);
  char a = scanner.next().charAt(0);
  if (a == 'Y'){ //user can input full word Yes, but program will only take the first letter
   Scanner input = new Scanner(System.in);
   RobotGraphic = "◙";//Sets RobotGraphic for standing position
  }
  else if (a == 'y'){ //allows for user input to be LowerCase or UpperCase
   RobotGraphic = "◙";//Sets RobotGraphic for standing position
  }
  else if (a == 'N'){
   Scanner input = new Scanner(System.in);
   RobotGraphic = "◊";//Sets RobotGrpahic for sitting position
  }
  else if (a == 'n'){
   Scanner input = new Scanner(System.in);
   RobotGraphic = "◊";//Sets RobotGraphic for standing position
  }
  else{
    System.out.println(ANSI_RED +"Invalid Answer" + ANSI_RESET);
  }
  
  /*Asks user for direction input*/
  System.out.println(" ");
  System.out.println("Its time to help the robot escape.");
  System.out.println("Which direction do you want to move?" + ANSI_BLUE + "(Input L/R/U/D)" + ANSI_RESET);
  char direction = scanner.next().charAt(0);//receives use input
  System.out.print("How many squares do you want to move in this direction?");
  int m = scanner.nextInt(); //receives user input
 
 
  /*Introducing the 4 case statements for each direction of travel*/
  switch(direction) {
    case 'L'://user can input full word "Left", but program will only take the first letter
    case 'l'://user input know becomes NOT case sensitive
      /*Inputs direction and movement*/
      /*Completes full set of moves*/
      for (int x = 0; x<m; x++){
        xPos1 = xPos1 -1;
        MazeArray[xPos1-1][yPos1-1] = ANSI_CYAN + RobotGraphic + ANSI_RESET; // Stores defined "RobotGraphic into "MazeArray at specific Coordinates
      }
      break;
    case 'R':
    case 'r':
      /*Inputs direction and movement*/
      /*Completes full set of moves*/
     for (int x = 0; x<m; x++){
        xPos1 = xPos1 +1;
        MazeArray[xPos1-1][yPos1-1] = ANSI_CYAN + RobotGraphic + ANSI_RESET;
     }
      break;
    case 'U':
    case 'u':
      /*Inputs direction and movement*/
      /*Completes full set of moves*/
     for (int y = 0; y<m; y++){
        yPos1 = yPos1 -1;
        MazeArray[xPos1-1][yPos1-1] = ANSI_CYAN + RobotGraphic + ANSI_RESET;
     }
      break;
    case 'D':
    case 'd':
      /*Inputs direction and movement*/
      /*Completes full set of moves*/
    for (int y = 0; y<m; y++){
        yPos1 = yPos1 +1;
        MazeArray[xPos1-1][yPos1-1] = ANSI_CYAN + RobotGraphic + ANSI_RESET;
     }
      break;
  } /*Ends Case Statements
  /*Shows updated board after set of movements are completed*/
   for (int y = 0; y<30; y++){
      String line = "";
      for (int x = 0; x <30; x++){
        line+="["+MazeArray[x][y]+"]";
      }
       System.out.println(line);
   }
       System.out.println("Here Is our Current Maze.");
  }/*Ends main do-while loop*/
  System.out.println(ANSI_PURPLE + "Congradulations for Helping The Robot Escape!" + ANSI_RESET);
  System.out.println(ANSI_PURPLE + "I hope u had fun☺" + ANSI_RESET);
  System.out.println(ANSI_PURPLE + "Make sure u come back and play again!" + ANSI_RESET);
}/*Ends "public static void main"*/
}/*End class Main*/
