package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Model;
import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Aggregator (2)
 * 1. Создай класс Controller, в нем будет содержаться бизнес логика.
 *
 * 2. В Controller добавь паблик конструктор, который будет принимать столько провайдеров, сколько в него передадут для обработки.
 * Сохрани их в приватное поле providers.
 * Помнишь, как это делать? Нужно нажать на аргументе конструктора Alt+Enter, выбрать Create Field for Parameter 'providers'.
 *
 * 3. Если провайдеры не переданы в конструктор контроллера, то брось IllegalArgumentException.
 *
 * 4. Создай метод toString в классе Controller (Alt+Insert -> toString()) со стандартной реализацией (должен выводить поле providers).
 *
 * 5. В методе main создай провайдер, а потом создай контроллер с этим провайдером.
 *
 * 6. В методе main выведи в консоль созданный экземпляр Controller-а.
 *
 *
 * Требования:
 * 1. Создай класс Controller.
 * 2. К классу Controller добавь конструктор, который принимает столько провайдеров, сколько в него передадут для обработки.
 * 3. В конструкторе сохрани все провайдеры в поле providers. Если ни одного провайдера передано не было - брось IllegalArgumentException
 * 4. В классе Controller создай метод toString со стандартной реализацией.
 */
public class Controller {
    Model model;

    public Controller(Model model) {
        if (model==null)
            throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}
