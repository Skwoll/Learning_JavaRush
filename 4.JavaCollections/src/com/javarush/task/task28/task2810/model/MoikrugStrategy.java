package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy{
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    private static final String URL_FORMAT1 = "http://javarush.ru/testdata/big28data2.html";

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
            Elements elements = doc.getElementsByClass("job");
//            Elements elements = doc.select("[class=job]");
            if (elements == null || elements.size() == 0)
                break;

            elements.forEach(element -> {
                Vacancy vacancy = new Vacancy();
                vacancy.setCity(element.getElementsByAttributeValue("class","location").text().trim());
                vacancy.setCompanyName(element.getElementsByAttributeValue("class","company_name").text().trim());
                vacancy.setTitle(element.getElementsByAttributeValue("class","title").text().trim());
                vacancy.setUrl("https://moikrug.ru"+element.getElementsByAttributeValue("class","job_icon").attr("href"));
                vacancy.setSalary(element.getElementsByAttributeValue("class","count").text().trim());
                vacancy.setSiteName("https://moikrug.ru");

                vacancies.add(vacancy);});

            page++;
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page)throws IOException{
        try {
            return Jsoup.connect(String.format(URL_FORMAT,searchString,page)).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36")
                    .referrer("https://moikrug.ru/vacancies?q=java&page="+page).get();
        } catch (IOException e) {
        }
        return null;

    }
}
