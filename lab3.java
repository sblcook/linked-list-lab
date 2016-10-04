/*Complete the binary search tree class in BST.java by adding a delete method. 
In the case in which the deleted node has two children, write the code in 
two ways. 

a) always replace the deleted node with the largest node on the left.
b) count how many deletions have been done, and for even deletions
replace the deleted node with the largest node on the left, for odd
deletions, replace the deleted node with the smallest node on the right.

Add a (recursive) method that returns the depth of the tree.

Now do an experiment in which you add 100 random Doubles to the tree, then
repeatedly delete and add values many times. (Keep an array of the numbers currently in the tree and randomly choose an element of the array to delete.)

As you do each random deletion and insertion, note the depth of the tree, and
create a graph (using Excel?) that shows how the tree's depth changes.

Do this epxperiment for each of the deletion strategies a) and b).  How do
the graphs differ?
*/

public class lab3{

	public static void main(String []args)throws BSTException{
		BST<Integer> ibst = new BST<Integer>();

	    ibst.insert(50);
	    ibst.insert(20);
	    ibst.insert(30);
	    ibst.insert(10);
	    ibst.insert(70);
	    ibst.insert(60);
	    ibst.insert(80);
	    
	    System.out.println(ibst);
	    System.out.println();
	    System.out.println();
	    System.out.println(ibst.lookup(60));
	    System.out.println(ibst.lookup(25));
	   
	    BST<String> sbst = new BST<String>();
	    sbst.insert("beetle");
	    sbst.insert("catapult");
	    sbst.insert("dog");
	    sbst.insert("wombat");
	    sbst.insert("horse");
	    sbst.insert("cat");
	    sbst.insert("horseradish");
	    sbst.insert("caterwaul");
	    sbst.insert("cow");
	    sbst.insert("sloth");
	    System.out.println(sbst);
	}
}

class BST<T extends Comparable<T>> 
{
  private Node<T> root;

  public BST()
  {
    this.root = null;
  }

  public void insert(T datum) throws BSTException
  {
    this.root = insert(this.root, datum);
  }

  private Node<T> insert(Node<T> r, T datum) throws BSTException
  {
    if( r == null)
    {
      return new Node<T>(datum);
    }
    else
    {
      int sign = r.getData().compareTo(datum);
      if(sign == 0)
      {
        throw new BSTException("Duplicate Entry " + datum);
      }
      else if(sign > 0)
      {
        r.setLeft(insert(r.getLeft(), datum));
      }
      else
      {
        r.setRight(insert(r.getRight(), datum));
      }
      return r;
    }
  }

  public T lookup(T target)
  {
    Node<T> where = root;
    T retval = null;

    while (where != null && retval == null)
    {
      int sign = where.getData().compareTo(target);
      if (sign == 0)
        retval = where.getData();
      else if(sign > 0)
        where = where.getLeft();
      else
        where = where.getRight();
    }
    return retval;
  }
 
  public T delete(T target)
  {
    //to be written
    return target;
  }

  public String toString()
  {
    String retval = "";
    return toString(root, retval);
  }

  public String toString(Node<T> r, String retval)
  {
    if (r == null)
    {
      return retval + "null" + "\n";
    }
    else
    {
      retval += r.getData() + "\n";
      retval = toString(r.getLeft(), retval);
      retval = toString(r.getRight(), retval);
    }
    return retval;
  }
}

class BSTException extends Exception
{
  public BSTException(String s)
  {
    super(s);
  }
}
class Node<T extends Comparable<T>>
{
  private T data;
  private Node<T> left;
  private Node<T> right; 

  public Node(T data, Node<T> left, Node<T> right)
  {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public Node(T data)
  {
    this(data, null, null);
  }

  public T getData()
  {
    return this.data;
  }

  public Node<T> getLeft()
  {
    return this.left;
  }

  public Node<T> getRight()
  {
    return this.right;
  }
   
  public void setLeft(Node<T> left)
  {
    this.left = left;
  }

  public void setRight(Node<T> r)
  {
    this.right = r;
  }
}

