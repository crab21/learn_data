package com.example.algorithm.learnApo;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Title:Server
 * Description: 服务器向多个客户端推送主题，即不同客户端可向服务器订阅相同主题
 */
public class ServerApo {

    public static final String HOST = "tcp://47.106.231.162:61613";
    public static final String TOPIC = "test-topic";
    private static final String clientid = "server";

    private MqttClient client;
    private MqttTopic topic;
    private MqttTopic topic125;
    private String userName = "admin";
    private String passWord = "password";

    private MqttMessage message;

    public ServerApo() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(10);
        // 设置会话心跳时间
        options.setKeepAliveInterval(20);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);
            topic = client.getTopic(TOPIC);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    public static void main(String[] args) throws MqttException, InterruptedException {
        ServerApo server = new ServerApo();
        server.message = new MqttMessage();
        server.message.setQos(2);
        server.message.setRetained(true);
        int count = 0;
        while (true) {
            server.message.setPayload(("可以了abc1" + count).getBytes());
            server.publish(server.topic, server.message);
            Thread.sleep(1000);
            count++;
        }

//        System.out.println(server.message.isRetained() + "------ratained状态");
    }
}
