package es.ieslosmontecillos.introspeccion;

import java.lang.reflect.*;
import java.util.Scanner;

public class Introspeccion
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Nombre de la clase en " + Introspeccion.class.getPackageName() + ": ");
        String className = input.nextLine();
        Class<?> classSearched;
        try
        {
            classSearched = Class.forName(Introspeccion.class.getPackageName() + "." + className);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Clase no encontrada");
            input.close();
            return;
        }

        for (AccessFlag flag : classSearched.accessFlags())
        {
            System.out.print(flag + " ");
        }

        System.out.println("class " + classSearched.getSimpleName() + " extends " + classSearched.getSuperclass().getSimpleName());

        System.out.println();

        System.out.println("Constructores: ");

        for (Constructor<?> constructor : classSearched.getDeclaredConstructors())
        {
            printExecutable(constructor);
        }

        System.out.println();

        System.out.println("Campos de la clase: ");
        for (Field field : classSearched.getDeclaredFields())
        {
            for (AccessFlag flag : field.accessFlags())
            {
                System.out.print(flag + " ");
            }
            System.out.println(field.getClass().getSimpleName() + " " + field.getName());
        }

        System.out.println();

        System.out.println("Metodos de la clase: ");
        for (Method method : classSearched.getDeclaredMethods())
        {
            printExecutable(method);
        }

        input.close();
    }

    private static void printExecutable(Executable executable)
    {
        for (AccessFlag flag : executable.accessFlags())
        {
            System.out.print(flag + " ");
        }

        if (executable instanceof Method)
        {
            System.out.print(((Method) executable).getReturnType().getSimpleName() + " ");
        }

        System.out.print(executable.getName() + "(");

        for (Parameter parameter : executable.getParameters())
        {
            System.out.print(parameter.getType() + " " + parameter.getName());
        }

        System.out.print(")");

        if (executable.getExceptionTypes().length > 0)
        {
            System.out.print(" throws ");
            for (Class<?> exception : executable.getExceptionTypes())
            {
                System.out.print(exception.getSimpleName());
            }
        }

        System.out.println();
    }
}
