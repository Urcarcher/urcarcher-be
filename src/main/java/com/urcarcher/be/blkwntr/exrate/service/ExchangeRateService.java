package com.urcarcher.be.blkwntr.exrate.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.urcarcher.be.blkwntr.exrate.ExchangeType;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@Service
@ServerEndpoint("/realtime/rate")
public class ExchangeRateService {
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
    private static Logger logger = LoggerFactory.getLogger(ExchangeRateService.class);
    private static JSONParser jsonParser = new JSONParser(JSONParser.DEFAULT_PERMISSIVE_MODE);
    private static Map<ExchangeType, JSONObject> exchanges = new HashMap<>();

    public static Map<ExchangeType, JSONObject> getAllRateInfo() {
    	return exchanges;
    }
    
    public static JSONObject getRateInfoByExType(ExchangeType exchangeType) {
    	return exchanges.get(exchangeType);
    }
    
    @OnOpen
    public void onOpen(Session session) {
        logger.info("open session : {}, clients={}", session.toString(), clients);


        if(!clients.contains(session)) {
            clients.add(session);
            logger.info("session open : {}", session);
        }else{
            logger.info("이미 연결된 session");
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, ParseException {
        logger.info("receive message : {}", message);

        for (Session s : clients) {
            logger.info("send data : {}", message);
            
            JSONObject jsonObject = (JSONObject) jsonParser.parse(message);
            exchanges.put(ExchangeType.valueOf((String) jsonObject.get("exchangeType")), jsonObject);
            
            s.getBasicRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        logger.info("session close : {}", session);
        clients.remove(session);
    }
}
