package com.paracamplus.ilp4.ilp4tme8.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTvisitor;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASThasProperty;

public class ASThasProperty extends ASTexpression implements IASThasProperty {

	private final IASTexpression object;
	private final IASTexpression property;

	
	
	public ASThasProperty(IASTexpression object, IASTexpression property) {
		super();
		this.object = object;
		this.property = property;
	}

	@Override
	public IASTexpression getObject() {
		return object;
	}

	@Override
	public IASTexpression getProperty() {
		return property;
	}
	
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
		return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
	}

}
