/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.ilp4tme8.compiler;



import java.util.Set;


import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.interfaces.IASTClocalVariable;
import com.paracamplus.ilp4.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASThasProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTvisitor;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTwriteProperty;


public class FreeVariableCollector 
extends com.paracamplus.ilp4.compiler.FreeVariableCollector
implements IASTvisitor<Void, Set<IASTClocalVariable>, CompilationException> {

    
    public FreeVariableCollector(IASTCprogram program) {
        super(program);
    }

	@Override
	public Void visit(IASTreadProperty iast, Set<IASTClocalVariable> data) throws CompilationException {
		iast.getObject().accept(this, data);
		iast.getProperty().accept(this, data);
		
		return null;
	}

	@Override
	public Void visit(IASTwriteProperty iast, Set<IASTClocalVariable> data) throws CompilationException {
		iast.getObject().accept(this, data);
		iast.getProperty().accept(this, data);
		iast.getValue().accept(this, data);
		return null;
	}

	@Override
	public Void visit(IASThasProperty iast, Set<IASTClocalVariable> data) throws CompilationException {
		iast.getObject().accept(this, data);
		iast.getProperty().accept(this, data);
		
		return null;
	}
    
    
}
