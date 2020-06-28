package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message answer = connection.receive();
                // если в ответ пришло не имя повтороно запросим имя
                if (answer.getType() != MessageType.USER_NAME)
                    continue;
                String userName  = answer.getData();

                // если пршло имя подключенного пользователя, повторно запросим имя
                if (userName == null || userName == "" || connectionMap.containsKey(userName))
                    continue;

                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return userName;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String s  : connectionMap.keySet()) {
                if (s != userName) {
                    connection.send(new Message(MessageType.USER_ADDED, s));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message inMessage = connection.receive();
                if (inMessage.getType() == MessageType.TEXT) {
                    Message outMessage = new Message(MessageType.TEXT, String.format("%s: %s", userName, inMessage.getData()));
                    sendBroadcastMessage(outMessage);
                } else {
                    ConsoleHelper.writeMessage("Ошибка! принятое сообщение не является текстом");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage(String.format("Установлено соединение с %s",socket.getRemoteSocketAddress().toString()));
            String userName = null;
            try (Connection connection = new Connection(socket)) {

                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED,userName));
                notifyUsers(connection,userName);
                serverMainLoop(connection, userName);
                ConsoleHelper.writeMessage("Соединенеи с удаленным сервером закрыто");
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            }
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED,userName));
            }
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        connectionMap.forEach((s, connection) -> {
            try {
              connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage(String.format("Не удалось отправить сообщение пользователю %s",s));
            }
        });
    }
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Введите порт сервера");
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port);){
            ConsoleHelper.writeMessage("Сервер запущен");
            while (true) {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        } catch (IOException e) {
           ConsoleHelper.writeMessage(e.getMessage());
        }

    }
}
