package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы. Обеспечивает добавление и удаление пользователей,
 * управление их счетами и переводом денежных средств.
 * @author Leontyeva Evgeniya
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение всех пользователей системы и связанных с ними счетов. Коллекция представляет собой
     * отображение типа HashMap, где ключ - пользователь, а значение - список счетов этого
     * пользователя.
      */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в систему, если он еще не зарегистрирован. При добавлении пользователю
     * назначается пустой список счетов.
     * @param user новый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Выполняет удаление пользователя по номеру паспорта
     * @param passport номер паспорта удаляемого пользователя
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     * Добавляет новый счет в список счетов пользователя, найденного по номеру паспорта. Если счет
     * уже существует в системе, то он не добавляется.
     * @param passport номер паспорта пользователя
     * @param account новый счет для добавления
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Выполняет поиск пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя
     * @return объект пользователя, если он зарегистрирован в системе, иначе null
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Выполняет поиск счета по номеру паспорта пользователя и реквизитам счета
     * @param passport номер паспорта пользователя
     * @param requisite реквизиты счета
     * @return объект счета, если он есть в системе, иначе null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Выполняет перевод денежных средств с одного счета на другой, если такие счета существуют
     * и сумма перевода не превышает баланс на счете отправителя
     * @param sourcePassport номер паспорта отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport номер паспорта получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount сумма денежных средств для перевода
     * @return true, если перевод выполнен успешно, иначе false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account destination = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null && destination != null && source.getBalance() >= amount) {
            source.setBalance(source.getBalance() - amount);
            destination.setBalance(destination.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Возвращает список счетов пользователя
     * @param user пользователь
     * @return список счетов, иначе null
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }

}
