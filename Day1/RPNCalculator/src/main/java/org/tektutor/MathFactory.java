package org.tektutor;

import java.util.HashMap;

public class MathFactory {

	private static HashMap<String, String> classNameMap;

	static {
		classNameMap = new HashMap<String,String>();

		classNameMap.put ( "+", "org.tektutor.Addition" );
		classNameMap.put ( "-", "org.tektutor.Subtraction" );
		classNameMap.put ( "*", "org.tektutor.Multiplication" );
		classNameMap.put ( "/", "org.tektutor.Division" );
	}

	public static MathOperation getMathObject ( String strMathOperator ) {

		MathOperation mathOperation = null;

		try {
			mathOperation = (MathOperation) 
				Class.forName ( classNameMap.get ( strMathOperator ) ).newInstance(); 
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}

		return mathOperation;

	}
}
