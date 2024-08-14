/**
 * Provides classes and interfaces for handling exceptions using the observer design pattern
 *
 * <p>
 * This package is designed to facilitate the management and communication of exceptions within an application
 * By using the observer pattern, it allows multiple components to listen for and respond to exception events, enabling a decoupled and flexible approach to exception handling.
 * </p>
 *
 * <p>
 * The key interfaces and classes in this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.ExceptionEvent} - Encapsulates an exception event, carrying information about an exception that has occurred</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.ExceptionListener} - Represents a listener that reacts to exception events, allowing components to respond when exceptions occur</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.ExceptionMessage} - Represents a structured message related to an exception, containing details such as a properties key, value, and additional data</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.ExceptionObservers} - Manages a collection of exception listeners and notifies them when an exception event occurs, following the singleton pattern</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.exception.ExceptionMessages} - Manages a collection of exception messages organized by keys, providing methods to add, retrieve, and remove messages</li>
 * </ul>
 *
 * <p>
 * This package is crucial for implementing a centralized and consistent approach to exception handling in an application
 * It demonstrates how the observer pattern can be applied to ensure that exceptions are effectively communicated and managed across different components in the system.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer.exception;
