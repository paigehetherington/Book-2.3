import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * Created by vajrayogini on 2/10/16.
 */
public class Book {
    public static Answers answers = new Answers();

    public static void main(String[] args) { //call other methods in main method
        answers = loadBook();
        System.out.printf("%s %s %d %s\n", answers.title, answers.author, answers.numberOfPages, answers.color);
        if (answers == null) {
            answers.askQuestions();
        } else {
            System.out.println("Would you like to update your answers?");
            Scanner s = new Scanner(System.in);
            String answersUpd = s.nextLine();
                if (answersUpd.equalsIgnoreCase("yes")) {
                    answers.askQuestions();
                } else {
                    System.out.println("Okay, thank you.");
                }
        }


        saveBook();
    }



    public static void saveBook() {
        JsonSerializer s = new JsonSerializer(); //new object
        String json = s.serialize(answers); //serialize into string -- (include("*") includes array list)
        File f = new File("book.json");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close(); //save file
        } catch (Exception e){ //in case there is a problem and doesn't save, won't crash program
            System.out.println("Something went wrong");
        }
    }
     public static Answers loadBook() {
         try {File f = new File("book.json");
         Scanner s = new Scanner(f);
         s.useDelimiter("\\Z");
         String contents = s.next();

         JsonParser p = new JsonParser();
         return p.parse(contents, Answers.class); //method returns player object
         }
         catch (Exception e) {
             System.out.println("Something has gone wrong with loadBook.");
             return null;
         }

     }




}
