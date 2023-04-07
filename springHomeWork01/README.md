**Задание**

1. Создайте новое приложение
2. Cоздайте интерфейс Operations c методами -
   - void hello()
   - void  bye()
   - void welcome()
3. Coздайте классы RusOperations и EnglOperations, расширяющие  интерфейс Operations
   - hello - печатает слово привет на англ\русском на консоль - значение тянем из файла .properties
   - bye- печатает слово пока на англ\русском консоль - значение тянем из файла .properties
   - welcome - печатает дефолтную фразу на консоль - используем аннотацию Value
4. Coздайте класс GeneralApp c методом start() - вызывает метод  hello  из класса RusOperations и EnglOperations
5. Используя метод init-method выведите из класса GeneralApp  фразу “Добро пожаловать в приложение.”