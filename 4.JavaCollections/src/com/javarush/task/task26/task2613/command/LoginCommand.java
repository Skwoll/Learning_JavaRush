package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class LoginCommand implements Command {
//    String cardNum = "123456789012";
//    String pin = "1234";
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "login");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            String card;
            String inputPin;
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            while (true) {
                card = ConsoleHelper.readString();
                if (card.length() == 12) {
                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"),card));
                    break;
                }
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"),card));
            }
            while (true) {
                inputPin = ConsoleHelper.readString();
                if (inputPin.length() == 4)
                    break;
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
            }

            if ( validCreditCards.containsKey(card) && inputPin.equals(validCreditCards.getString(card))){
//                ConsoleHelper.writeMessage("Добро пожаловать!");
                break;
            }
            ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
        }

    }
}
