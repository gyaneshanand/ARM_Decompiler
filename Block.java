import java.util.*;
import java.io.*;

public class Block
{	
	Arraylist<Block> in_blocks;
	Arraylist<Block> out_blocks;
	Arraylist<Node> nodes;

	public Block()
	{
		in_blocks = new Arraylist<Block>();
		out_blocks = new Arraylist<Block>();
		nodes = new Arraylist<Nodes>();

	}
	public void addnode(Node n)
	{
		this.nodes.add(n);
	}
}
