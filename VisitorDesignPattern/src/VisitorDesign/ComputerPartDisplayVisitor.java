package VisitorDesign;

public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

	@Override
	public void visit(Computer computer) {
		// TODO Auto-generated method stub
		
		System.out.println("Display Computer");
	}

	@Override
	public void visit(Mouse mouse) {
		// TODO Auto-generated method stub
		
		System.out.println("Display Mouse");
	}

	@Override
	public void visit(Monitor monitor) {
		// TODO Auto-generated method stub
		System.out.println("Display Monitor");
	}

	@Override
	public void visit(Keyboard keyboard) {
		// TODO Auto-generated method stub
		System.out.println("Display keyboard");
	}

}
