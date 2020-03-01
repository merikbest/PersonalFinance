package settings;

import java.util.HashMap;

//Класс с текстовыми константами
final public class Text {
    private static HashMap<String, String> data = new HashMap<>(); //Хранение цифровых констант

    //Метод получения значения по языковой константе
    public static String getKey(String key) {
        return data.get(key);
    }

    //Метод возврата массива строк с названиями месяца
    public static String[] getMounth() {
        String[] mounth = new String[12];
        mounth[0] = getKey("JENUARY");
        mounth[1] = getKey("FEBRUARY");
        mounth[2] = getKey("MARCH");
        mounth[3] = getKey("APRIL");
        mounth[4] = getKey("MAY");
        mounth[5] = getKey("JUNE");
        mounth[6] = getKey("JULY");
        mounth[7] = getKey("AUGUST");
        mounth[8] = getKey("SEPTEMBER");
        mounth[9] = getKey("OCTOBER");
        mounth[10] = getKey("NOVEMBER");
        mounth[11] = getKey("DECEMBER");
        return mounth;
    }

    //Механизм инициализации
    public static void init() {
        data.put("PROGRAM_NAME", "Домашняя бухгалтерия");
        data.put("MENU_FILE", "Файл");
        data.put("MENU_EDIT", "Правка");
        data.put("MENU_VIEW", "Вид");
        data.put("MENU_HELP", "Помощь");

        data.put("JENUARY", "Январь");
        data.put("FEBRUARY", "Февраль");
        data.put("MARCH", "Март");
        data.put("APRIL", "Апрель");
        data.put("MAY", "Май");
        data.put("JUNE", "Июнь");
        data.put("JULY", "Июль");
        data.put("AUGUST", "Август");
        data.put("SEPTEMBER", "Сентябрь");
        data.put("OCTOBER", "Октябрь");
        data.put("NOVEMBER", "Ноябрь");
        data.put("DECEMBER", "Декабрь");

        data.put("ERROR_TITLE_EMPTY", "Вы не ввели название!");
        data.put("ERROR_IS_EXISTS", "Такая запись уже существует!");
        data.put("ERROR_DATE_FORMAT", "Некорректный формат даты!");
        data.put("ERROR_CODE_EMPTY", "Вы не указали код!");
        data.put("ERROR_CURRENCY_EMPTY", "Вы не выбрали валюту!");
        data.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью!");
        data.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счет!");
        data.put("ERROR_RATE_INCORRECT", "Некорректное значение курса!");
        data.put("ERROR_AMOUNT_FORMAT", "Некорректный формат суммы!");
        data.put("ERROR_NO_BASE_CURRENCY", "Необходима базовая валюта! Установите сначала параметр в другой валюте, " +
                "потом он снимется в этой автоматически");
    }
}