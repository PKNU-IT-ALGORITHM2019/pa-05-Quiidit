package week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Pro1 {   
	Scanner kb= new Scanner(System.in);
	public int size = 0;
	public BinaryTree t = new BinaryTree();
	public void Process() {
		ReadText("shuffled_dict.txt");

		while(true) {
			System.out.print("$ ");
			String command=kb.next();
			if(command.equals("size")) {
				int n = t.size(t.root);
				System.out.println(n);
			}
			else if(command.equalsIgnoreCase("find")) {
				String FindWord=kb.next();
				Node FindNode=new Node(FindWord);
				FindNode = t.searchBST(FindWord);
				if(FindNode==null)
					System.out.println("Not Found");
				else
					System.out.println(FindNode.Word+": "+FindNode.Mean);
			}
			else if(command.equalsIgnoreCase("add")) {
				add();
			}
			else if(command.equals("delete")) {
				delete();
			}
			else if(command.equals("deleteall")) {
				deleteall();
			}

			else if(command.equals("exit"))
			{
				break;
			}
		}
	}
	private void deleteall() {
		String FileName=kb.next();
		int cnt=0;
		try {
			Scanner fin = new Scanner (new File(FileName));
			while(fin.hasNext()) {
				String w=fin.nextLine();
				w=w.replaceAll(" ", "");
				Node node=new Node(w," "," ");
				node=t.searchBST(w);
				if(node!=null)
				{
					t.TreeDelete(node);
				}
				cnt++;
			}
			System.out.println(cnt+" words were deleted successfully.");
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("No Files");
		}		
	}
	private void delete() {
		String DeleteWord=kb.next();
		Node N =new Node();
		N=t.searchBST(DeleteWord);
		if(N==null)
			System.out.println("Not Found");
		else {
			t.TreeDelete(N);
		} 		
	}
	private void add() {
		System.out.print("word: ");
		String Word=kb.next();
		String Myclass=kb.nextLine();
		System.out.print("Class: ");
		Myclass=kb.nextLine();
		System.out.print("meaning: ");
		String Mean=kb.next();

		t.insertBST(Word,Myclass,Mean);

	}
	private void ReadText(String TextFile) {
		try {
			Scanner fin = new Scanner(new File(TextFile));
			String sentence;
			while(fin.hasNextLine()) {
				sentence = fin.nextLine();
				tokenize(sentence);      
			}
			fin.close();
		} catch (FileNotFoundException e) {
			System.out.println("No Files");
		}
	}
	private void tokenize(String sentence) {
		int idx1 = sentence.indexOf("(");
		int idx2 = sentence.indexOf(")");
		if(idx1<0 || idx2<0)
			return;
		String word = sentence.substring(0, idx1-1);
		String Myclass = sentence.substring(idx1-1, idx2+1);
		String explain = sentence.substring(idx2+1);
		t.insertBST(word, Myclass, explain);
	}

	public static void main(String[] args) {
		Pro1 app = new Pro1();
		app.Process();
	}

}