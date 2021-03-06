package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

/**
 * Aggregator (1)
 * Пришло время немного поработать с информацией в инете. В этом задании ты будешь писать агрегатор java вакансий.
 * Что у нас должно быть?
 * Должен быть список сайтов, на которых мы ищем вакансии.
 * Для начала возьмем http://hh.ua/ и http://hh.ru/, потом уже добавим другие сайты поиска работы.
 * Это один и тот же сайт, только в разных доменах.
 *
 * С чего же нужно начать реализацию? Конечно же с метода main : )
 * 1. Создай класс Aggregator с методом main.
 *
 * 2. Создай пакет model, в нем создай класс Provider.
 * Этот класс будет обобщать способ получения данных о вакансиях.
 *
 * 3. Т.к. для каждого сайта будет выполняться одинаковый сценарий, то будет паттерн Стратегия. Почитай про него в инете на вики.
 * В пакете model создай интерфейс Strategy.
 * Он будет отвечать за получение данных с сайта.
 *
 * 4. В класс Provider добавь поле Strategy strategy. Добавь конструктор с этим полем и сеттер.
 *
 *
 * Требования:
 * 1. Создай класс Aggregator с методом main.
 * 2. Создай пакет model, и в нем создай класс Provider.
 * 3. В пакете model создай интерфейс Strategy.
 * 4. В класс Provider добавь поле Strategy strategy. Добавь конструктор с этим полем и сеттер.
 * Aggregator (2)
 * 5. В методе main создай провайдер и контроллер с этим провайдером.a
 * 6. В методе main выведи в консоль созданный экземпляр контроллера.
 */
public class Aggregator {
    public static void main(String[] args) {
        View view = new HtmlView();
        Model model = new Model(view,new Provider(new HHStrategy()),new Provider(new MoikrugStrategy()));
        Controller controller = new Controller(model);
        view.setController(controller);
        ((HtmlView) view).userCitySelectEmulationMethod();

    }
}
