package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета. Содержит информацию о реквизитах и балансе на счете.
 * Используется для хранения и управления счетами клиентов в банке.
 * @author Leontyeva Evgeniya
 * @version 1.0
 */
public class Account {

    /**
     * Реквизиты банковского счета. Уникальный идентификатор счета.
     */
    private String requisite;
    /**
     * Баланс. Текущая сумма денежных средств на счете.
     */
    private double balance;

    /**
     * Конструктор для создания банковского счета
     * @param requisite реквизиты счета
     * @param balance начальный баланс на счету
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счета.
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счета
     * @param requisite новые реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает текущий баланс на счете
     * @return баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает новый баланс счета
      * @param balance новый баланс счета
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Определяет равенство экземпляров счета по реквизитам
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
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код объекта счета на основе реквизитов
     * @return хэш-код счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }

}
