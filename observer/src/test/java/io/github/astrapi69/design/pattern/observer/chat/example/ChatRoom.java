package io.github.astrapi69.design.pattern.observer.chat.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.github.astrapi69.design.pattern.observer.AbstractSubject;
import io.github.astrapi69.design.pattern.observer.chat.IUser;
import io.github.astrapi69.design.pattern.observer.chat.Message;
import io.github.astrapi69.design.pattern.observer.chat.Room;

public class ChatRoom<M extends Message<?>> extends AbstractSubject<M, ChatRoomUser<M>>
	implements
		Room<M>,
		Serializable
{

	private static final long serialVersionUID = 1L;
	private final List<ChatRoomUser<M>> observers = new ArrayList<>();
	private final List<M> messageHistory = new ArrayList<>();
	private final String name;
	private M observable;

	public ChatRoom(String name)
	{
		this.name = name;
	}

	public ChatRoom(M observable, String name)
	{
		this.observable = observable;
		this.name = name;
	}

	@Override
	public synchronized void add(ChatRoomUser<M> observer)
	{
		observers.add(observer);
	}

	@Override
	public void addAll(Collection<ChatRoomUser<M>> observers)
	{
		this.observers.addAll(observers);
	}

	@Override
	public List<IUser<?>> getChatRoomUsers()
	{
		List<IUser<?>> chatRoomUsers = new ArrayList<>();
		for (ChatRoomUser<M> chatUser : observers)
		{
			chatRoomUsers.add(chatUser.getUser());
		}
		return chatRoomUsers;
	}

	@Override
	public List<M> getMessageHistory()
	{
		return messageHistory;
	}

	@Override
	public synchronized M getObservable()
	{
		return observable;
	}

	@Override
	public synchronized void setObservable(M observable)
	{
		this.observable = observable;
		messageHistory.add(observable);
		updateObservers();
	}

	@Override
	public boolean isSecure()
	{
		return false;
	}

	@Override
	public synchronized void remove(ChatRoomUser<M> observer)
	{
		observers.remove(observer);
	}

	@Override
	public void removeAll(Collection<ChatRoomUser<M>> observers)
	{
		this.observers.removeAll(observers);
	}

	public int size()
	{
		return observers.size();
	}

	@Override
	public synchronized void updateObservers()
	{
		for (ChatRoomUser<M> observer : observers)
		{
			observer.update(observable);
		}
	}

	public String getName()
	{
		return name;
	}
}
