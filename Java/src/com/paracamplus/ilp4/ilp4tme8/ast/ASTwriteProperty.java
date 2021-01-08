package com.paracamplus.ilp4.ilp4tme8.ast;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTvisitor;

public class ASTwriteProperty extends ASTexpression
		implements com.paracamplus.ilp4.ilp4tme8.interfaces.IASTwriteProperty {

	private final IASTexpression object;
	private final IASTexpression property;
	private final IASTexpression value;
	
	
	
	public ASTwriteProperty(IASTexpression object, IASTexpression property, IASTexpression value) {
		super();
		this.object = object;
		this.property = property;
		this.value = value;
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
	public IASTexpression getValue() {
		return value;
	}
	
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(
			com.paracamplus.ilp1.interfaces.IASTvisitor<Result, Data, Anomaly> visitor, Data data) throws Anomaly {
		return ((IASTvisitor<Result, Data, Anomaly>) visitor).visit(this, data);
	}


}
