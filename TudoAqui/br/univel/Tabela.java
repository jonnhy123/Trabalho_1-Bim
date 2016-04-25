package br.univel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//RetentionPolicy.RUNTIME ser� gravada na classe e utilizada pela VM,
//assim, pode ser lida por reflex�o
@Target(ElementType.TYPE)
//ElementType.TYPE ser� uma anota��o de classe, interface ou enum
public @interface Tabela {

	String valor() default "";
	
}
