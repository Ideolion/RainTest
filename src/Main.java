public class Main {


    public static void main(String[] args) {
        int [] height = new int[]{4, 2, 3};
        int solution = trap(height);
        System.out.println(solution);
    }

    public static int trap(int[] height) {
        int solution = 0;
        int[] leftMaxArr  =new int[height.length];
        int[] rightMaxArr  =new int[height.length];


//двигаясь слева на право сохраняем в массив максимальное значение для каждого элемента первоначального массива из тех элементов что позади него
        int LeftMax = 0;
        for (int i = 0; i < height.length; i++) {
            LeftMax = Math.max(LeftMax,height[i]);
            leftMaxArr[i]=LeftMax;
       }
//двигаясь справа на лево сохраняем в массив максимальное значение для каждого элемента первоначального массива из тех элементов что позади него
        int rightMax = 0;
        for (int i=height.length-1; i>=0; i--) {
            rightMax = Math.max(rightMax,height[i]);
            rightMaxArr[i]=rightMax;
        }
//для каждой ячейки первоначальной последовательности находим минимальное значение между элементами предыдущих двух массивов leftMaxArr и  rightMaxArr
// чтобы понять сможет ли вода задержаться в этих границах и считаем количество воды (разница между высотой в конкретной ячейке
// и минимальным значением границ ее окружающих)

        for(int i=0;i<height.length;i++){
            int h = Math.min(leftMaxArr[i],rightMaxArr[i]);
            solution += h-height[i];
        }
        return solution;

    }
    }


