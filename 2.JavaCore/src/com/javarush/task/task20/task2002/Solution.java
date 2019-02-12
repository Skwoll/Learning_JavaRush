package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush.
Метод main реализован только для вас и не участвует в тестировании.


Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список users не пустой.
3. Класс Solution.JavaRush не должен поддерживать интерфейс Serializable.
4. Класс Solution.JavaRush должен быть публичным.
5. Класс Solution.JavaRush не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.y HH:mm:ss.SSS", Locale.ENGLISH);
            for (int i = 0; i < 2; i++) {
                User user = new User();
//                user.setBirthDate(dateFormat.parse("06.05.1980"));
                user.setBirthDate(new Date());
                user.setCountry(User.Country.RUSSIA);
                user.setFirstName("Иван");
                user.setLastName("Петров");
                user.setMale(true);
                javaRush.users.add(user);

            }
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));

            DateFormat dateFormat = new SimpleDateFormat("dd.MM.y HH:mm:ss.SSS", Locale.ENGLISH);


            bw.write("JavaRush\n");
            if (users != null && users.size()>0) {
                users.forEach(user -> {
                                try {
                                    bw.write("User\n");
                                    bw.write(user.getFirstName()+"\n");
                                    bw.write(user.getLastName()+"\n");
                                    bw.write(user.isMale()+"\n");
                                    bw.write(dateFormat.format(user.getBirthDate())+"\n");
                                    bw.write(user.getCountry()+"\n");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });
            }
            bw.flush();
            bw.close();

        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.y HH:mm:ss.SSS", Locale.ENGLISH);

            while (br.ready()){
                String tmp = br.readLine();
                if (tmp.equals("JavaRush")){
                    tmp = br.readLine();
                }
                if(tmp != null && tmp.equals("User")){
                    User user = new User();
                    user.setFirstName(br.readLine());
                    user.setLastName(br.readLine());
                    user.setMale(Boolean.valueOf(br.readLine()));
                    user.setBirthDate(dateFormat.parse(br.readLine()));
                    user.setCountry(User.Country.valueOf(br.readLine()));
                    users.add(user);
                }

            }
            br.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
