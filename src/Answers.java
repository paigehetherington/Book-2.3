import java.util.Scanner;

/**
 * Created by vajrayogini on 2/10/16.
 */
public class Answers {
    String title ;
    String author;
    int numberOfPages;
    String color;

    public void askQuestions() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the title of the book?");
        title = scanner.nextLine();
        System.out.println("Who is the author of the book?");
        author = scanner.nextLine();
        System.out.println("How many pages in the book?");
        numberOfPages = Integer.valueOf(scanner.nextLine()); //type conversion to integer
        System.out.println("What color is the cover?");
        color = scanner.nextLine();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String getColor() {
        return color;
    }
}
