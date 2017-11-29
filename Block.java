import java.util.*;
import java.io.*;

public class Block
{	
	ArrayList<Block> in_blocks;
	ArrayList<Block> out_blocks;
	ArrayList<Node> nodes;
	String label;
	public Block()
	{
		in_blocks = new ArrayList<Block>();
		out_blocks = new ArrayList<Block>();
		nodes = new ArrayList<Node>();
		label = "";

	}
	public void addnode(Node n)
	{
		this.nodes.add(n);
	}
}
