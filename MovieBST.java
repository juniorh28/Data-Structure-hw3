//Junior Hernandez

import java.io.*;
import java.util.*;
public class MovieBST {//Binary Search Tree
	private Movie root;// this will be the root of the entire tree
	public Movie getRoot() {return root;}
	public void addNode(int movieId, String title, int releaseYear, String[] genres) {//will add a new node to the tree
		
		Movie newMovie = new Movie(movieId, title, releaseYear, genres);
		if(root == null) {//if the root doesn't exist
			root = newMovie;//create one
			System.out.println(root.toString());
		}
		else {
			Movie focusNode = root;
			Movie parent;
			while(true) {
				parent = focusNode;
				if(movieId < focusNode.getMovieId()) {//compare parent's id with the focusNode
					focusNode = focusNode.leftChild;
					if(focusNode.leftChild == null) {//if the focusNode's left child is empty
						parent.leftChild = newMovie;//create one
						return;
					}
				}
				else {
					focusNode = focusNode.rightChild;
					if(focusNode.rightChild == null) {//if the focusNode's right child is empty
						parent.rightChild = newMovie;//create one
						return;
					}
				}
			}
		}
	
	}
	
	public void inOrderTravarseTree(Movie focusNode) {
		if(focusNode != null) {
			inOrderTravarseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTravarseTree(focusNode.rightChild);
		}
			
	}
	
	public void subSet(String start, String end) {
		
	}
	
	public static void main(String[] args) throws IOException{
		FileReader reader = new FileReader("movies.csv");
		BufferedReader bufferedReader = new BufferedReader(reader);
		//Scanner scanner = new Scanner(new File("C:\\Users\\Junior\\Desktop\\ml-latest-small\\movies.csv"));
		MovieBST movieTree = new MovieBST();//create a BST
		bufferedReader.readLine();//skip heading
		//bufferedReader.nextLine();
		
		//while(scanner.hasNext()) {
			while(bufferedReader.lines() != null) {
			String theLine = bufferedReader.readLine(); //scanner.nextLine();//read in the first line
			String[] theLineParsed= theLine.split(",");//split the line by the commas (,)
			int movieId=0;
			String title=null;
			int releaseYear=0;
			String[] genres=null;
			
			for(int i = 0; i< theLineParsed.length; i++) {
				
				if(i == 0)//movie Ids
					movieId = Integer.parseInt(theLineParsed[i]);
				
				if(i == 1) {// Title and Year
					
					String[] titleAndYear = theLineParsed[i].split("\\(");
					//before: title (year)
					//after: title year) removes the open parantheses
					
					title = titleAndYear[0];//only title
					String[] tempYear = titleAndYear[1].split("\\)");
					//before: title year)
					//after: title year removes the closed parantheses
					releaseYear = Integer.parseInt(tempYear[0]);//only the year
				}
				
				if(i ==3) {// Genres
					String listOfGenres = theLineParsed[i];
					genres = listOfGenres.split("\\|");
				}
				
			}//End of for loop

			
		System.out.println(movieId+" "+title+" "+releaseYear);
		movieTree.addNode(movieId, title, releaseYear, genres);//create a new Node using the new information
		}//End of while loop
		
		
		movieTree.inOrderTravarseTree(movieTree.root);
		//the root is the first node so there will never be a left child
		//need to choose middle node as root
	
		bufferedReader.close();
		//scanner.close();
	
	}
}
