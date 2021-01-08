package com.paracamplus.ilp4.ilp4tme8.interpreter;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASThasProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTreadProperty;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTvisitor;
import com.paracamplus.ilp4.ilp4tme8.interfaces.IASTwriteProperty;
import com.paracamplus.ilp4.interpreter.ILPInstance;
import com.paracamplus.ilp4.interpreter.interfaces.IClassEnvironment;

public class Interpreter extends com.paracamplus.ilp4.interpreter.Interpreter
		implements IASTvisitor<Object, ILexicalEnvironment, EvaluationException>  {

	public Interpreter(IGlobalVariableEnvironment globalVariableEnvironment, IOperatorEnvironment operatorEnvironment,
			IClassEnvironment classEnvironment) {
		super(globalVariableEnvironment, operatorEnvironment, classEnvironment);
	}

	@Override
	public Object visit(IASTreadProperty iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object property = iast.getProperty().accept(this, lexenv);
        if(property instanceof String) {
        	String propertyName = (String) property;
            Object target = iast.getObject().accept(this, lexenv);
            if ( target instanceof ILPInstance ) {
            	try {
                    return ((ILPInstance) target).read(propertyName);
				} catch (Exception e) {
					String msg = "Propery doesn't exists " + propertyName;
	                throw new EvaluationException(msg);
				}
 
            } else {
                String msg = "Not an ILP9 instance " + target;
                throw new EvaluationException(msg);
            }
        }
        else {
        	String msg = "Property is not a string ";
            throw new EvaluationException(msg);
        }

	}

	@Override
	public Object visit(IASTwriteProperty iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object property = iast.getProperty().accept(this, lexenv);
        Object value = iast.getValue().accept(this, lexenv);
        
        if(property instanceof String) {
        	String propertyName = (String) property;
            Object target = iast.getObject().accept(this, lexenv);
            if ( target instanceof ILPInstance ) {
            	try {
            		System.out.println(value);
            		return ((ILPInstance) target).write(propertyName, value);
				} catch (Exception e) {
					String msg = "Propery doesn't exists " + propertyName;
	                throw new EvaluationException(msg);
				}
 
            } else {
                String msg = "Not an ILP9 instance " + target;
                throw new EvaluationException(msg);
            }
        }
        else {
        	String msg = "Property is not a string ";
            throw new EvaluationException(msg);
        }
	}

	@Override
	public Object visit(IASThasProperty iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object property = iast.getProperty().accept(this, lexenv);
        if(property instanceof String) {
        	String propertyName = (String) property;
            Object target = iast.getObject().accept(this, lexenv);
            if ( target instanceof ILPInstance ) {
            	try {
                    ((ILPInstance) target).read(propertyName);
                    return true;
				} catch (Exception e) {
	                return false;
				}
 
            } else {
                String msg = "Not an ILP9 instance " + target;
                throw new EvaluationException(msg);
            }
        }
        else {
        	String msg = "Property is not a string ";
            throw new EvaluationException(msg);
        }
	}

}
