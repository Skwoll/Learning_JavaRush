package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {

            ConsoleHelper.writeMessage(message);
            if (message == null || !message.contains(": "))
                return;

            String[] parse = message.split(": ");

            DateFormat dateFormat = null;

            switch (parse[1]) {
                case "дата":
                    dateFormat = new SimpleDateFormat("d.MM.YYYY");
                    break;
                case "день":
                    dateFormat = new SimpleDateFormat("d");
                    break;
                case "месяц":
                    dateFormat = new SimpleDateFormat("MMMM");
                    break;
                case    "год":
                    dateFormat = new SimpleDateFormat("YYYY");
                    break;
                case    "время":
                    dateFormat = new SimpleDateFormat("H:mm:ss");
                    break;
                case    "час":
                    dateFormat = new SimpleDateFormat("H");
                    break;
                case    "минуты":
                    dateFormat = new SimpleDateFormat("m");
                    break;
                case    "секунды":
                    dateFormat = new SimpleDateFormat("s");
                    break;
                default:
//                    sendTextMessage(String.format("Информация для %s: я не знаю такую команду",parse[0]));
                    return;
            }

            sendTextMessage(String.format("Информация для %s: %s",parse[0], dateFormat.format(Calendar.getInstance().getTime())));
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return String.format("date_bot_%d", (int) (Math.random() * 100));
    }

    public static void main(String[] args) {
        new BotClient().run();
    }

}
