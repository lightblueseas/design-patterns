/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.design.pattern.builder;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

/**
 * The class {@link CarTest} is the unit test class for the class {@link Car}.
 */
public class CarTest
{

	/**
	 * Test build car.
	 */
	@Test
	public void testBuildCar()
	{
		// create the builder object...
		final Car.Builder builder = Car.builder("Lamborgini");
		// create Car object using the builder...
		final Car lamborgini = builder.model("Diablo").constructionYear(2006).build();

		String expectedType = "Lamborgini";
		String expectedModel = "Diablo";
		int expectedConstructionYear = 2006;
		String actualType = lamborgini.getType();
		String actualModel = lamborgini.getModel();
		int actualConstructionYear = lamborgini.getConstructionYear();
		AssertJUnit.assertTrue("The expected type from the car object was " + expectedType
			+ " but is " + actualType + ".", actualType.equals(expectedType));
		AssertJUnit.assertTrue("The expected model from the car object was " + expectedModel
			+ " but is " + actualModel + ".", actualModel.equals(expectedModel));
		AssertJUnit.assertTrue(
			"The expected constructionYear from the car object was " + expectedConstructionYear
				+ " but is " + actualConstructionYear + ".",
			actualConstructionYear == expectedConstructionYear);
		// create Car object with the static builder object...
		final Car ferrari = Car.builder("Ferrari").model("F40").constructionYear(1992).build();

		expectedType = "Ferrari";
		expectedModel = "F40";
		expectedConstructionYear = 1992;
		actualType = ferrari.getType();
		actualModel = ferrari.getModel();
		actualConstructionYear = ferrari.getConstructionYear();
		AssertJUnit.assertTrue("The expected type from the car object was " + expectedType
			+ " but is " + actualType + ".", actualType.equals(expectedType));
		AssertJUnit.assertTrue("The expected model from the car object was " + expectedModel
			+ " but is " + actualModel + ".", actualModel.equals(expectedModel));
		AssertJUnit.assertTrue(
			"The expected constructionYear from the car object was " + expectedConstructionYear
				+ " but is " + actualConstructionYear + ".",
			actualConstructionYear == expectedConstructionYear);
	}

}
