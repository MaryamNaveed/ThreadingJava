public class BST {
	static final int COUNT = 10;
	class Node
	{
		String key;
		Node leftChild, rightChild;

		public Node(String value)
		{
			key = value;
			leftChild=null;
			rightChild = null;
		}
	}
	Node root;
	void insert(String key)
	{
		root = insertRecursively(root, key);
	}
	

	Node insertRecursively(Node root, String key)
	{

//		if(root!=null) {
//			System.out.println("Key: "+ key+" Root Key:"+root.key+"  "+ key.compareToIgnoreCase(root.key));
//		}
		
		if (root == null)
		{
			root = new Node(key);
			return root;
		}

		
		else if (key.compareToIgnoreCase(root.key)<0) 
			root.leftChild = insertRecursively(root.leftChild, key);
		else if (key.compareToIgnoreCase(root.key)>0)
			root.rightChild = insertRecursively(root.rightChild, key);

	
		return root;
	}
	
	public boolean search(String k) {
		
		Node searchNode=searchRecursively(root, k);
		if(searchNode==null) {
			return false;
		}
		return true;
	}
	
	public Node searchRecursively(Node root, String k)
	{
	    
	    if (root==null || k.compareToIgnoreCase(root.key)==0)
	        return root;
	 
	    else if (k.compareToIgnoreCase(root.key)<0)
	       return searchRecursively(root.leftChild, k);
	 
	    
	    	return searchRecursively(root.rightChild, k);
	}
	void inorder()
    {
         inorderRecursively(root);
    }
 
    void inorderRecursively(Node r)
    {
        if (r != null) {
        	inorderRecursively(r.leftChild);
            System.out.println(r.key);
            inorderRecursively(r.rightChild);
        }
    }
    
   

    
}
