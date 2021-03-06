/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 */
package binarytree;

import java.io.*;
import java.util.*;

/**
 *
 * @author michaelghattas
 */
//THE BASIC BUILDING BLOCK OF A TREE, THE NODE
class node {

    int data;
    node rightNode;
    node leftNode;
    
    //PRINT DATA STORED IN THE NODE
    public void displayNode() // display ourself
    {
        System.out.println(data);
    }
}

//THE TREE, WITH AN APPLE
class tree {

    node root;

    public tree() {
        root = null;
    }

    /**
     * *******************************
     * INSERT ******************************
     */
    //CHECK IF ITS FIRST ELEMENT TO BE INSERTED
    public void insert(int data) {
        node current;
        if (root == null) {
            current = new node();
            current.data = data;
            root = current;
        } else {
            insertNode(data, root);
        }

    }

    //IF NOT FIRST ELEMENT FIND THE POSITION TO INSERT DATA
    public void insertNode(int data, node insertNode) {
        node current;

        //CHECK WETHER TO INSERT TO THE RIGHT NODE
        if (data > insertNode.data) {
            if (insertNode.rightNode == null) {
                current = new node();
                current.data = data;
                insertNode.rightNode = current;
            } else {
                insertNode(data, insertNode.rightNode);
            }
            //CHECK WETHER TO INSERT TO THE LEFT NODE
        } else {
            if (insertNode.leftNode == null) {
                current = new node();
                current.data = data;
                insertNode.leftNode = current;
            } else {
                insertNode(data, insertNode.leftNode);
            }
        }
    }

    /**
     * *******************************
     * SEARCH TREE ******************************
     */
    //SEARCH FOR A NODE WITH THE DATA PASSED
    public node search(int data) {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }

        //CURENT NODE IS EQUAL TO ROOT
        node currentNode = root;

        //LOOP TO GO THROUGH TREE
        while (true) {
            if (currentNode == null) {
                System.out.println("\nDATA = " + data + " DOES NOT EXITS");
                return currentNode;
            }
            if (currentNode.data == data) {
                System.out.println("\nDATA = " + data + " EXISTS");
                return currentNode;
            }

            if (data > currentNode.data) {
                currentNode = currentNode.rightNode;
            } else {
                currentNode = currentNode.leftNode;
            }
        }
    }

    //SEARCH THE PARENT OF THE CURRENT NODE
    public node searchParent(int data) {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }

        //CURENT NODE IS EQUAL TO ROOT
        node currentNode = root;
        node parentNode = root;
        
        //LOOP TO GO THROUGH TREE
        while (true) {
            if (currentNode == null) {
                System.out.println("\nDATA = " + data + " DOES NOT EXITS");
                return parentNode;
            }
            if (currentNode.data == data) {
                System.out.println("\nDATA = " + data + " EXISTS");
                return parentNode;
            }

            if (data > currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.rightNode;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.leftNode;
            }
        }
    }

    //SEARCH FOR MAX NUMBER
    public node searchMaxNode(node node) {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }

        node currentNode;
        if (node == null) {
            currentNode = root;
        } else {
            currentNode = node;
        }

        while (true) {
            if (currentNode.rightNode == null) {
                System.out.println("MAX DATA = " + currentNode.data);
                return currentNode;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
    }

    //SEARCH FOR MAX NUMBER AND RETURN DEPTH
    public int searchMaxNodeDepth() {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return 0;
        }

        node currentNode = root;

        int counter = 0;

        while (true) {
            counter++;
            if (currentNode.rightNode == null) {
                System.out.println("MAX DATA = " + currentNode.data);
                return counter;
            } else {
                currentNode = currentNode.rightNode;
            }
        }
    }

    //SEARCH FOR LEAST DATA
    public node searchMinNode(node node) {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return null;
        }

        node currentNode;
        if (node == null) {
            currentNode = root;
        } else {
            currentNode = node;
        }

        while (true) {
            if (currentNode.leftNode == null) {
                System.out.println("MIN DATA = " + currentNode.data);
                return currentNode;
            } else {
                currentNode = currentNode.leftNode;
            }
        }
    }

    //SEARCH FOR LEAST DATA
    public int searchMinNodeDepth() {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return 0;
        }

        node currentNode = root;

        int counter = 0;

        while (true) {
            counter++;
            if (currentNode.leftNode == null) {
                System.out.println("MIN DATA = " + currentNode.data);
                return counter;
            } else {
                currentNode = currentNode.leftNode;
            }
        }
    }
    int counter = 0;

    //FIND DEPTH OF THE TREE
    public int findTreeDepth(node node) {

        if (node == null) {
            return 0;
        } else {
            counter++;
            //System.out.print(node.data + " ");
            int lDepth = findTreeDepth(node.leftNode);
            int rDepth = findTreeDepth(node.rightNode);
            
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }

        }
    }

    /* *******************************
     * DELETE NODE 
     ********************************/
    
