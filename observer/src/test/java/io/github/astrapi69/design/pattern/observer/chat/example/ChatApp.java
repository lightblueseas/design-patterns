package io.github.astrapi69.design.pattern.observer.chat.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import io.github.astrapi69.design.pattern.observer.chat.IUser;

public class ChatApp
{

	private JFrame frame;
	private JTextArea chatArea;
	private JTextField inputField;
	private ChatRoom<StringMessage> chatRoom;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(ChatApp::new);
	}

	public ChatApp()
	{
		initialize();
	}

	private void initialize()
	{
		// Create the chat room
		chatRoom = new ChatRoom<>("General");

		// Create some users
		User user1 = new User("Alice", 1);
		User user2 = new User("Bob", 2);

		// Register the users in the chat room
		ChatRoomUser<StringMessage> chatUser1 = new ChatRoomUserImpl(chatRoom, user1);
		ChatRoomUser<StringMessage> chatUser2 = new ChatRoomUserImpl(chatRoom, user2);

		// Set up the frame
		frame = new JFrame("Chat Room");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLayout(new BorderLayout());

		// Create chat area
		chatArea = new JTextArea();
		chatArea.setEditable(false);
		frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);

		// Create input field
		inputField = new JTextField();
		inputField.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String text = inputField.getText();
				if (!text.isEmpty())
				{
					StringMessage message = new StringMessage(text);
					chatUser1.send(message);
					inputField.setText("");
				}
			}
		});
		frame.add(inputField, BorderLayout.SOUTH);

		// Show the frame
		frame.setVisible(true);

		// Simulate a message from another user
		Timer timer = new Timer(5000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				StringMessage message = new StringMessage("Hello from " + user2.getName() + "!");
				chatUser2.send(message);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	// Implementation of a simple ChatRoomUser that updates the chat area when a message is received
	private class ChatRoomUserImpl extends ChatRoomUser<StringMessage>
	{

		public ChatRoomUserImpl(ChatRoom<StringMessage> room, IUser<?> user)
		{
			super(room, user);
		}

		@Override
		public void execute()
		{
			SwingUtilities.invokeLater(() -> chatArea
				.append(getUser().getName() + ": " + getObservable().getValue() + "\n"));
		}
	}
}
