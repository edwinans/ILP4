package com.paracamplus.ilp4.ilp4tme8.ast;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTfactory;

public class ASTfactory extends com.paracamplus.ilp4.ast.ASTfactory implements IASTfactory {

	@Override
	public IASTexpression newReadProperty(IASTexpression object, IASTexpression property) {
		return new ASTreadProperty(object, property);
	}

	@Override
	public IASTexpression newWriteProperty(IASTexpression object, IASTexpression property, IASTexpression value) {
		return new ASTwriteProperty(object, property, value);
	}

	@Override
	public IASTexpression newHasProperty(IASTexpression object, IASTexpression property) {
		return new ASThasProperty(object, property);
	}

}
