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
package io.github.astrapi69.design.pattern.visitor;

/**
 *
 * The interface {@link GenericVisitor} have to be implemented from all classes that wants to be
 * visitor objects and provide a custom algorithm. This interface is restrictive for the visitor and
 * the acceptable objects, if this is not wanted or required then use the less restrictive
 * interfaces {@link Visitor} and is the counterpart of the interface {@link Acceptable}
 *
 * @param <VISITOR>
 *            the generic type from the visitor
 * @param <ACCEPTABLE>
 *            the generic type from the object to visit also called 'visitable' or 'acceptable'
 */
public interface GenericVisitor<VISITOR extends GenericVisitor<VISITOR, ACCEPTABLE>, ACCEPTABLE extends GenericAcceptable<VISITOR, ACCEPTABLE>>
{

	void visit(final ACCEPTABLE visitable);

}
