package pkg1;

import java.awt.Rectangle;
import java.util.ArrayList;
//import java.util.HashMap;

import javax.swing.JOptionPane;

public class HashMapClass {

	public static void main(String[] args) {
		
		ArrayList <Rectangle> rectangles= new ArrayList <>(3); 

		int length;
		int width;

		for(int index =0; index <3;index++)
		{
			JOptionPane.showMessageDialog(null, "Rectangle " + (index + 1));
			
		
		 
		 length = Integer.parseInt(JOptionPane.showInputDialog("Enter length"));
		 width = Integer.parseInt(JOptionPane.showInputDialog("Enter width"));
		// width = JOptionPane.showInputDialog("Enter width");
		 
		 //Now I will create my Rectangle and add it to my rectangles ArrayList:

		 rectangles.add(new Rectangle(length,width));
		 int res = length + width;
		 JOptionPane.showInputDialog("print",res);
		 System.out.println(res);
		 
		  
		 //rectangles.add(new Rectangle(length,width));

		//This passes the length and width values to the rectangle constructor
	}

//		for (int i = 0; i < 10; i++) {
//			HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
//			hashmap.put(i, "parul");
//			System.out.println(hashmap);
//		}
//		System.out.println("valid output is coming");
//	}

}
}
