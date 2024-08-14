/**
 * Provides core classes and interfaces for implementing the observer design pattern
 *
 * <p>
 * The observer design pattern is a behavioral design pattern where an object, known as the subject, maintains a list of its dependents, called observers,
 * and notifies them automatically of any state changes, usually by calling one of their methods
 * This package contains the foundational components necessary for building systems based on the observer pattern, enabling objects to be notified of changes in other objects' states.
 * </p>
 *
 * <p>
 * The key interfaces and classes in this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.AbstractObserver} - A base class that provides a concrete implementation of the observer interface, handling updates and executing commands</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.AbstractSubject} - A base class that provides a concrete implementation of the subject interface, managing observers and updating them when changes occur</li>
 * </ul>
 *
 * <p>
 * This package is essential for creating systems where objects need to be informed of state changes in other objects, promoting loose coupling and dynamic behavior
 * It demonstrates the flexibility and power of the observer design pattern in a wide range of application scenarios.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer;
