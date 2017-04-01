package cc.youdw.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

/**
 * Created by youdw on 2017/3/26.
 */
public class PoloHandler extends AbstractWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(PoloHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("收到消息" + message.getPayload());
//        super.handleTextMessage(session, message);
        session.sendMessage(new TextMessage("Marco!"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        super.afterConnectionEstablished(session);
        logger.info("PoloHandle 已连接！");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        logger.info("PoloHandle 已关闭");
    }



}
