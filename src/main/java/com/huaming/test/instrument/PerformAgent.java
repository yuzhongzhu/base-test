package com.huaming.test.instrument;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class PerformAgent {
	static private Instrumentation inst = null;
	public static void premain(String angentArgs,Instrumentation _inst){
		inst = _inst;
		ClassFileTransformer trans  = new PerfMonXformer();
		inst.addTransformer(trans);
	}
}
