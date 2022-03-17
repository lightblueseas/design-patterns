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
import java.util.Collection;
import java.util.LinkedHashSet;

import io.github.astrapi69.design.pattern.visitor.GenericAcceptable;
import io.github.astrapi69.design.pattern.visitor.GenericVisitor;

/**
 * The Class FileAcceptable.
 */
public class FileAcceptable implements GenericAcceptable<FileVisitor, FileAcceptable>
{

	/** The file. */
	private final File file;
	/** The children. */
	private Collection<FileAcceptable> children;

	/**
	 * Instantiates a new file visitable.
	 *
	 * @param file
	 *            the file
	 */
	public FileAcceptable(final File file)
	{
		super();
		this.file = file;
		if (this.file.isDirectory())
		{
			children = new LinkedHashSet<>();
			final File[] files = file.listFiles();
			for (final File childrenFile : files)
			{
				children.add(new FileAcceptable(childrenFile));
			}
		}
	}

	/**
	 * (non-Javadoc).
	 *
	 * @param visitor
	 *            the visitor
	 * @see GenericAcceptable#accept(GenericVisitor)
	 */
	@Override
	public void accept(final FileVisitor visitor)
	{
		visitor.visit(this);
	}

	/**
	 * Gets the absolute path.
	 *
	 * @return the absolute path
	 */
	public String getAbsolutePath()
	{
		return this.file.getAbsolutePath();
	}

	/**
	 * Gets the children.
	 *
	 * @return the children
	 */
	public Collection<FileAcceptable> getChildren()
	{
		return children;
	}

	/**
	 * Checks if is directory.
	 *
	 * @return true, if is directory
	 */
	public boolean isDirectory()
	{
		return this.file.isDirectory();
	}

}
