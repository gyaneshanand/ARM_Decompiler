//Instruction.java

import java.lang.*;
import java.util.*;
import java.io.*;

public class Instruction
{
	ArrayList<Instruction> instruction_set;

	String inst_name; 
	int opcode;
	int no_operands;
	String inst_type;

	public Instruction(String s , int o , int n , String c)
	{
		this.inst_name = s;
		this.opcode = o ;
		this.no_operands = n ;
		this.inst_type = c;
	}
	public Instruction()
	{
		instruction_set = new ArrayList<Instruction>();
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


/*public static void main(String[] args)throws IOException {
	Instruction inst = new Instruction();
	inst.instruction_generator();
	for(int i = 0 ; i<= 14 ; i++)
		{
			System.out.println(inst.Instruction_set.get(i).inst_name);
		}*/


}