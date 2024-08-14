/**
 * Provides classes for handling exceptions using the observer design pattern
 *
 * <p>
 * This package is focused on managing exception events and notifying registered listeners when exceptions occur
 * By utilizing the observer pattern, it allows for a flexible and decoupled approach to exception handling, where multiple components can respond to exceptions in a coordinated manner.
 * </p>
 *
 * <p>
 * The key classes in this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.handlers.AbstractExceptionHandler} - An abstract base class that provides common functionality for managing exception listeners and propagating exception events</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.handlers.DefaultExceptionHandler} - A concrete implementation of {@link io.github.astrapi69.design.pattern.observer.exception.handlers.AbstractExceptionHandler} that provides default behavior for handling exceptions and notifying listeners</li>
 * </ul>
 *
 * <p>
 * This package is essential for building a robust exception handling mechanism within an application, allowing for centralized and consistent management of exception events
 * It demonstrates how the observer pattern can be applied to exception handling to ensure that exceptions are effectively communicated and managed across the system.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer.exception.handlers;
