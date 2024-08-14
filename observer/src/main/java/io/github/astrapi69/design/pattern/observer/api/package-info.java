/**
 * Provides interfaces that define the core components of the observer design pattern
 *
 * <p>
 * The observer pattern is a behavioral design pattern that allows an object, known as the subject, to maintain a list of its dependents, called observers,
 * and notify them automatically of any state changes, usually by calling one of their methods
 * This package contains the fundamental interfaces that are essential for implementing the observer pattern.
 * </p>
 *
 * <p>
 * The key interfaces in this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.api.Observer} - Represents the observer that watches the subject for changes</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.api.Subject} - Represents the subject being observed</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.api.ActionCommand} - Represents a command that can be executed, typically used by observers to respond to subject changes</li>
 * </ul>
 *
 * <p>
 * These interfaces provide a flexible and extensible framework for implementing the observer pattern in various contexts
 * By adhering to these interfaces, developers can create systems where objects can be notified of changes in other objects' states, promoting loose coupling and dynamic behavior.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer.api;
