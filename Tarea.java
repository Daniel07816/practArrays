import java.util.Scanner;

public class Tarea 
{
    static int c = 0;
    static Scanner ingreso = new Scanner(System.in); 
    static double[] debitos = new double[10];
    static double[] creditos = new double[5];

    //creador de debitos
    public static void genDeb()
    {
        int a;

        for(a = 0; a < debitos.length; a++)
        {
            if(debitos[a] == 0.0)
            {
                System.out.println("Ingrese el debito: ");
                debitos[a] = ingreso.nextDouble();
                c++; 
                break; 
            }
        }

        if(a >= debitos.length)
        {
            System.out.println("Base de datos de debitos llena");
        }
    }

    //creador de creditos
    public static void genCre()
    {
        int b;

        for(b = 0; b < creditos.length; b++)
        {
            if(creditos[b] == 0.0)
            {
                System.out.println("Ingrese el debito: ");
                creditos[b] = ingreso.nextDouble();
                c++; 
                break; 
            }
        }

        if(b >= debitos.length){
            System.out.println("Base de datos de creditos llena");
        }
    }

    //impresor de debitos
    static double ptDeb()
    {
        double total = 0; 

        for(int c = 0; c < debitos.length; c++)
        {
            total += debitos[c]; 
            if(debitos[c] == 0.0)
            {
                break;
            }
        }
        return total; 
    }
    
    //impresor de creditos
    static double ptCre()
    {
        double total = 0; 

        for(int d = 0; d < creditos.length; d++)
        {
            total += creditos[d]; 
            if(creditos[d] == 0.0)
            {
                break;
            }
        }
        return total; 
    }

    //promedio de los debitos
    static double prom()
    {
        double regreso = 0; 
        int e;
        boolean control = true;

        for(e = 0; e < debitos.length; e++)
        {
            regreso = regreso + debitos[e];
            if(debitos[e] == 0.0){
                regreso = regreso/e;  
                control = false; 
                break;
            }
            
        }
        if(control)
        {
            regreso = regreso/debitos.length;  
        }
        return regreso;
    }

    //debito maximo
    static double max()
    {
        double mayor = 0; 
        for(int f = 0; f < debitos.length; f++)
        {
            if(mayor < debitos[f])
            {
                mayor = debitos[f]; 
            }
        }
        return mayor; 
    }

    //registro de operaciones
    static void operaciones()
    {
        System.out.println("");
        System.out.println("Debitos   Creditos");
        ptDeb(); 
        ptCre();
        System.out.println("Q" + ptDeb() + "  " + "Q" + ptCre());
        System.out.println("Saldo: " + (ptDeb()-ptCre()));
    }

    //eliminar creditos de los datos
    static void delCre(double n)
    {
        for(int g = 0; g < creditos.length; g++){
            if (creditos[g] == n){ 
                creditos[g] = 0; 
                int h; 
                for(h = g; h < creditos.length-1; h++){
                    creditos[h] = creditos[h+1]; 
                }
                creditos[h] = 0.0;
                break; 
            }
            else if(g == creditos.length){
                System.out.println("El crédito que quiere elminar no existe.");
            }
        }
    }
    public static void main(String[] args) 
    {
        int selector = 0;

        while(selector != 10)
        {
            System.out.println("***MENU***");
            System.out.println("Seleccione el numero de la accion que desea realizar");
            System.out.println("1. Generar un debito");
            System.out.println("2. Generar un credito");
            System.out.println("3. Total de debitos");
            System.out.println("4. Total de creditos");
            System.out.println("5. Mostrar Saldo");
            System.out.println("6. Promedio de debitos en sistema");
            System.out.println("7. Debito mas grande");
            System.out.println("8. Total de operaciones");
            System.out.println("9. Borrar un credito");
            System.out.println("10. SALIDA DEL SISTEMA");
            selector = ingreso.nextInt(); 
            ingreso.nextLine();

            switch(selector)
            {
                case 1:
                genDeb();
                System.out.println("Debito generado con exito");
                break;

                case 2:
                genCre();
                System.out.println("Credito generado con exito");
                break;

                case 3:
                System.out.println("\nTotal de debitos: Q" + ptDeb());
                break;

                case 4:
                System.out.println("\nTotal de creditos: Q" + ptCre());
                break;

                case 5:
                System.out.println("\nEl saldo es de: Q" + (ptDeb()-ptCre()));
                break;

                case 6:
                System.out.println("\nEl promedio de los debitos es: Q" + prom());
                break;

                case 7:
                System.out.println("\nEl debito mas grande en el sistema es de: Q" + max());
                break;

                case 8:
                System.out.println("\nAcciones realizadas al momento" + c);
                operaciones();
                break;

                case 9:
                System.out.println("Escriba el credito que desea borrar: ");
                double delete = ingreso.nextDouble();
                delCre(delete);
                System.out.println("");
                System.out.println("El total de debitos es: Q" + ptDeb());
                System.out.println("El total de creditos es: Q" + ptCre());
                System.out.println("Su saldo es: " + (ptDeb()-ptCre()));
                System.out.println("El promedio de los debitos es: Q" + prom());
                System.out.println("El debito más grande es de Q" + max());
                operaciones(); 
                System.out.println("\nAcciones realizadas al momento" + c);
                break;

                case 10:
                System.out.println("Cerrando sesion....");
                System.exit(0); 
                break;

                default:
                System.out.println("Ingrese un numero valido");
            }
        }
    }
}
