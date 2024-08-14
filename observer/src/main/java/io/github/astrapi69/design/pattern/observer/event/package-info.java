/**
 * Provides classes and interfaces for implementing event handling in the observer design pattern
 *
 * <p>
 * This package is designed to manage events and event sources within the observer pattern framework
 * It includes the necessary components for creating, firing, and handling events, allowing objects to respond dynamically to changes in other objects' states.
 * </p>
 *
 * <p>
 * The key interfaces and classes in this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.event.EventListener} - Represents an interface for handling events that occur within the system</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.event.EventObject} - Encapsulates the event data, acting as a carrier of the information related to the event</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.event.EventSource} - Represents the source of events, managing event listeners and the firing of events</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.event.EventSubject} - A concrete implementation of {@link io.github.astrapi69.design.pattern.observer.event.EventSource}, which manages a collection of event listeners and notifies them when an event occurs</li>
 * </ul>
 *
 * <p>
 * This package is essential for building a robust event-driven architecture within an application, enabling objects to communicate changes efficiently and effectively
 * It demonstrates how to use the observer pattern to manage and propagate events throughout a system.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer.event;
