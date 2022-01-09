package com.nogul9x.service;

import java.util.Collection;

import com.nogul9x.model.Item;

public interface HistoryBookService {
	void add(Long id, Item entity);
	void remove(Long id);
	void update(Long id, int qty);
	void clear();
	Collection<Item> getItems();
	int getCount();
	double getAmount();
}
