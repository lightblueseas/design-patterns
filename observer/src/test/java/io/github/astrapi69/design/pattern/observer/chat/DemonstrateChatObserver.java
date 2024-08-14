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
package io.github.astrapi69.design.pattern.observer.chat;

import io.github.astrapi69.design.pattern.observer.api.Subject;

/**
 * The class {@link DemonstrateChatObserver} demonstrates the usage of the chat observer pattern
 * with various chat rooms and users This class contains a main method that simulates a chat session
 * between multiple users in different chat rooms
 */
public class DemonstrateChatObserver
{

	/**
	 * The main method that simulates a chat session between multiple users in different chat rooms
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(final String[] args)
	{

		final ChatRoomService<StringMessage> chatRoomService = new ChatRoomService<>();
		final Subject<StringMessage, ChatRoomUser<StringMessage>> firstRoom = chatRoomService
			.getChatRoom(new StringMessage().setValue("Welcome in this chat room"),
				"First chat room");
		final Subject<StringMessage, ChatRoomUser<StringMessage>> secondRoom = chatRoomService
			.getChatRoom(new StringMessage().setValue("Welcome in this chat room"),
				"Second chat room");
		final User antonUser = new User("anton", 1);
		final User johnUser = new User("john", 2);
		final User alfredUser = new User("alfred", 3);
		final ChatRoomUser<StringMessage> antonFirstRoom = new SimpleChatRoomUser(
			(ChatRoom<StringMessage>)firstRoom, antonUser);
		final ChatRoomUser<StringMessage> johnFirstRoom = new SimpleChatRoomUser(
			(ChatRoom<StringMessage>)firstRoom, johnUser);
		final ChatRoomUser<StringMessage> alfredFirstRoom = new ChatRoomUser<StringMessage>(
			(ChatRoom<StringMessage>)firstRoom, alfredUser)
		{

			private static final long serialVersionUID = 1L;

			@Override
			public void execute()
			{
				final String display = "----------------------------------------------\n"
					+ alfredUser.getName() + " sees the Message:\n" + getObservable().getValue()
					+ "\n----------------------------------------------";
				System.out.println(display);
			}

			@Override
			public void send(final StringMessage message)
			{
				System.out.println("In chat room '" + subject.getName() + "' the user:\n"
					+ getUser().getName() + " tells:" + message.getValue());
				super.send(message);
			}

		};

		final ChatRoomUser<StringMessage> antonSecondRoom = new SimpleChatRoomUser(
			(ChatRoom<StringMessage>)secondRoom, antonUser);
		final ChatRoomUser<StringMessage> johnSecondRoom = new SimpleChatRoomUser(
			(ChatRoom<StringMessage>)secondRoom, johnUser);
		StringMessage message = new StringMessage("Hello everybody");
		System.out.println("########## New message ##############");
		antonFirstRoom.send(message);
		antonSecondRoom.send(message);
		message = new StringMessage("Hello anton");
		System.out.println("########## New message ##############");
		johnFirstRoom.send(message);
		johnSecondRoom.send(message);
		message = new StringMessage("Hello anton and john. Im alfred.");
		System.out.println("########## New message ##############");
		alfredFirstRoom.send(message);
		message = new StringMessage("Im leafing this room");
		System.out.println("########## New message ##############");
		antonFirstRoom.send(message);
		firstRoom.remove(antonFirstRoom);
		message = new StringMessage("how old are you John");
		System.out.println("########## New message ##############");
		alfredFirstRoom.send(message);
		message = new StringMessage("Im leafing this room");
		System.out.println("########## New message ##############");
		johnFirstRoom.send(message);
		firstRoom.remove(johnFirstRoom);
		message = new StringMessage("im alone now :-((");
		System.out.println("########## New message ##############");
		alfredFirstRoom.send(message);
		message = new StringMessage("Im leaving this room too...");
		System.out.println("########## New message ##############");
		alfredFirstRoom.send(message);
		firstRoom.remove(alfredFirstRoom);

		System.out.println("########## Data message service ##############");
		final ChatRoomService<ChatMessage> chatRoomSeriveExtended = new ChatRoomService<>();
		final User rootUser = new User("root", 0);
		MessageRoomModelBean messageRoomModel = new MessageRoomModelBean("", rootUser, "", null);
		ChatMessage chatMessage = new ChatMessage().setValue(messageRoomModel);
		final ChatRoom<ChatMessage> firstFileRoom = chatRoomSeriveExtended.getChatRoom(chatMessage,
			"file chat room 1");

		final ChatRoomUser<ChatMessage> antonFirstFileRoom = new DataChatRoomUser(firstFileRoom,
			antonUser);
		final ChatRoomUser<ChatMessage> johnFirstFileRoom = new DataChatRoomUser(firstFileRoom,
			johnUser);
		messageRoomModel = new MessageRoomModelBean(firstFileRoom.getName(), antonUser, "Foo bar",
			null);
		chatMessage = new ChatMessage().setValue(messageRoomModel);
		System.out.println("########## New message ##############");
		antonFirstFileRoom.send(chatMessage);
		messageRoomModel = new MessageRoomModelBean(firstFileRoom.getName(), johnUser, "Bar foo",
			null);
		chatMessage = new ChatMessage().setValue(messageRoomModel);
		johnFirstFileRoom.send(chatMessage);

	}

}
