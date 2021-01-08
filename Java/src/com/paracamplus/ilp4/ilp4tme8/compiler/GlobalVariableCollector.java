/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.ilp4tme8.compiler;

import java.util.Set;

import com.paracamplus.ilp1.compiler.interfaces.IASTCglobalVariable;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASThasProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTvisitor;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTwriteProperty;
import com.paracamplus.ilp1.compiler.CompilationException;

public class GlobalVariableCollector extends com.paracamplus.ilp4.compiler.GlobalVariableCollector
		implements IASTvisitor<Set<IASTCglobalVariable>, Set<IASTCglobalVariable>, CompilationException> {

	@Override
	public Set<IASTCglobalVariable> visit(IASTreadProperty iast, Set<IASTCglobalVariable> result)
			throws CompilationException {
		result = iast.getObject().accept(this, result);
		result = iast.getProperty().accept(this, result);

		return result;
	}

	@Override
	public Set<IASTCglobalVariable> visit(IASTwriteProperty iast, Set<IASTCglobalVariable> result)
			throws CompilationException {
		result = iast.getObject().accept(this, result);
		result = iast.getProperty().accept(this, result);
		result = iast.getValue().accept(this, result);
		return result;
	}

	@Override
	public Set<IASTCglobalVariable> visit(IASThasProperty iast, Set<IASTCglobalVariable> result)
			throws CompilationException {
		result = iast.getObject().accept(this, result);
		result = iast.getProperty().accept(this, result);

		return result;
	}
}
