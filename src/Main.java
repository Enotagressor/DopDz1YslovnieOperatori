public class Main {
    public static void main(String[] args) {
        task7();
    }

    //Людям старше (или равно) 23 лет мы предоставляем лимит в размере 3 зарплат.
    //Людям младше 23 лет мы предоставляем лимит в размере 2 зарплат.
    //Если заработная плата клиента выше (или равно) 50 тысяч, мы увеличиваем лимит в 1.2 раза.
    //Если заработная плата выше (или равно) 80 тысяч, мы увеличиваем лимит в 1.5 раза.
    //Наша задача: написать программу, которая показывает, какую сумму на кредитке может получить клиент.
    //Вводные данные: переменная age = 19 для обозначения возраста клиента, salary = 58_000 для обозначения зарплаты клиента.
    //Увеличения не могут быть применены одновременно. Необходимо вывести максимальный лимит в консоль в формате: «Мы готовы выдать вам кредитную карту с лимитом *** рублей».
    public static void  task6(){
        int age = 23;
        double  salary = 40000;
        int koefOne = 3;
        int koefTwo = 2;
        double koefSalary = 1;

        if (salary >= 50_000){
            koefSalary = (koefSalary * 1.2);
        } else if (salary >= 80_000){
            koefSalary = koefSalary * 1.5;
        } else {
            koefSalary = 1;
        }
        if (age >= 23){
            salary = salary * koefOne * koefSalary;
            System.out.println("Вам одобрена кредитная карта с лимитом " + salary);
        } else if (age < 23 && age >= 18) {
            salary =  salary * koefTwo  * koefSalary;
            System.out.println("Вам одобрена кредитная карта с лимитом " + salary);
        } else {
            salary = 0;
            System.out.println("Подрости");
        }
    }

    //Расширим задачу с кредитованием. Прежде чем выдавать кредиты наш банк проводит аудит и оценивает клиентов и их возможность выплачивать кредит.
    // Для того, чтобы вывести предварительное решение, нам необходимо использовать данные о возрасте, зарплате и желаемой сумме.
    //Правила следующие:
    //Базовая ставка для клиента — 10% годовых. Срок кредитования — 12 месяцев. Максимальный ежемесячный платеж — 50% от ЗП.
    // Если возраст меньше 23, то добавляем 1% к ставке.Если возраст меньше 30, то добавляем 0.5% к ставке. Если зарплата больше 80_000, уменьшаем ставку на 0.7%.
    //Нам нужно написать программу для предварительного одобрения/отказа заявки по кредиту.
    //Вводные данные: используйте переменные age = 25 для обозначения возраста,salary = 60_000 для обозначения зарплаты,
    // wantedSum = 330_000 для обозначения желаемой суммы кредита.
    //Подсчитайте и выведите ответ, одобрен кредит или нет. На основании зарплаты подсчитайте максимальный допустимый платеж.
    // Если максимальный допустимый платеж по ЗП больше стандартного платежа по кредиту согласно процентной ставке, то кредит одобрен, если меньше — отказан.
    //Пример ответа в консоль: «Максимальный платеж при ЗП *** равен *** рублей. Платеж по кредиту *** рублей. Одобрено/отказано».
    //Критерии оценки
    //При изменении значения переменной age результат вывода в консоль изменяется согласно условиям задачи
    //При изменении значения переменной salary результат вывода в консоль изменяется согласно условиям задачи
    //Написанный код отрабатывает условия задачи и изменение значений переменных, выводит в консоль корректный результат
    //Нет вложенности в коде.

    public static void  task7() {
        int age = 25;
        int salary = 60_000;
        double wantedSum = 330_000;

        double stavka = 0.1;
        int srok = 12;
        double maxMonthPayment = 0.5 * salary;
        double koefHight1 = 0.01;
        double koefHight2 = 0.005;
        double koevLow = 0.007;

        if (salary > 80_000) {
            stavka = stavka - koevLow;

            if (age < 18) {
                System.out.println("Подрости");
            } else if (age < 23) {
                stavka = stavka + koefHight1;
            } else if (age < 30) {
                stavka = stavka + koefHight2;
            }
        }
        double dolgBanku = wantedSum + (wantedSum * stavka);
        double everMonthPay = dolgBanku / srok;

        if (everMonthPay >= maxMonthPayment) {
            System.out.println("Максимальный платеж при ЗП " + salary + " равен " + maxMonthPayment + " рублей. Платеж по кредиту " + everMonthPay + " рублей. Отказано");
        } else {
            System.out.println("Максимальный платеж при ЗП " + salary + " равен " + maxMonthPayment + " рублей. Платеж по кредиту " + everMonthPay + " рублей. Одобрено");
        }
        }
    }