package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		CodingExamA c = new CodingExamA();
	}
	CodingExamA(){
		int numBots = Integer.parseInt(JOptionPane.showInputDialog("Number of Robots"));
		String color = JOptionPane.showInputDialog("Color of shapes(red or blue)");
		int sides = Integer.parseInt(JOptionPane.showInputDialog("Number of sides"));
		for (int i = 0; i < numBots; i++) {
			int x = i*25*sides+100;
			Thread t = new Thread(()->{
				Robot r = new Robot();
				r.setX(x);
				r.setY(100);
				r.penDown();
				r.setSpeed(100);
				if (color.equals("red")) {
					r.setPenColor(Color.RED);
				}
				else {
					r.setPenColor(Color.BLUE);
				}
				for (int j = 0; j < sides; j++) {
					r.turn(360/sides);
					r.move(50);
				}
			});
			t.start();
	}
}
}
