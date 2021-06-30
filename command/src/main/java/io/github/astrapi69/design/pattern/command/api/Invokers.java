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
package io.github.astrapi69.design.pattern.command.api;

import java.util.ArrayList;
import java.util.List;

/**
 * The class {@link Invokers} that have a {@link Command} object to invoke.
 *
 * @param <R>
 *            the generic type of the receiver object.
 */
public class Invokers<R>
{

	/** The command. */
	private List<Command<R>> commands = new ArrayList<>();

	/**
	 * Add a {@link Command} object to the list.
	 *
	 * @param command
	 *            the {@link Command} object to add
	 * @return this object, for chaining
	 */
	public Invokers<R> add(final Command<R> command)
	{
		commands.add(command);
		return this;
	}

	/**
	 * Invoke all commands in the list.
	 */
	public void invoke()
	{
		for (Command<R> command : commands)
		{
			command.execute();
		}
	}
}
