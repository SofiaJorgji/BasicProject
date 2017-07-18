package com.sqa.sj;

public abstract class AbstractTestOperation implements ITestOperation {

	@Override
	public void performTest() {
		System.out.println(this.getClass().getSimpleName() + " perform a test operation");
	}
}