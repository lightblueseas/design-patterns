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
package io.github.astrapi69.design.pattern.command;

import io.github.astrapi69.design.pattern.command.api.Command;
import io.github.astrapi69.design.pattern.command.api.Invoker;
import io.github.astrapi69.design.pattern.command.api.Invokers;
import io.github.astrapi69.test.object.Light;


/**
 * The Class DemonstrateCommandPattern.
 */
public class DemonstrateCommandPattern
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args)
	{
		final Invoker<Light> invoker = new Invoker<>();

		final Light light = new Light();

		final Command<Light> lightsOn = new LightOnCommand(light);
		final Command<Light> lightsOff = new LightOffCommand(light);

		// switch on
		invoker.setCommand(lightsOn);
		invoker.invoke();

		// switch off
		invoker.setCommand(lightsOff);
		invoker.invoke();
		// Invoke several commands with a single invokers object...
		final Invokers<Light> invokers = new Invokers<>();
		invokers.add(lightsOn).add(lightsOff);
		invokers.invoke();
	}

}
