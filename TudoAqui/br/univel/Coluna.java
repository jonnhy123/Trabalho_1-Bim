package br.univel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//RetentionPolicy.RUNTIME ser� gravada na classe e utilizada pela VM, assim, pode ser lida por reflex�o
@Target(ElementType.FIELD)
//@Target serve para indicar o alvo desta anota��o

public @interface Coluna {
		
	String nome() default "";
	int tamanho() default -1;
	boolean pk() default false;
	
}
