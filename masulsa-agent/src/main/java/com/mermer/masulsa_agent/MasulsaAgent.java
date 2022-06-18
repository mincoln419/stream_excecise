package com.mermer.masulsa_agent;

import java.lang.instrument.Instrumentation;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType.Builder;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * Hello world!
 *
 */
public class MasulsaAgent {
	public static void premain(String agentArgs, Instrumentation inst) {
		new AgentBuilder.Default()
		.type(ElementMatchers.any())
		.transform(
				(builder,  typeDescription, classLoader,module) 
				-> builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit!!"))
		).installOn(inst);
	}
}
