package com.paracamplus.ilp4.ilp4tme8.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTfactory extends com.paracamplus.ilp4.interfaces.IASTfactory {
	IASTexpression newReadProperty(IASTexpression object, IASTexpression property);
	IASTexpression newWriteProperty(IASTexpression object, IASTexpression property, IASTexpression value);
	IASTexpression newHasProperty(IASTexpression object, IASTexpression property);
}
