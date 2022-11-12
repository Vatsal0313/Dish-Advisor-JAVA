//Final Project.
package Prac11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DishAdvisor
{
    static char DishChoiceEnd='Y';
    static int DishChoice;

    public static void main(String[] args) throws IOException
    {
        Scanner in=new Scanner(System.in);
        Data dish=new Data();
        String AddIngredients;
        char IngredientsChoice='A';

        dish.DishAdd();// Adding Ingredients in ArrayList
        IngredientsFile();//Adding ingredients list in file to display
        System.out.println("\n... Enter Ingredients ...");
        for(int i=0;i>=0;i++)
        {
            if(i!=0)
            {
                System.out.print("\nTo ADD more ingredients - Enter 'A' \nTo Remove ingredients - Enter 'R'\nTo do neither - Enter 'N'");
                System.out.print("\nChoice :");
                IngredientsChoice=in.next().charAt(0);
            }
            if(IngredientsChoice=='A' || IngredientsChoice=='a')
            {
                if(i!=0)
                {
                    System.out.println("+ + Add More Ingredients + +");
                }
                System.out.println("   (Enter ... to Stop)");
                for (int j = 0; j >= 0; j++)
                {
                    AddIngredients = in.nextLine();  //Inputting Ingredients
                    AddIngredients = AddIngredients.toLowerCase();
                    if (AddIngredients.equals("..."))  //It will stop Entering of Ingredients
                    {
                        break;
                    }
                    dish.check(AddIngredients);
                }
                dish.output();
            }
            else if (IngredientsChoice=='R' || IngredientsChoice=='r')
            {
                System.out.println("- - Remove Ingredients - -");
                System.out.println("   (Enter ... to Stop)");
                for (int j = 0; j >= 0; j++)
                {
                    AddIngredients = in.nextLine();
                    AddIngredients = AddIngredients.toLowerCase();
                    if (AddIngredients.equals("..."))  //It will stop Entering of Ingredients
                    {
                        break;
                    }
                    dish.remove(AddIngredients);
                }
                dish.output();
            }

            if(IngredientsChoice=='N' || IngredientsChoice=='n')
            {
                if(dish.DishCount!=0)
                {
                    GetDishRecipe();
                }
                System.out.println("\n\nTHANK YOU !! \n JAVA Project Made by -\n21DCE034 Vatsal Jajadiya\n21DCE036 Divy Jani");
                break;
            }
        }
    }
    static boolean contains(final int[] array, final int key)
    {
        for (final int i : array)
        {
            if (i == key)
            {
                return true;
            }
        }
        return false;
    }
    static void IngredientsFile() throws IOException
    {
        File obj=new File("D:\\Subjects\\JAVA\\JAVAPro\\src\\Ingredients.txt");
        BufferedReader br=new BufferedReader(new FileReader(obj));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    static void GetDishRecipe()
    {
        Scanner in=new Scanner(System.in);
        Data dish=new Data();
        System.out.print("\nEnter Number of Dish to get it's Recipe - ");
        for (int k = 0; k< Data.NumOfDish; k++)
        {
            System.out.print("Choice :");
            DishChoice = in.nextInt();
            if (contains(Data.ItemChoice,DishChoice))
            {
                dish.recipe(DishChoice);
                if(k!= Data.NumOfDish-1)
                {
                    System.out.print("Want another Dish recipe. [Y/N] :");
                    DishChoiceEnd = in.next().charAt(0);
                }
            }
            else
            {
                System.out.println("Enter Valid Choice");
                k--;
            }
            if (DishChoiceEnd=='N' || DishChoiceEnd=='n' )
            {
                break;
            }
        }
    }
}

class Data
{
    String[] items={"Dosa","Samosa","Dhokla","Kichidi","Kheer","Fruit Salad (Custard)","Nachos","Pizza","Vada Pav","Gulab Jamun","Idli"};
    static int[] ItemChoice=new int[11];
    static int NumOfDish;
    int DishCount;
    static int[] IngredientsCount=new int[11];
    ArrayList<String>[] Dish=new ArrayList[11];

    ArrayList<String>[] DishLink= new ArrayList[2];
    void DishAdd()
    {
        for(int i=0;i<11;i++)
        {
            Dish[i]=new ArrayList<>();
        }

        Dish[0].add("rice");  //Dish[0]=Dosa
        Dish[0].add("white lentil");
        Dish[0].add("onion");
        Dish[0].add("mustard");
        Dish[0].add("potatoes");
        Dish[0].add("coconut");

        Dish[1].add("potato");  //Dish[1]=Samosa
        Dish[1].add("maida");
        Dish[1].add("peas");

        Dish[2].add("besan");  //Dish[2]=Dhokla
        Dish[2].add("baking soda");
        Dish[2].add("lemon juice");

        Dish[3].add("rice");  //Dish[3]=Kichidi
        Dish[3].add("moong daal");
        Dish[3].add("toor dal");
        Dish[3].add("ghee");

        Dish[4].add("milk");  //Dish[4]=Kheer
        Dish[4].add("rice");
        Dish[4].add("nuts");

        Dish[5].add("milk");  //Dish[5]=Fruit Salad (Custard)
        Dish[5].add("nuts");
        Dish[5].add("corn flour");
        Dish[5].add("fruits");

        Dish[6].add("corn flour");  //Dish[6]=Nachos
        Dish[6].add("jalepeno");
        Dish[6].add("cheese");

        Dish[7].add("jalepeno");  //Dish[7]=Pizza
        Dish[7].add("cheese");
        Dish[7].add("maida");
        Dish[7].add("tomato");

        Dish[8].add("besan");  //Dish[8]=Vada Pav
        Dish[8].add("potato");
        Dish[8].add("pav");

        Dish[9].add("maida");  //Dish[9]=Gulab Jamun
        Dish[9].add("ghee");
        Dish[9].add("sugar");

        Dish[10].add("methi");  //Dish[10]Idli
        Dish[10].add("udar dal");
        Dish[10].add("rice");
    }

    void check(String s)
    {
        for (int i=0;i<11;i++)
        {
            if(Dish[i].contains(s))
            {
                IngredientsCount[i]++;
            }
        }
    }
    void remove(String s)
    {
        for (int i=0;i<11;i++)
        {
            if(Dish[i].contains(s))
            {
                IngredientsCount[i]--;
            }
        }
    }
    void output()
    {
        DishCount=11;
        NumOfDish=0;
        System.out.println("\nDishes are :");
        for (int i=0;i<11;i++)
        {
            if(IngredientsCount[i]>=2)
            {
                NumOfDish++;
                ItemChoice[i]=i+1;
                System.out.println(items[i]+" - "+(i+1));
            }
            else
            {
                ItemChoice[i]=0;
                DishCount--;
            }
        }
        if(DishCount==0)
        {
            System.out.println("NO DISH AVAILABLE");
        }
    }
    void recipe(int Recipe)
    {
        for(int i=0;i<2;i++)
        {
            DishLink[i]=new ArrayList<>();
        }
        DishLink[0].add("https://www.indianhealthyrecipes.com/dosa-recipe-dosa-batter/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/samosa-recipe-make-samosa/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/khaman-dhokla/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/dal-khichdi-recipe/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/rice-kheer-recipe-chawal-ki-kheer/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/fruit-custard-recipe/");
        DishLink[0].add("https://www.myrecipes.com/recipe/quick-easy-nachos");
        DishLink[0].add("https://www.indianhealthyrecipes.com/pizza-recipe-make-pizza/");
        DishLink[0].add("https://www.vegrecipesofindia.com/vada-pav-how-to-make-wada-pav/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/gulab-jamun-recipe-using-milk-powder/");
        DishLink[0].add("https://www.indianhealthyrecipes.com/soft-idli-recipe-using-idli-rava/");

        DishLink[1].add("https://youtu.be/sX5pYdNbmgo");
        DishLink[1].add("https://youtu.be/AAm95jaoAJc");
        DishLink[1].add("https://youtu.be/w_2eb9uaXns");
        DishLink[1].add("https://youtu.be/SYWtizV5oCI");
        DishLink[1].add("https://youtu.be/riToqi_sAFA");
        DishLink[1].add("https://youtu.be/fYZ-4qftKnQ");
        DishLink[1].add("https://youtu.be/8QADdjoCmBU");
        DishLink[1].add("https://youtu.be/56eRAEY1t8A");
        DishLink[1].add("https://youtu.be/LE-58cHgDaw");
        DishLink[1].add("https://youtu.be/QFvd7u_YjVk");
        DishLink[1].add("https://youtu.be/dcMlG1UA-jU");

        System.out.println("Website Link - "+DishLink[0].get((Recipe-1)));
        System.out.println("Youtube Link - "+DishLink[1].get((Recipe-1)));
    }
}