import java.io.*;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
        String name, breed;
        double age;
        Scanner keyboard = new Scanner(System.in);
        Dog[] allDogs = new Dog[10];

        int count = 0;

        // Declare the binary file
        File binaryFile = new File("Dogs.dat");

        try 
        {
          if (binaryFile.exists()){
            //Create infile stream
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(binaryFile));
            //Read object data from file
            allDogs = (Dog[])inputStream.readObject();
            inputStream.close();
            
            //Print array of dogs
            System.out.print("Previously saved dogs from binary file.\n");
            for (Dog d : allDogs){
                if (d != null)
                {
                    System.out.println(d);
                    count++;
                }
                else
                break;
                }
            }//end of for loop
            //Take user input
          do {
                System.out.print("Please enter dog's name (or \"quit\" to exit): ");
                name = keyboard.nextLine();
                // If the name is quit, break out of loop
                if (name.equalsIgnoreCase("quit"))
                    break;
                System.out.print("Please enter dog's breed: ");
                breed = keyboard.nextLine();
                System.out.print("Please enter dog's age: ");
                age = keyboard.nextDouble();

                // Instantiate a new Dog object and
                // store in the array
                // Increment the count
                allDogs[count++] = new Dog(name, breed, age);

                // Clear the empty line
                keyboard.nextLine();
                // Print a blank line
                System.out.println();

            } while (!name.equalsIgnoreCase("quit"));
        }//end of try
        catch(IOException e){
           System.err.println(e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.err.println("Serial version of Dog does not match! Using old data.");
            //Thread.sleep(5);
        }
        
        try
        {
            //Create outfile stream
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(binaryFile));
            //Write array of dogs in a file 
            for(int i=0; i<allDogs.length; i++){
            System.out.println(allDogs[i]);
            outputStream.writeObject(allDogs);
            }
        /*
         * ObjectInputStream inputStream = new ObjectInputStream(new
         * FileInputStream(binaryFile));
         * 
         * dogsfromfile = (Dog[])inputStream.readObject();
         */

        // Dog read1 = (Dog)inputStream.readObject();
        // Dog read2 = (Dog)inputStream.readObject();
        // Dog read3 = (Dog)inputStream.readObject();

        /*System.err.println("The following wre read from the file:");
        for (int i = 0; i < dogsfromfile.length; i++) {
            System.out.println(dogsfromfile[i]);

        }*/
        // System.err.println(read1);
        // System.err.println(read2);
        // System.err.println(read3);

    }catch(
    FileNotFoundException e)
    {
        System.err.println("Cant find the file.");
    }
    /*catch(ClassNotFoundException e)
    {
        System.err.println("Problems with file input 1.");
    }*/
    catch(
    IOException e)
    {
        System.err.println(e.getMessage());
        // Thread.sleep(5);
    }
}
    }