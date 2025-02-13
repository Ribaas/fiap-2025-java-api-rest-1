// See https://aka.ms/new-console-template for more information

Console.WriteLine("Hello, World!");
var texto = Console.ReadLine();
Console.WriteLine($"Texto digitado: {texto}");

// variaveis
int numeroInteiro = 10;
double numeroDecimal = 10.5;
float numeroFlutuante = 10.5f;
decimal numeroDecimalGrande = 10.5m;

char caracter = 'a';
string textoPequeno = "aaa";
string textoGrande = """
                     AAAAAA
                     """;

bool boleano = false;

// operadores de decisao

float numero = float.Parse(Console.ReadLine());

if (numero > 10)
{
    Console.WriteLine("Numero maior que 10");
}
else
{
    Console.WriteLine("Numero menor que 10");
}

// operador ternario
Console.WriteLine(numero > 10 ? "Numero maior que 10" : "Numero menor que 10");

// switch case
switch (numero)
{
    case 10:
        Console.WriteLine("Numero igual a 10");
        break;
    case 20:
        Console.WriteLine("Numero igual a 20");
        break;
    default:
        Console.WriteLine("Numero desconhecido");
        break;
}

// lacos de repeticao

int i = 0;
while (i < 10)
{
    Console.WriteLine(i);
    i++;
}

for (int j = 0; j < 10; j++)
{
    Console.WriteLine(j);
}

// array

int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

foreach (int k in numeros) {
    Console.WriteLine(k);
}
