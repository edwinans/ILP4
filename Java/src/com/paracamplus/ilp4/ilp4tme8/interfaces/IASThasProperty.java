package com.paracamplus.ilp4.ilp4tme8.interfaces;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASThasProperty extends IASTexpression {
	IASTexpression getObject();
	IASTexpression getProperty();
}
