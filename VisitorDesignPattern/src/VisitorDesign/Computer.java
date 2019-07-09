package VisitorDesign;

public class Computer implements ComputerPart {
	ComputerPart[] computerPart;
	
	public Computer() {
		computerPart=new ComputerPart[] {new Mouse(),new  Keyboard(),new Monitor()};
	}

	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {	
		// TODO Auto-generated method stub
		for(int i=0;i<computerPart.length;i++) {
			computerPart[i].accept(computerPartVisitor);
		}
		computerPartVisitor.visit(this);
	}
}
