package com.example;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ComponentScan(basePackages = { "com.example" })
class SpringContextAOP {

}

@Aspect
@Component
class AspectExample {

	@Before("execution(* com.example.Example.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("Before - " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* com.example.Example.*(..))")
	public void after(JoinPoint joinPoint) {
		System.out.println("After - " + joinPoint.getSignature().getName());
	}
}

@Component
class Example {

	public void sayHi() {
		System.out.println("Hi World");
	}

	public void sayHello() {
		System.out.println("Hello World");
	}
}

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringContextAOP.class)
public class AopExampleApplicationTests {

	@Autowired
	private Example example;

	@Test
	public void contextLoads() {

		example.sayHi();
		example.sayHello();
	}

}