//DELETE NODE WITH DATA 
    public void delete(int data) {

        //CHECK IF TREE IS EMPTY 
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        node parentToDelete = searchParent(data);
        node nodeToDelete = search(data);

        if (nodeToDelete == null) {
            System.out.println("NODE DOES NOT EXIST");
            return;
        } else {
            System.out.println("DELETING NODE WITH DATA = " + nodeToDelete.data);
        }

        if (nodeToDelete.leftNode == null && nodeToDelete.rightNode == null) {

            if (nodeToDelete == parentToDelete.leftNode) {
                parentToDelete.leftNode = null;
            } else if (nodeToDelete == parentToDelete.rightNode) {
                parentToDelete.rightNode = null;
            } else {
                System.out.println("ERROR");
                return;
            }

            System.out.println("1- NODE WITH DATA = " + data + " IS DELETED");
        } else if (nodeToDelete.leftNode == null) {

            if (nodeToDelete == parentToDelete.leftNode) {
                parentToDelete.leftNode = nodeToDelete.rightNode;
            } else if (nodeToDelete == parentToDelete.rightNode) {
                parentToDelete.rightNode = nodeToDelete.rightNode;
            } else {
                System.out.println("ERROR");
                return;
            }

            nodeToDelete.rightNode = null;
            System.out.println("2- NODE WITH DATA = " + data + " IS DELETED");
        } else if (nodeToDelete.rightNode == null) {

            if (nodeToDelete == parentToDelete.leftNode) {
                parentToDelete.leftNode = nodeToDelete.leftNode;
            } else if (nodeToDelete == parentToDelete.rightNode) {
                parentToDelete.rightNode = nodeToDelete.leftNode;
            } else {
                System.out.println("ERROR");
                return;
            }

            nodeToDelete.leftNode = null;
            System.out.println("3- NODE WITH DATA = " + data + " IS DELETED");
        } else {
            node temp = searchMinNode(nodeToDelete.rightNode);
            node tempParent = searchParent(temp.data);

            nodeToDelete.data = temp.data;

            if (temp == tempParent.rightNode) {
                tempParent.rightNode = null;
            } else if (temp == tempParent.leftNode) {
                tempParent.leftNode = null;
            } else {
                System.out.println("ERROR");
            }

            System.out.println("4- NODE WITH DATA = " + data + " IS DELETED");

        }

    }

    /**
     * *******************************
     * TRAVERSAL METHODS ******************************
     */
    public void inOrder(node node) {
        if (node != null) {
            inOrder(node.leftNode);
            System.out.print(node.data + " ");
            inOrder(node.rightNode);
        }
    }

    public void preOrder(node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.leftNode);
            preOrder(node.rightNode);
        }
    }

    public void postOrder(node node) {
        if (node != null) {
            postOrder(node.leftNode);
            postOrder(node.rightNode);
            System.out.print(node.data + " ");
        }
    }

}

public class BinaryTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int value;
        tree theTree = new tree();

        theTree.insert(50);
        theTree.insert(25);
        theTree.insert(75);
        theTree.insert(12);
        theTree.insert(37);
        theTree.insert(43);
        theTree.insert(30);
        theTree.insert(33);
        theTree.insert(87);
        theTree.insert(93);
        theTree.insert(94);
        theTree.insert(34);
        theTree.insert(86);
        theTree.insert(234);
        theTree.insert(324);
        theTree.insert(23);
        theTree.insert(99);
        theTree.insert(1234);
        theTree.insert(1235);
        theTree.insert(1236);
        theTree.insert(1237);
        theTree.insert(2345);
        theTree.insert(1234);
        theTree.insert(3123);
        theTree.insert(12313);
        theTree.insert(12357);

        while (true) {
            System.out.println("Enter first letter of show parent, insert, find, delete, or traverse and hit enter");
            int choice = 0;
            try {
                choice = getChar();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (choice) {
                case 's':
                    System.out.println("Enter value to find parent: ");
                    try {
                        value = getInt();
                        node found = theTree.searchParent(value);
                        if (found != null) {
                            System.out.print("Found: ");
                            found.displayNode();
                            System.out.print("\n");
                        } else {
                            System.out.print("Could not find ");
                        }
                        System.out.print(value + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 'i':
                    System.out.print("Enter value to insert: ");
                    try {
                        value = getInt();
                        theTree.insert(value);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 'f':
                    System.out.println("Enter value to find: ");
                    try {
                        value = getInt();
                        node found = theTree.search(value);
                        if (found != null) {
                            System.out.print("Found: ");
                            found.displayNode();
                            System.out.print("\n");
                        } else {
                            System.out.print("Could not find ");
                        }
                        System.out.print(value + '\n');
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case 'd':
                    System.out.println("Enter value to delete: ");
                    try {
                        value = getInt();
                        theTree.delete(value);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 't':
                    System.out.println("Enter type 1 for pre-order, 2 for in-order or 3 post-order: ");
                    try {
                        value = getInt();

                        if (value == 1) {
                            theTree.preOrder(theTree.root);
                        } else if (value == 2) {
                            theTree.inOrder(theTree.root);
                        } else if (value == 3) {
                            theTree.postOrder(theTree.root);
                        } else {
                            System.out.println("VALUE NOT 1,2,3");
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                case 'a':

                    int depth = theTree.findTreeDepth(theTree.root);
                    System.out.println("Maximum depth = "+depth);

                    break;
                default:
                    System.out.print("Invalid entry\n");
            }
        }
    }

    // -------------------------------------------------------------
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
// -------------------------------------------------------------

    public static char getChar() throws IOException {
        String s = getString();
        return s.charAt(0);
    }
//-------------------------------------------------------------

    public static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }
}
