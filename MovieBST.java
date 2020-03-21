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
		}
		
		else {
			Movie focusNode = root;
			Movie parent;
			while(true) {
				parent = focusNode;
				if(movieId < focusNode.getMovieId()) {//compare parent's id with the focusNode
					
					if(focusNode.leftChild == null) {//if the focusNode's left child is empty
						parent.leftChild = newMovie;//create one		
						return;
					}
					focusNode = focusNode.leftChild;
				}
				else {
					if(focusNode.rightChild == null) {//if the focusNode's right child is empty
						parent.rightChild = newMovie;//create one
						return;
					}
					focusNode = focusNode.rightChild;
				}
			}
		}
	
	}
	
	public void inOrderTravarseTree(Movie focusNode) {
		if(focusNode == null) {
			return;		}
		else {
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
		//Scanner scanner = new Scanner(new File("movies.csv"));
		MovieBST movieTree = new MovieBST();//create a BST
		bufferedReader.readLine();//skip heading
		//bufferedReader.nextLine();
		
		//while(scanner.hasNext()) {
		String str;
			while((str=bufferedReader.readLine()) != null) {//readLines() is Scanner's hasNext() but it must be assigned to a string and checked if null 
				//read in the line then check if its null
				String[] theLineParsed= str.split(",");//split the line by the commas (,)
				int movieId=0;
				String title=null;
				int releaseYear=0;
				String[] genres=null;
				
				for(int i = 0; i< theLineParsed.length; i++) {
					
					if(i == 0)//movie Ids
						movieId = Integer.parseInt(theLineParsed[i]);
					
					if(i == 1) {// Title and Year
						
						String[] titleAndYear = theLineParsed[i].split("\\(");
						//before: title(year)
						//after: title year) removes the open parantheses
						
						title = titleAndYear[0];//only title
						String[] tempYear = titleAndYear[1].split("\\)");
						//before: title year)
						//after: title year removes the closed parantheses
						releaseYear = Integer.parseInt(tempYear[0]);//only the year
					}
					
					if(i == 2) {// Genres
						String listOfGenres = theLineParsed[i];
						genres = listOfGenres.split("\\|");
						for(int h = 0; h < genres.length; h++)
						//System.out.println("length of genres is: "+genres.length);
							//System.out.print(genres[h]+" ");
						System.out.println();
					}
					
				}//End of for loop

			movieTree.addNode(movieId, title, releaseYear, genres);//create a new Node using the new information
		}//End of while loop
		
		
		movieTree.inOrderTravarseTree(movieTree.root);
		//the root is the first node so there will never be a left child
		//need to choose middle node as root
	
		bufferedReader.close();
		//scanner.close();
	
	}
}
