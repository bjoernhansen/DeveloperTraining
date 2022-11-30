package training.algorithms;

import java.util.Arrays;

public class SortingAlgorithms
{
    static int random(int num)
    {
        return (int)Math.floor(Math.random()*num+1);
    }
    
    static int [] makeArray(int anz, int aus)
    {
        int [] aus_a = new int[aus];
        int [] anz_a = new int[anz];
        for(int i = 0; i < anz; i++)
        {
            int rand = random(aus);
            anz_a[i] = (aus_a[rand-1] == 0 ? rand : aus_a[rand-1]) + 99;
            aus_a[rand-1] = aus_a[aus-i-1] == 0 ? aus-i : aus_a[aus-i-1];
        }
        return anz_a;
    }
    
    static void printStars()
    {
        System.out.println("\n***************************************************************************************************");
    }
    
    static void swap(int [] A, int i, int j)
    {
        int save = A[i];
        A[i] = A[j];
        A[j] = save;
    }
    
    static void print(int [] array)
    {
        for (int j : array)
        {
            System.out.print(j + " ");
        }
        System.out.println();
    }
    
    static boolean equals(int [] A, int [] B)
    {
        int length = A.length;
        boolean gleich = true;
        for(int i = 0; i < length; i++)
        {
            if (A[i] != B[i])
            {
                gleich = false;
                break;
            }
        }
        return gleich;
    }
    
    public static void main (String[] args)
    {
        int anz = 25;
        int aus = 900;
        String alg = "counting";
        int [] array = makeArray(anz, aus);
        System.out.println("\nDie unsortierte Folge der Elemente im Array lautet:");
        print(array);
        sort(array, alg);
        System.out.println("\nDie von ihrem Algorithmus sortierte Folge der Elemente im Array lautet");
        print(array);
        printStars();
    }
    
    static void sort(int [] A, String alg)
    {
        int[] B = A.clone();
        switch (alg)
        {
            case "selection":
                System.out.println("\nSelection-Sort:");
                selection_sort(A);
                break;
            case "insertion":
                System.out.println("\nInsertion-Sort:");
                insertion_sort(A);
                break;
            case "bubble":
                System.out.println("\nBubble-Sort:");
                bubble_sort(A);
                break;
            case "merge":
                System.out.println("\nMerge-Sort:");
                merge_sort(A);
                break;
            case "heap":
                System.out.println("\nHeap-Sort:");
                heap_sort(A);
                break;
            case "quick":
                System.out.println("\nQuick-Sort:");
                int length = A.length;
                quick_sort(A, 0, length - 1);
                break;
            case "counting":
                System.out.println("\nCounting-Sort:");
                counting_sort(A, 999);
                break;
            case "radix":
                System.out.println("\nRadix-Sort:");
                radix_sort(A, 3);
                break;
            default:
                System.out.println("\nFehler: Sortieralgorithmus unbekannt!");
                break;
        }
        Arrays.sort(B);
        if(equals(A,B)) {System.out.println("\nIhr Sortieralgorithmus arbeitet KORREKT!");}
        else {System.out.println("\nIhr Sortieralgorithmus arbeitet FEHLERHAFT!");}
    }
    
    static void insertion_sort(int [] A)
    {
        int length = A.length;
        for(int i = 1; i < length; i++)
        {
            int input = A[i];
            int j;
            for(j = i-1; j >= 0 && A[j] > input; j--)
            {
                A[j+1] = A[j];
            }
            A[j+1] = input;
        }
    }
    
    static void selection_sort(int [] A)
    {
        int length = A.length;
        for(int i = 0; i < length-1; i++)
        {
            int max = 0;
            for(int j = 1; j < length-i; j++)
            {
                if(A[j] > A[max]){max = j;}
            }
            int save = A[length-i-1];
            A[length-i-1] = A[max];
            A[max] = save;
        }
    }
    
    static void bubble_sort(int [] A)
    {
        int length = A.length;
        for(int i = 0; i < length - 1; i++)
        {
            boolean no_swap = true;
            for(int j = length - 1; j > i; j--)
            {
                if(A[j] < A[j-1])
                {
                    swap(A, j, j-1);
                    no_swap = false;
                }
            }
            if(no_swap)break;
        }
    }
    
