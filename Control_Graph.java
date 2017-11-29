import java.util.*;
import java.io.*;

public class Control_Graph
{
	static Instruction inst_list;
	static ArrayList<Node> player;
	static ArrayList<Block> block_list;
	Control_Graph() throws IOException,FileNotFoundException
	{
		inst_list = new Instruction();
		inst_list.instruction_generator();
		player = new ArrayList<Node>();
		block_list = new ArrayList<Block>();
	}
	public static void assign_leader()
	{
		player.get(0).leader = true;
		for(int i=1;i<player.size();i++)
		{
			if(player.get(i).instruction_type.equals("J"))
			{
				//player.get(i).leader = true;
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
			player.get(i).print();
		}
	}
	public static void print1()
	{
		for(int j=0;j<block_list.size();j++)
		{
			for(int i=0;i<block_list.get(j).nodes.size();i++)
			{
				System.out.println(block_list.get(j).nodes.get(i).operand1+" "+block_list.get(j).nodes.get(i).operand2+" "+block_list.get(j).nodes.get(i).destination+" "+block_list.get(j).nodes.get(i).leader + " " +block_list.get(j).nodes.get(i).instruction_type +" "+block_list.get(j).label);
			}
			System.out.println();
		}
	}
	public static void print2()
	{
		for(int j=0;j<block_list.size();j++)
		{
			for(int i=0;i<block_list.get(j).out_blocks.size();i++)
			{
				System.out.print(block_list.get(j).out_blocks.get(i).label + " "+j+" ");
			}
			System.out.println();
		}
	}
	public static void generate_controlgraph()
	{
		for(int i=0;i<block_list.size();i++)
		{
			Node temp = block_list.get(i).nodes.get(block_list.get(i).nodes.size()-1);
			if(temp.instruction_type.equals("J"))
			{
				//System.out.println(-1);
				String dest = temp.destination;
				//System.out.println(dest);
				for(int j=0;j<block_list.size();j++)
				{
					if(block_list.get(j).label.equals(dest))
					{
						//System.out.println(0);
						block_list.get(i).out_blocks.add(block_list.get(j));
					}
				}
					
			}
			//System.out.println(1);
			if(i!=block_list.size()-1)
			{
				block_list.get(i).out_blocks.add(block_list.get(i+1));
			}
		}

	}
	public static void main(String [] args) throws IOException
	{
		FileReader fr = new FileReader("sample1.txt");
		BufferedReader br = new BufferedReader(fr);
		String s;
		Control_Graph c = new Control_Graph();
		int t=0;
		String l = "";
		while((s = br.readLine())!=null)
		{
			System.out.println("A");
			StringTokenizer st = new StringTokenizer(s);
			String type = "";
			int op = -1;
			int num=0;
			String inst = st.nextToken();
			String parse = st.nextToken();
			Node temp = new Node();
			if(!parse.equals(":"))
			{
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
				if(t==1)
				{
					temp.leader=true;
					temp.label = l;
					t=0;
					l="";
				}
				player.add(temp);
			}
			else
			{
				t=1;
				l=inst;
			}	
			
		}
		//print();
		assign_leader();
		for(int i=0;i<player.size();i++)
		{
			Block b = new Block();
			b.label = player.get(i).label;
			b.nodes.add(player.get(i));
			for(int j=i+1;j<player.size();j++)
			{
				if(!player.get(j).leader)
				{
					b.nodes.add(player.get(j));
					i = i+1;			
				}
				else
				{
					break;
				}
			}
			block_list.add(b);
		}
		print();
		System.out.println();
		print1();
		generate_controlgraph();
		print2();
	}
} 