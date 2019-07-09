package VisitorDesign;

public class VisitorPatternTest {
	public static void main(String[] args) {
		Computer computer =new Computer();
		computer.accept(new ComputerPartDisplayVisitor());	
	}
}
