#include <stdio.h>

int main(int argc, char *argv[])
{
    puts(" ===== IF z pojedyncza instrukcja =====");
    int a;
    printf("Podaj wartosc zmiennej typu INT a=");
    scanf("%d",&a);
    if (a > 0)
        printf("Wartosc 'a' jest wieksza od zera\n");
    if (a < 0)
        printf("Wartosc 'a' jest mniejsza od zera\n");
    if (a == 0)
        printf("Wartosc 'a' jest rowna zero\n");
    
    puts(" ===== Konstrukcja if-else. Czy liczba jest parzysta ? =====");
    int number_to_test, remainder;
    printf ("Podaj liczbe typu INT: ");
    scanf ("%i", &number_to_test);
    remainder = number_to_test % 2;
    if ( remainder == 0 )
        printf ("Liczba jest parzysta.\n");
    else
        printf ("Liczba jest nieparzysta.\n");
    
    puts(" ===== Zlozone warunki porownania. Czy dany rok jest przystepny ? =====");
    int year, rem_4, rem_100, rem_400;
    printf ("Podaj rok (liczbe typu INT): ");
    scanf ("%i", &year);
    rem_4 = year % 4;
    rem_100 = year % 100;
    rem_400 = year % 400;
    if ( (rem_4 == 0 && rem_100 != 0) || rem_400 == 0 )
        puts("Rok jest przystepny.");
    else
        puts("Rok nie jest przystepny.\n");
    
    puts(" ===== Zagniezdzone if-else. Funkcja signum =====");
    int number, sign;
    printf ("Prosze podac liczbe typu INT: ");
    scanf ("%i", &number);
    if ( number < 0 )
        sign = -1;
    else
        if ( number == 0 )
            sign = 0;
        else // Musi byc dodatnia
            sign = 1;
    printf ("Signum = %i\n", sign);
    
    puts(" ===== Zagniezdzone if, w tym z blokiem kodu. Interpretator prostych wyrazen =====");
    float value1, value2, value;
    char operacja;
    printf ("Wprowadz float spacje znak operacji spacje i float : \n");
    scanf ("%f %c %f", &value1, &operacja, &value2);
    if ( operacja == '+' ) {
        value = value1 + value2;
        printf ("%.2f\n", value);
    }
    else
        if ( operacja == '-' ) {
            value = value1 - value2;
            printf ("%.2f\n", value);
        }
        else
            if ( operacja == '*' )
                printf ("%.2f\n", value1 * value2);
            else
                if ( operacja == '/' )
                    if ( value2 == 0 )
                        printf ("Dzielenie przez zero.\n");
                    else
                        printf ("%.2f\n", value1 / value2);
                    else
                        printf ("Nieznany operator.\n");
    
    puts(" ===== Instrukcja Switch, w tym z blokiem kodu. Interpretator prostych wyrazen =====");
    switch (operacja)
    {
        case '+':
            printf ("%.2f\n", value1 + value2);
            break;
        case '-':
            printf ("%.2f\n", value1 - value2);
            break;
        case '*':
            printf ("%.2f\n", value1 * value2);
            break;
        case '/':
            if ( value2 == 0 )
                printf ("Dzielenie przez zero.\n");
            else
                printf ("%.2f\n", value1 / value2);
            break;
        default:
            printf ("Nieznany operator.\n");
            break;
    }
}
