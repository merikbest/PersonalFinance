import settings.Settings;
import settings.Text;
import sun.java2d.HeadlessGraphicsEnvironment;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PersonalFinance {
    public static void main(String[] args) {
        init();
    }

    //Вызов метода инициализации init() из класса Text
    private static void init() {
        try {
            Settings.init();
            Text.init();
            //Подключаем шрифт
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
