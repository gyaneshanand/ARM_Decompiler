//Node_generator.java

import java.lang.*;
import java.util.*;
import java.io.*;

public class Node_generator
{
	Node inst;
	String output;
	String result;
	String op1;
	String op2;
	String rs;
	String rt;
	String rd;

	int offset;

	ArrayList<String> vars;
	HashMap<String,String> used_vars;

	//Create an object of the node_generator in code_generator and use the generate node method in that.
	public Node_generator(Node n , ArrayList<String> a , HashMap<String,String> v)
	{
		inst = n ;
		vars = a ;
		used_vars = v ;
		output = "";
	}

	public String generate_node()
	{
		rs = inst.operand1;
		rt = inst.operand2;
		rd = inst.destination;

		//Conversion for ADD
		if(inst.op_code==1)
		{
			if(used_vars.containsValue(rs))
			{
				op1 = used_vars.get(rs);
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rt))
			{
				op2 = used_vars.get(rt);
			}
			else if(rt.charAt(0)=='#')
			{
				op2 = rt.substring(1);
			}
			else
			{
				op2 = vars.get(0);
				vars.remove(0);
			}if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1+" + "+op2 ;
		}

		//Conversion for SUB
		if(inst.op_code==2)
		{
			if(used_vars.containsValue(rs))
			{
				op1 = used_vars.get(rs);
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rt))
			{
				op2 = used_vars.get(rt);
			}
			else if(rt.charAt(0)=='#')
			{
				op2 = rt.substring(1);
			}
			else
			{
				op2 = vars.get(0);
				vars.remove(0);
			}if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1+" - "+op2 ;
		}

		//Conversion for MUL
		if(inst.op_code==3)
		{
			if(used_vars.containsValue(rs))
			{
				op1 = used_vars.get(rs);
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rt))
			{
				op2 = used_vars.get(rt);
			}
			else if(rt.charAt(0)=='#')
			{
				op2 = rt.substring(1);
			}
			else
			{
				op2 = vars.get(0);
				vars.remove(0);
			}if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1+" * "+op2 ;
		}

		//Conversion for ADD
		if(inst.op_code==1)
		{
			if(used_vars.containsValue(rs))
			{
				op1 = used_vars.get(rs);
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rt))
			{
				op2 = used_vars.get(rt);
			}
			else if(rt.charAt(0)=='#')
			{
				op2 = rt.substring(1);
			}
			else
			{
				op2 = vars.get(0);
				vars.remove(0);
			}if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1+" + "+op2 ;
		}

		//Conversion for AND
		if(inst.op_code==4)
		{
			if(used_vars.containsValue(rs))
			{
				op1 = used_vars.get(rs);
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rt))
			{
				op2 = used_vars.get(rt);
			}
			else if(rt.charAt(0)=='#')
			{
				op2 = rt.substring(1);
			}
			else
			{
				op2 = vars.get(0);
				vars.remove(0);
			}if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1+" && "+op2 ;
		}

		//Conversion for LDR
		if(inst.op_code==13)
		{
			if(used_vars.containsValue(rs.substring(1,2)))
			{
				op1 = used_vars.get(rs.substring(1,2));
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1 ;
		}

		//Conversion for STR
		if(inst.op_code==14)
		{
			if(used_vars.containsValue(rs.substring(1,2)))
			{
				op1 = used_vars.get(rs.substring(1,2));
			}
			else
			{
				op1 = vars.get(0);
				vars.remove(0);
			}
			if(used_vars.containsValue(rd))
			{
				result = used_vars.get(rd);
			}
			else
			{
				result = vars.get(0);
				vars.remove(0);
			}
			output = result+" = "+op1 ;
		}












		return output;
	}
	





	//{"a","b","c","d","e","f","g","h","i","j","k","l","m"}

	
}