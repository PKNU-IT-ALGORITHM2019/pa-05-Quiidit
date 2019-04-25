package week5;

public class Node {
	Node left=null;
	Node right=null;
	Node parent=null;
	
	String Word;
	String Myclass;
	String Mean;
	Node(String w,String c,String m){
		Word=w;
		Myclass=c;
		Mean=m;
	}
	Node(String w){
		Word=w;
	}
	Node(){

	}

}
