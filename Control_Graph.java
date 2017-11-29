import java.util.*;
import java.io.*;

public class Control_Graph
{
	static Instruction inst_list;
	static ArrayList<Node> player;
	Control_Graph() throws IOException,FileNotFoundException
	{
		inst_list = new Instruction();
		inst_list.instruction_generator();
		player = new ArrayList<Node>();
	}
	public static void assign_leader()
	{
		player.get(0).leader = true;
		for(int i=1;i<player.size();i++)
		{
			if(player.get(i).instruction_type.equals("J"))
			{
				player.get(i).leader = true;
				if(i+1 < player.size())
				{
					player.get(i+1).leader = true;
				}
			}
		}

	}
	public static void print()
	{
		for(int i=0;i<player.size();i++)
		{
			System.out.println(player.get(i).operand1+" "+player.get(i).operand2+" "+player.get(i).destination+" "+player.get(i).leader + " " +player.get(i).instruction_type );
		}
	}
	public static void main(String [] args) throws IOException
	{
		FileReader fr = new FileReader("sample.txt");
		BufferedReader br = new BufferedReader(fr);
		String s;
		Control_Graph c = new Control_Graph();
		while((s = br.readLine())!=null)
		{
			StringTokenizer st = new StringTokenizer(s);
			String type = "";
			int op = -1;
			int num=0;
			String inst = st.nextToken();
			String parse = st.nextToken();
			Node temp = new Node();
			for(int i=0;i<inst_list.instruction_set.size();i++)
			{
				if(inst_list.instruction_set.get(i).inst_name.equals(inst))
				{
					type = inst_list.instruction_set.get(i).inst_type;
					op = inst_list.instruction_set.get(i).opcode;
					temp = new Node(op , type);
					num = inst_list.instruction_set.get(i).no_operands;
					break;
				}
			}
			StringTokenizer st1 = new StringTokenizer(parse,",");
			if(num==3)
			{
				 temp.generate_node(st1.nextToken(),st1.nextToken(),st1.nextToken());
			}
			else if(num==2)
			{
				temp.generate_node(st1.nextToken(),st1.nextToken(),null);
			}
			else
			{
				temp.generate_node(st1.nextToken(),null,null);	
			}
			player.add(temp);
		}
		print();
		assign_leader();
		print();
	}
} 