package br.univel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//RetentionPolicy.RUNTIME será gravada na classe e utilizada pela VM, assim, pode ser lida por reflexão
@Target(ElementType.FIELD)
//@Target serve para indicar o alvo desta anotação

public @interface Coluna {
		
	String nome() default "";
	int tamanho() default -1;
	boolean pk() default false;
	
}
