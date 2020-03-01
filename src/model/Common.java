package model;

//Базовый класс который объеденяет все дочерние классы
abstract public class Common {
    //Строка для комбо бокса (будет реализована в дочерних классах)
    public String getValueFromComboBox() {
        return null;
    }

    public void postAdd() {
    }     //Метод что делать после добавление объекта

    public void postEdit() {
    }    //Метод что делать после редактирования объекта

    public void postRemove() {
    }  //Метод что делать после удаления объекта
}