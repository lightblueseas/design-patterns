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
package io.github.astrapi69.design.pattern.strategy;

import static org.testng.AssertJUnit.assertEquals;

import org.testng.annotations.Test;

import io.github.astrapi69.test.object.AlgorithmModel;

/**
 * The class {@link StrategyTest}.
 */
public class StrategyTest
{

	@Test
	public void testStrategy()
	{
		Strategy<Integer, AlgorithmModel> strategy;
		Strategy<Integer, AlgorithmModel> context;
		AlgorithmModel algorithmModel;
		Integer actual;
		Integer expected;
		strategy = new AdditionStrategy();
		context = new Context<>(strategy);
		algorithmModel = AlgorithmModel.builder().a(15).b(5).build();
		actual = context.execute(algorithmModel);
		expected = 20;
		assertEquals(expected, actual);
		strategy = new SubtractionStrategy();
		context = new Context<>(strategy);
		actual = context.execute(algorithmModel);
		expected = 10;
		assertEquals(expected, actual);
		strategy = new MultiplicationStrategy();
		context = new Context<>(strategy);
		actual = context.execute(algorithmModel);
		expected = 75;
		assertEquals(expected, actual);
		strategy = new DivisionStrategy();
		context = new Context<>(strategy);
		algorithmModel = AlgorithmModel.builder().a(15).b(5).build();
		actual = context.execute(algorithmModel);
		expected = 3;
		assertEquals(expected, actual);
	}

}
