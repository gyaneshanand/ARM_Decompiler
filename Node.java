import java.lang.*;
import java.util.*;
import java.io.*;
public class Node{
	String instruction_type; 
	String instruction_name;
	String operand1;
	String operand2;
	String destination;
	boolean leader; 
	int op_code; 
	String label;
	Node()
	{
		
	}
	Node(int op_code , String instruction_type)
	{
		this.op_code = op_code;
		this.instruction_type = instruction_type;
	}
	public void generate_node(String destination , String operand1 , String operand2)
	{
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.destination = destination;
		label="";
	
	}
	public void print()
	{
		System.out.println(operand1+" "+operand2+" "+destination+" "+leader + " " +instruction_type+ " " +label+" "+instruction_name );
	}
}