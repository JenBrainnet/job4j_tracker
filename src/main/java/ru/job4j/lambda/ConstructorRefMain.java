package ru.job4j.lambda;

public class ConstructorRefMain {

    public static void main(String[] args) {
        FuncInterface modelConstractor = Model::new;
        Model model = modelConstractor.function("Example");
        System.out.println("Значение равно: " + model.getName());
    }

}
