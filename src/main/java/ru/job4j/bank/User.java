package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка. Содержит номер паспорта и ФИО пользователя.
 * Используется для идентификации пользователя в банковской системе.
 * @author Leontyeva Evgeniya
 * @version 1.0
 */
public class User {

    /**
     * Номер паспорта пользователя
     */
    private String passport;

    /**
     * Полное имя пользователя
     */
    private String username;

    /**
     * Конструктор создает нового пользователя по номеру паспорта и имени
     * @param passport номер паспорта пользователя
     * @param username полное имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя
     * @return номер паспорта
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает номер паспорта для пользователя
     * @param passport номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает полное имя пользователя
     * @return полное имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя
     * @param username имя пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Определяет равенство двух экземпляров класса User на основе номера паспорта
     * @param o объект для сравнения
     * @return true, если равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код объекта пользователя на основе номера паспорта
     * @return хэш-код пользователя
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

}
