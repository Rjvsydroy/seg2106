
package Lexical;
import java.io.*;


public class Parser {
	private static BufferedReader bufferedReader;
	private static String token;

	public static String program(){
		if(token.equals("begin")){
			getnexttoken();
			if (statement_list().equals("OK")){
				//getnexttoken();
				return program_prime();
			}
			else{
				return "ERROR";
			}
		}
		else{
			return "ERROR";
		}

	}

	public static String program_prime(){
		if(token.equals("end")){
			getnexttoken();
			return "OK";
		}
		else{
			return "ERROR";
		}
	}
	public static String statement_list(){
		if (statement().equals("ERROR")){
			return "ERROR";}
		else{if (token.equals(";")){ 
			getnexttoken();
			return statement_list_prime();}
		else return "ERROR";
		}
	}
	public static String statement_list_prime(){
			statement_list();
			return "OK";
			}
		
		
	

	public static String statement(){
		if (token.equals("id")){
			getnexttoken();
			return statement_prime();}
		else return "ERROR";
	}
	public static String statement_prime(){
		if (token.equals("=")){
			getnexttoken();
			return expression();}
		else return "ERROR";
	}
	public static String expression(){
		if (factor().equals("ERROR")){
			return "ERROR";}
		else return expression_prime();
	}
	public static String expression_prime(){
		if (token.equals("+")){
			getnexttoken();
			return factor();}
		else if (token.equals("-")){
			getnexttoken();
			return factor();}

		else {
			return "OK";}
	}

	public static String factor(){
		if (token.equals("id")){
			getnexttoken();
			return "OK";}
		else if (token.equals("num")){
			getnexttoken();
			return "OK";}

		else {
			return "ERROR";}
	}


	// gets next token from file
	public static void getnexttoken(){
		try {
			token=  bufferedReader.readLine();}
		
		catch(IOException ex) {
			System.out.println(
					"Error reading file");                  

		}
		System.out.println(token);
	}	    

	public static void main(String [] args) {
		if(args.length!=1){
			System.out.println("You must enter one file name as argument");
			return;
		}


		// The name of the file to open.
		String fileName = args[0];



		try {
			//opening file
			FileReader fileReader = 
					new FileReader(fileName);
			bufferedReader = 
					new BufferedReader(fileReader);
			//starting parsing
			getnexttoken();
			if (program().equals("ERROR") || !token.equals("$")){
				System.out.println("ERROR");       
				bufferedReader.close();
				return;}
			else{
				System.out.println("OK");
				bufferedReader.close();
				return;}






		}
		catch(FileNotFoundException ex) {
			System.out.println(
					"Unable to open file '" + 
							fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println(
					"Error reading file '" 
							+ fileName + "'");                  

		}
	}
}
