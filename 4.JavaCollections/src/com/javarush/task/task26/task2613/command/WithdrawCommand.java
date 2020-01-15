package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.ResourceBundle;

class WithdrawCommand implements Command{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH+ "withdraw");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
       String currency = ConsoleHelper.askCurrencyCode();
       CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
       int ammount=0;


       while (true){
           ConsoleHelper.writeMessage(res.getString("specify.amount"));
           try {
               ammount = Integer.parseInt(ConsoleHelper.readString());
               if (manipulator.isAmountAvailable(ammount)){
                   manipulator.withdrawAmount(ammount).forEach((k, v) -> ConsoleHelper.writeMessage(String.format(res.getString("success.format"),k,v)));
                   break;
               }else {
                   ConsoleHelper.writeMessage(res.getString("not.enough.money"));
               }
           } catch (NumberFormatException e) {
               ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
           } catch (NotEnoughMoneyException e){
               ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
           }
       }
    }
}
