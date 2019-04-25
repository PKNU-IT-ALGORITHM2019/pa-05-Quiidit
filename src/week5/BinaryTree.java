package week5;

public class BinaryTree {
	public Node root=null;

	public Node insertKey(Node root, String w, String c, String m) {
		Node p = root;
		Node newNode = new Node(w,c,m);
	
//		Node tmp = null;
//		Node head = root;
//		
//		while(head != null) {
//			tmp = head;
//			if(newNode.Word.compareTo(head.Word)<0)
//				head = head.left;
//			else
//				head = head.right;
//		}
//		newNode.parent = tmp;
		
		if(p==null){
			return newNode;
		}else if(p.Word.compareTo(newNode.Word) > 0){
			p.left = insertKey(p.left, w, c, m);
			p.left.parent = p;
			return p;
		}else if(p.Word.compareTo(newNode.Word) <= 0){
			p.right = insertKey(p.right, w, c, m);
			p.right.parent = p;
			return p;
		}else{ 
			return p;
		}
	}
	public void insertBST(String w, String c, String m){
		root = insertKey(root, w, c, m);
	}
	public int size(Node N) {
		if(N==null)
			return 0;
		return ( 1 + size(N.left)+size(N.right) ) ;
	}
	public Node searchBST(String s){
		Node p = root;
		while(p!=null){
			if(s.compareTo(p.Word) < 0) p = p.left;
			else if(s.compareTo(p.Word) > 0) p = p.right;
			else return p;
		}
		return p;
	}
	public void TreeDelete(Node N) {
		if(N == null)
			return;
		if(N.left == null && N.right == null) { //leaf 노드일때
			if(N != root) {
				if(N.parent.left == N)
					N.parent.left = null;
				else
					N.parent.right = null;
			}
			else
				root = null;
		}
		else if(N.left != null && N.right != null) { //자식이 두명 있을때
			Node SuccessorNode = MinimumKey(N.right);
			String w = SuccessorNode.Word;
			String c = SuccessorNode.Myclass;
			String m = SuccessorNode.Mean;
			TreeDelete(SuccessorNode);
			N.Word = w;
			N.Myclass = c;
			N.Mean = m;
		}
		else{ //자식이 한명만 있을때
			Node ChildNode = new Node();
			if(N.left != null)
				ChildNode = N.left;
			else
				ChildNode = N.right;

			if(N != root) {
				if(N == N.parent.left)
					N.parent.left = ChildNode;
				else
					N.parent.right = ChildNode;
			}
			else {
				root = ChildNode;
			}
		}
	}
	public Node MinimumKey(Node N){
		while(N.left!=null)
		{
			N=N.left;
		}
		return N;
	}
}
