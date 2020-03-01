import settings.Text;
import sun.java2d.HeadlessGraphicsEnvironment;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PersonalFinance {
    public static void main(String[] args) {
        init();
//        System.out.println(Text.getKey("PROGRAM_NAME"));
//        System.out.println(Arrays.toString(Text.getMounth()));
    }

    //Вызов метода инициализации init() из класса Text
    private static void init() {
        try {
            Text.init();
            //Подключаем шрифт
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Light.ttf")));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
