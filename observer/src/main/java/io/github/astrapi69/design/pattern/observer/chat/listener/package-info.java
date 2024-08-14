/**
 * Provides interfaces and classes for implementing listeners in a chat application using the observer design pattern
 *
 * <p>
 * This package is focused on defining the components necessary for handling events in a chat system, specifically through the use of listeners
 * Listeners are essential in the observer pattern as they allow objects to be notified of events, such as incoming messages or changes in chat state.
 * </p>
 *
 * <p>
 * The key interfaces and classes in this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.listener.MessageListener} - Represents a listener that reacts to message events in the chat system</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.listener.MessageObject} - Encapsulates the message event that is passed to listeners when a message is received</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.listener.MessageSource} - Represents the source of messages, managing the registration of listeners and the firing of message events</li>
 * </ul>
 *
 * <p>
 * This package plays a crucial role in enabling dynamic communication between components in the chat application by allowing objects to react to specific events
 * It demonstrates how to use the observer pattern to create responsive and interactive chat systems.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer.chat.listener;
