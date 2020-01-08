package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

class WithdrawCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
       String currency = ConsoleHelper.askCurrencyCode();
       CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currency);
       int ammount=0;


       while (true){
           ConsoleHelper.writeMessage("Введите необходумую сумму");
           try {
               ammount = Integer.parseInt(ConsoleHelper.readString());
               if (manipulator.isAmountAvailable(ammount)){
                   manipulator.withdrawAmount(ammount).forEach((k, v) -> ConsoleHelper.writeMessage( k+" - "+v));
                   break;
               }else {
                   ConsoleHelper.writeMessage("Не возможно выдать запрошенную сумму");
               }
           } catch (NumberFormatException e) {
               ConsoleHelper.writeMessage("Введены некоректные данные");
           } catch (NotEnoughMoneyException e){
               ConsoleHelper.writeMessage("Не возможно выдать запрошенную сумму");
           }
       }
    }
}
