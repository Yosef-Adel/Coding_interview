package Arrays;

/*
 * @created 20/08/2023 - 2:25 PM
 * @project Coding Interview
 * @author Yosef Adel Mahmoud Saaid
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {7,1,2,3,9};

        System.out.println(maxArea(arr));
        System.out.println(optimizedMxArea(arr));
    }

    public static int maxArea (int[] height){
        int mxArea = 0;

        for (int i=0; i < height.length; i++){
            for (int j= i+1; j< height.length; j++){
                int area = Math.min(height[i], height[j]) * (j - i);
                if (area> mxArea)
                    mxArea = area;
            }
        }

        return mxArea;
    }

    public static int optimizedMxArea(int[] height){
        int mxArea = 0;
        int left = 0;
        int right = height.length -1;
        while (left != right){
            int area = Math.min(height[left], height[right]) * (right -left);
            mxArea = Math.max(area, mxArea);
            if(height[left] < height[right])
                left++;
            else
                right--;

        }


        return mxArea;

    }


}
