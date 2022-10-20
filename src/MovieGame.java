import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class MovieGame {

    public static void main(String[] args) throws Exception {
        String line;
        String currentGuess;
        String[] films = new String[50];
        int filmNumber = 0;
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            films[filmNumber] = line;
            //System.out.println(line);
            filmNumber++;
        }
        int randomNumber = (int) (Math.random() * filmNumber) + 1;
        Movie movie = new Movie();
        movie.addTitle(films[randomNumber].trim()); //add movie title to object

        String uLine = movie.makeUnderScore(movie.getMovieTitle()); //make the string underscored

        movie.addUnderScore(uLine); //add to variable in class
        System.out.println("Try to guess a movie title. Type a character.");
        Scanner scanner1 = new Scanner(System.in);

        int indexOfCharacter = 0;
        int indexOfCurrent=0;
        currentGuess = movie.undercore;
        System.out.println(movie.getMovieTitle());
        System.out.println(currentGuess);

        boolean wonGame=false;
        char typeChar;
        int leftGuess=10;
        while ((!(currentGuess.equals(movie.getMovieTitle())))&&(!(wonGame))) {

        typeChar = scanner1.next().charAt(0);

        indexOfCharacter = movie.getMovieTitle().lastIndexOf(typeChar, movie.getMovieTitle().length());
        indexOfCurrent=currentGuess.lastIndexOf(typeChar);
        if (indexOfCurrent>=0){
            System.out.println("You typed already this character.");
            leftGuess--;
            System.out.println("You have yet "+leftGuess+" left");
        }
        else if((indexOfCharacter>=0) && (!(indexOfCurrent>=0))) {
                
            System.out.println("Good. You gussed the character --"+typeChar);
            }
        else   {
            leftGuess--;
            System.out.println("Wrong shot.You have yet "+leftGuess+" left");
        }
        if (leftGuess==0){
            wonGame=true;
        }
        //check if the character is correct

        while (indexOfCharacter >= 0) {

            currentGuess = currentGuess.substring(0, indexOfCharacter) + typeChar + currentGuess.substring((indexOfCharacter + 1));
            indexOfCharacter = movie.getMovieTitle().lastIndexOf(typeChar, (indexOfCharacter - 1));

        }

        System.out.println(currentGuess);
    }
        if (wonGame){
            System.out.println("You lost");
            System.out.println("The title is: "+movie.getMovieTitle());
        }
        else {
            System.out.println("You win!");
        }
    }
}
