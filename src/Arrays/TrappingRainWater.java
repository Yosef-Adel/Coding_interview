package Arrays;

/*
 * @created 21/08/2023 - 10:27 AM
 * @project Coding Interview
 * @author Yosef Adel Mahmoud Saaid
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,3,1,0,1,2};
        System.out.println(trap(arr));
        System.out.println(optimizedTrap(arr));


    }



    public static int optimizedTrap(int[] height){
        int totalWater =0;
        int left =0;
        int right= height.length -1;
        int mxLift = height[left];
        int mxRight= height[right];
        while (left!=right){
            int currentWater =0;

            if (height[right] > height[left]){
                currentWater = Math.min(mxLift, mxRight) - height[left];
                left++;
            }else {
                currentWater = Math.min(mxLift,mxRight) - height[right];
                right--;
            }
            if (currentWater> 0){
                totalWater+= currentWater;
            }
            mxRight = Math.max(mxRight, height[right]);
            mxLift = Math.max(mxLift, height[left]);

        }

        return totalWater;
    }

    public static int trap(int[] height){
        int totalWater = 0;
        for (int i=0; i < height.length; i++){
            int leftP= i, rightP =i , mxLeft =0 , mxRight=0;
            while (leftP >=0){
                mxLeft = Math.max(mxLeft, height[leftP]);
                leftP--;
            }
            while (rightP<height.length){
                mxRight =Math.max(mxRight, height[rightP]);
                rightP++;
            }

            int currentWater = Math.min(mxLeft,mxRight) - height[i];
            if (currentWater>0){
                totalWater+=currentWater;
            }

        }
        return totalWater;
    }
}
