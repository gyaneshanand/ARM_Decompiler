//Node.java
//suyash singh
//2016105
import java.lang.*;
import java.util.*;
import java.io.*;
public class Node{
	public String instruction_type; 
	public String instruction_name;
	public String operand1;
	public String operand2;
	public boolean leader;  
	public Node(String instruction_type,String instruction_name,String operand1,String operand2,boolean leader){
		this.instruction_type=instruction_type;
		this.instruction_name=instruction_name;
		this.operand1=operand1;
		this.operand2=operand2;
		this.leader=leader;
	}