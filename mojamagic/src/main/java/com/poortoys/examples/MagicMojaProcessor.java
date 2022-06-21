package com.poortoys.examples;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;

import com.google.auto.service.AutoService;

@AutoService(Process.class)
public class MagicMojaProcessor extends AbstractProcessor {

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Magic.class);
		
		elements.stream().filter(e -> e.getKind() != ElementKind.INTERFACE)
		.forEach(e -> {
			processingEnv.getMessager().printMessage(Kind.ERROR, "Magic annotation can not be used on " + e.getKind());
		});
		
		return true;
	}
	
	@Override
	public Set<String> getSupportedAnnotationTypes() {
		return Set.of(Magic.class.getName());
	}

	
	@Override
	public SourceVersion getSupportedSourceVersion() {
		return SourceVersion.latestSupported();
	}
}
