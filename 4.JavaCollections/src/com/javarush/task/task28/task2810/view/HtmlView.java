package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    Controller controller;

    private final String filePath = "./4.JavaCollections/src/"+this.getClass().getPackage().getName().replace(".","/")+"/vacancies.html";
    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }
    private String getUpdatedFileContent(List<Vacancy> vacancies){
        Document doc = null;

        try {
            doc = getDocument();

            Element templateElement = doc.getElementsByClass("template").first();
            Element element = templateElement.clone();
            element.removeAttr("style");
            element.removeClass("template");

            doc.select("tr[class=vacancy]").remove().not("tr[class=vacancy template");
            for (Vacancy vacancy : vacancies)  {
                Element newElement = element.clone();
                newElement.getElementsByAttributeValue("class","city").first().appendText(vacancy.getCity());
                newElement.getElementsByAttributeValue("class","companyName").first().appendText(vacancy.getCompanyName());
                newElement.getElementsByAttributeValue("class","salary").first().appendText(vacancy.getSalary());
                newElement.getElementsByAttributeValue("href","url").first().appendText(vacancy.getTitle()).attributes().put("href",vacancy.getUrl());

                templateElement.before(newElement.outerHtml());
        }
        } catch (IOException|NullPointerException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }

        return doc.toString();
    }

    private void updateFile(String content){
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath))){
            fileOutputStream.write(content.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath),"UTF-8");
    }
}