    static void merge_sort(int [] A)
    {
        int length = A.length;
        if(length > 1)
        {
            int [] LA = new int [length/2];
            int [] RA = new int [length - length/2];
            System.arraycopy(A, 0, LA, 0, length / 2);
            if (length - length / 2 >= 0)
            {
                System.arraycopy(A, length / 2, RA, 0, length - length / 2);
            }
            merge_sort(LA);
            merge_sort(RA);
            
            int pos_LA = 0, pos_RA = 0;
            for(int i = 0; i < length; i++)
            {
                if(pos_RA >= length-length/2 || LA[pos_LA] < RA[pos_RA])
                {
                    A[i] = LA[pos_LA];
                    pos_LA++;
                }
                else
                {
                    A[i] = RA[pos_RA];
                    pos_RA++;
                }
            }
        }
    }
    
    static void heap_sort(int [] A)
    {
        int length = A.length;
        int heapLength = length;
        build_max_heap(A);
        for(int i = length-1; i > 0; i--)
        {
            swap(A, 0, i);
            heapLength--;
            maxHeapify(A, 0, heapLength);
        }
    }
    
    static void maxHeapify(int [] A, int i, int heapLength)
    {
        int max, links = 2 * (i+1) - 1, rechts = 2 * (i+1);
        max = (links <= heapLength - 1 && A[i] < A[links]) ? links : i;
        if(rechts <= heapLength - 1 && A[max] < A[rechts]){max = rechts;}
        if(max != i)
        {
            swap(A, i, max);
            maxHeapify(A, max, heapLength);
        }
    }
    
    static void build_max_heap(int [] A)
    {
        int heapLength = A.length;
        for(int i = heapLength/2-1; i >= 0; i--)
        {
            maxHeapify(A, i, heapLength);
        }
    }
    
    static void quick_sort(int [] A, int links, int rechts)
    {
        //if(links < rechts)    /* ohne Simulieren der Endrekursion */
        while(links < rechts)   /* bei Simulieren der Endrekursion  */
        {
            int pivot = partition(A, links, rechts);
            //quick_sort(A, pivot+1, rechts);   /* ohne Simulieren der Endrekursion */
            quick_sort(A, links, pivot-1);      /* bei Simulieren der Endrekursion  */
            links = pivot+1;
        }
    }
    
    static int partition(int [] A, int links, int rechts)
    {
        swap(A, links+random(rechts-links+1)-1, rechts); /* Die Zeile realisiert den randomisierten Quicksort */
        int x = A[rechts];
        int i = links - 1;
        for(int j = links; j < rechts; j++)
        {
            if(A[j] <= x)
            {
                i++;
                swap(A,i,j);
            }
        }
        swap(A,i+1,rechts);
        return i+1;
    }
    
    static void counting_sort(int [] A, int k)
    {
        int length = A.length;
        int [] C = new int [k+1];
        int [] B = new int [length];
        for (int j : A) C[j]++;
        for(int i = 1; i <= k; i++) C[i]+=C[i-1];
        for(int i = length-1; i >= 0; i--)
        {
            B[C[A[i]]-1] = A[i];
            C[A[i]]--;
        }
        System.arraycopy(B, 0, A, 0, length);
    }
    
    static void radix_sort(int [] A, int m)
    {
        for(int i = 1; i <= m; i++)
        {
            radix_counting_sort(A,i);
        }
    }
    
    static int radix_key(int zahl, int m)
    {
        return (int)(zahl/Math.pow(10,m-1))%10;
    }
    
    static void radix_counting_sort(int [] A, int m)
    {
        int length = A.length;
        int [] C = new int [10];
        int [] B = new int [length];
        for (int j : A) C[radix_key(j, m)]++;
        for(int i = 1; i < 10; i++) C[i]+=C[i-1];
        for(int i = length-1; i >= 0; i--)
        {
            B[C[radix_key(A[i],m)]-1] = A[i];
            C[radix_key(A[i],m)]--;
        }
        System.arraycopy(B, 0, A, 0, length);
    }
}