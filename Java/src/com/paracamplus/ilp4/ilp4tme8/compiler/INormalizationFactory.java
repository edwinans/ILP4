/* *****************************************************************
 * ilp4 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp4
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp4.ilp4tme8.compiler;


import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface INormalizationFactory extends com.paracamplus.ilp4.compiler.normalizer.INormalizationFactory {
	IASTexpression newReadProperty(IASTexpression object, IASTexpression property);
	IASTexpression newWriteProperty(IASTexpression object, IASTexpression property, IASTexpression value);
	IASTexpression newHasProperty(IASTexpression object, IASTexpression property);
}
