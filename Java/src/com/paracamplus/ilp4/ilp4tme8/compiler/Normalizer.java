/* *****************************************************************
 * ilp4 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp4
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.ilp4tme8.compiler;



import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp4.compiler.interfaces.IASTCclassDefinition;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASThasProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTvisitor;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTwriteProperty;
import com.paracamplus.ilp1.interfaces.IASTexpression;


public class Normalizer extends com.paracamplus.ilp4.compiler.normalizer.Normalizer
		implements IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException> {

	public Normalizer(INormalizationFactory factory, IASTCclassDefinition objectClass) {
		super(factory, objectClass);
	}

	@Override
	public IASTexpression visit(IASTreadProperty iast, INormalizationEnvironment env) throws CompilationException {
		IASTexpression newObject = iast.getObject().accept(this, env);
		IASTexpression newProperty = iast.getProperty().accept(this, env);
		
		return ((INormalizationFactory)factory).newReadProperty(newObject, newProperty);
	}

	@Override
	public IASTexpression visit(IASTwriteProperty iast, INormalizationEnvironment env) throws CompilationException {
		IASTexpression newObject = iast.getObject().accept(this, env);
		IASTexpression newProperty = iast.getProperty().accept(this, env);
		IASTexpression newValue = iast.getProperty().accept(this, env);
		
		return ((INormalizationFactory)factory).newWriteProperty(newObject, newProperty, newValue);
	}

	@Override
	public IASTexpression visit(IASThasProperty iast, INormalizationEnvironment env) throws CompilationException {
		IASTexpression newObject = iast.getObject().accept(this, env);
		IASTexpression newProperty = iast.getProperty().accept(this, env);
		
		return ((INormalizationFactory)factory).newHasProperty(newObject, newProperty);
	}

}
