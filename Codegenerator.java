//Instruction.java

import java.lang.*;
import java.util.*;
import java.io.*;

public class Codegenerator
{
	ArrayList<String> variables = new ArrayList<String>();
	HashMap<String,String> used_variables = new HashMap<String,String>(); 

	private void initialize_var()
	{
		variables.add("a");
		variables.add("b");
		variables.add("c");
		variables.add("d");
		variables.add("e");
		variables.add("f");
		variables.add("g");
		variables.add("h");
		variables.add("i");
		variables.add("j");
		variables.add("k");
		variables.add("l");
		variables.add("m");
	}

	Node instr;
	String[] variables={"a","b","c","d","e","f","g","h","i","j","k","l","m"}; 
	String output;
	String operand1;


	public Codegenerator(String s , int o , int n , String c)
	{
		this.inst_name = s;
		this.opcode = o ;
		this.no_operands = n ;
		this.inst_type = c;
	}
	

	public void instruction_generator() throws IOException,FileNotFoundException
	{
		FileReader fr = new FileReader("Instruction.txt");
		BufferedReader br = new BufferedReader(fr);
		for(int i = 0 ; i<= 14 ; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int o = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			Instruction inst = new Instruction(s,o,n,c);
			instruction_set.add(inst);
		}

	}
