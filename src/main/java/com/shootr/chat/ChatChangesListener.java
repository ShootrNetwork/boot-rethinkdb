package com.shootr.chat;

import com.rethinkdb.RethinkDB;
import com.rethinkdb.net.Cursor;
import com.shootr.db.RethinkDBConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ChatChangesListener {
    protected final Logger log = LoggerFactory.getLogger(ChatChangesListener.class);

    private static final RethinkDB r = RethinkDB.r;

    @Autowired
    private RethinkDBConnectionFactory connectionFactory;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Async
    public void pushChangesToWebSocket() {
        Cursor<ChatMessage> cursor = r.db("chat").table("messages").changes()
                .getField("new_val")
                .run(connectionFactory.createConnection(), ChatMessage.class);

        while (cursor.hasNext()) {
            ChatMessage chatMessage = cursor.next();
            log.info("New message: {}", chatMessage.getMessage());
            webSocket.convertAndSend("/topic/messages", chatMessage);
        }
    }

}
