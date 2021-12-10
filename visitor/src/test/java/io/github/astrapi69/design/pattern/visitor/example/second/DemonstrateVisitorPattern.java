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
package io.github.astrapi69.design.pattern.visitor.example.second;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import io.github.astrapi69.file.search.PathFinder;
import io.github.astrapi69.lang.ClassExtensions;

/**
 * The Class DemonstrateVisitorPattern.
 */
public class DemonstrateVisitorPattern
{

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws URISyntaxException
	 *             occurs by creation of the file with an uri.
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(final String[] args) throws URISyntaxException, IOException
	{

		final FileVisitor visitor = new FileVisitor();

		// File directory = new File(".");
		File directory = ClassExtensions.getResourceAsFile("DemonstrateVisitorPattern.class",
			new DemonstrateVisitorPattern());
		directory = directory.getParentFile();
		directory = PathFinder.getProjectDirectory();
		final FileVisitable visitable = new FileVisitable(directory);
		visitor.visit(visitable);
		System.out.println(visitor.getFilesCounted());


	}

}
