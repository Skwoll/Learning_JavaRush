package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
//    private static final String URL_FORMAT1 = "https://javarush.ru/testdata/big28data.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        Document doc=null;
        List<Vacancy> vacancies = new ArrayList<>();
        int page = 0;
        while (true) {
            try {
                doc = getDocument(searchString,page);
            } catch (IOException e) {
            }
            Elements elements = doc.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy");
            if (elements == null || elements.size() == 0)
                break;

            elements.forEach(element -> {
                Vacancy vacancy = new Vacancy();
                vacancy.setCity(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-address").text().trim());
                vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-employer").text().trim());
                vacancy.setTitle(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").text().trim());
                vacancy.setUrl(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-title").attr("href"));
                vacancy.setSalary(element.getElementsByAttributeValue("data-qa","vacancy-serp__vacancy-compensation").text().trim());
                vacancy.setSiteName("http://hh.ru");

                vacancies.add(vacancy);});

            page++;
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page)throws IOException{
        try {
            return Jsoup.connect(String.format(URL_FORMAT,searchString,page)).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                        .referrer("https://samara.hh.ru/search/vacancy?text=java+%D1%81%D0%B0%D0%BC%D0%B0%D1%80%D0%B0&page="+page).get();
        } catch (IOException e) {
        }
        return null;

    }
}
