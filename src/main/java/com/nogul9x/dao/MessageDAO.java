package com.nogul9x.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nogul9x.entity.MessageEntity;

public interface MessageDAO extends JpaRepository<MessageEntity, Long>{

}
