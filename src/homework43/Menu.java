package homework43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void show() throws IOException {
        System.out.print("Меню:\n" +
                "1 - приготовить хот-дог по готовому рецепту\n" +
                "2 - создать новый рецепт\n" +
                "3 - посмотреть количество проданных хот-догов\n" +
                "4 - посмотреть выручку\n" +
                "5 - посмотреть прибыль\n" +
                "6 - наличие ингредиентов для хот-дога\n" +
                "0 - закрыть программу\n" +
                "Введите цифру меню: ");
        int choice = Integer.parseInt(input.readLine());
        switch (choice) {
            case 1:
                prepareHotDog();
                break;
            case 2:
                createRecipe();
                break;
            case 3:
                showNumberOfSoldHotDogs();
                break;
            case 4:
                showRevenue();
                break;
            case 5:
                showProfit();
                break;
            case 6:
                IngredientsInStock();
                break;
            case 0:
                System.exit(1);
            default:
                System.out.println("Неверный ввод.");
                show();
        }
    }
}
