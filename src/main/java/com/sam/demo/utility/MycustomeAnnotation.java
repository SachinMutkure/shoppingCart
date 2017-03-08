package com.sam.demo.utility;

public @interface MycustomeAnnotation {

	public String name() default "";
	public int size()default 0;
}
