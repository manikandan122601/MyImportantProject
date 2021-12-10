package org.rerunconcept;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgConcept {
	
	@Test
	private void tc33() {
		System.out.println("Test33");
	}
	
	@Test
	private void tc11() {
		System.out.println("Test11");
		Assert.assertTrue(false);
	}
	@Test
	private void tc22() {
		System.out.println("Test22");
		Assert.assertTrue(false, "Test case is failed");
	}

}
