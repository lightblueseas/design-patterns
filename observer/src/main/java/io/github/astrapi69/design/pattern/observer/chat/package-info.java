/**
 * Provides classes and interfaces for implementing a chat application using the observer design pattern
 *
 * <p>
 * The chat package includes implementations of chat rooms, users, and messages, all of which interact through the observer pattern
 * This package demonstrates how to structure a chat system where users can send and receive messages, and how those messages
 * are propagated to all participants in the chat room.
 * </p>
 *
 * <p>
 * The key components of this package include:
 * </p>
 * <ul>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.ChatRoom} - Represents a chat room where users can exchange messages</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.ChatRoomUser} - Represents a user participating in a chat room</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.Message} - An interface for messages sent within the chat room</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.StringMessage} - A concrete implementation of {@link io.github.astrapi69.design.pattern.observer.chat.Message} for text-based messages</li>
 *     <li>{@link io.github.astrapi69.design.pattern.observer.chat.User} - Represents a user entity in the chat system</li>
 * </ul>
 *
 * <p>
 * The observer design pattern allows the chat application to notify all users in a chat room when a new message is received
 * This package demonstrates a flexible and extensible way to implement such functionality using Java.
 * </p>
 */
package io.github.astrapi69.design.pattern.observer.chat;
