package com.ait.interview.services;

import com.ait.interview.domain.Chat;

public interface ChatService {
	public int count(Long id);

	public Chat getLatestChat(Long id);
}
