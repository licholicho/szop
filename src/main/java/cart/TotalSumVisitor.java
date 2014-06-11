package cart;


class TotalSumVisitor extends AuxVisitor {
	double overallSum = 0;

	@Override
	public void visit(Visitable p, int sign) {
		overallSum += p.getPrice()*sign;
	}
	
	public double overallSum() {
		return overallSum;
	}


}