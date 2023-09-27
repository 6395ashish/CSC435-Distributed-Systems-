import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomStringGenerator {
	public static void main(String[] args) {
// check if the incorrect  number of command line arguments are provided
if (args.length != 2) { 
System.out.println("Usage: java RandomStringGenerator <number_of_stringd_to_generate <file_path>");
return;
}
int numberOfStrings = Integer.parseInt(args[0]);
String filePath = args[1];

try {

BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

for (int i=0; i< numberOfStrings;i++)
{
String randomString = generateRandomString(i);

writer.write(randomString);
writer.newLine();
}

writer.close();

System.out.println("Random strings generated and saved to: " + filePath);
}
catch (IOException e)
{
System.err.println("Error writing to the file: "+ e.getMessage());
}
}
public static String generateRandomString(int sequenceNumber)
{
String randomInteger = String.format("%08d",new Random().nextInt(100000000));
String sequenceString = String.format("%010d", sequenceNumber);

String randomString = generateRandomAlphanumericString(46);

return randomInteger + "_" + sequenceString + "_" + randomString;
}
public static String
generateRandomAlphanumericString(int length)
{
String characters = "ABCDEFGHIJKLNMOPQRSTUVWXYZabcdefghijklnmopqrstuvwxyz0123456789";
StringBuilder randomString = new StringBuilder();
Random rand = new Random ();
for(int i=0; i<length; i++){
int index = rand.nextInt(characters.length());
randomString.append(characters.charAt(index));}
return randomString.toString();}}


