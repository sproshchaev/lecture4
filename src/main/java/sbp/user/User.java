package sbp.user;

import java.util.Date;

    /*
    Напишите реализацию класса User (создайте класс, добавьте поля, конструкторы, геттеры,
    переопределите необходимые методы).
     */

    /*
     * setter-ы создаем для полей, которые могут быть изсменены у пользователя: телефон, логин, пароль
     * переопределяем методы класса Object в классе User (toString(), equals(), hashCode()
     */

public class User {

    private String name;
    private String middleName;
    private String surName;
    private Date dateOfbirth;
    private String phoneNumber;
    private String login;
    private String password;

    public User(String name, String middleName, String surName, Date dateOfbirth, String phoneNumber, String login, String password) {
        this.name = name;
        this.middleName = middleName;
        this.surName = surName;
        this.dateOfbirth = dateOfbirth;
        this.phoneNumber = phoneNumber;
        this.login = login;
        this.password = password;
    };

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public String getMiddleName() {
        return middleName;
    }
    public String getSurName() {
        return surName;
    }
    public Date getDateOfbirth() {
        return dateOfbirth;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }

    /* Переопределение методов класса Object: toString(), equals(), hashCode()
     * 1) https://javarush.ru/groups/posts/1989-kontraktih-equals-i-hashcode-ili-kak-ono-vsje-tam
     * 2) Чтобы переопределить методы родительского класса, перейди в код класса-наследника в Intellij IDEa,
     * нажми Ctrl+O и выбери в меню «Override methods...».
     * 3) Переопределяя в своем коде метод equals, необходимо всегда переопределять и метод hashCode!
     * 4) Оператор instanceof нужен, чтобы проверить, был ли объект, на который ссылается переменная X,
     * создан на основе какого-либо класса Y
     */


    @Override
    public String toString() {
        return getClass().getName()
                + " " + this.name
                + " " + this.middleName
                + " " + this.surName
                + " " + this.dateOfbirth
                + " " + this.phoneNumber
                + " " + this.login;
    }

    @Override
    public boolean equals(Object obj) {

        boolean resultEquals = false;

        if (this == obj) {
            resultEquals = true;
        }
        if (obj instanceof User) {

            if ((this.name == ((User) obj).name)
                    && (this.middleName == ((User) obj).middleName)
                    && (this.surName == ((User) obj).surName)
                    && (this.dateOfbirth == ((User) obj).dateOfbirth)
                    && (this.phoneNumber == ((User) obj).phoneNumber)
                    && (this.login == ((User) obj).login)
                    && (this.password == ((User) obj).password)) {
                resultEquals = true;
            }

        }
        return resultEquals;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + surName.hashCode();
        result = 31 * result + dateOfbirth.hashCode();
        result = 31 * result + phoneNumber.hashCode();
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }


}
