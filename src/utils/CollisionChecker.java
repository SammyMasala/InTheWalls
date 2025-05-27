package utils;

public class CollisionChecker {
    public static boolean checkCollision1D(int sourceDim1, int sourceDim2, int targetDim1, int targetDim2){
        return (targetDim1 >= sourceDim1 && targetDim1 <= sourceDim2) || (targetDim2 >= sourceDim1 && targetDim2 <= sourceDim2);
    }

//    public static boolean checkCollision2D(int sourceXDim1, int sourceXDim2, int targetXDim1, int targetXDim2,
//                                           int sourceYDim1, int sourceYDim2, int targetYDim1, int targetYDim2){
//        return ((targetXDim1 >= sourceXDim1 && targetXDim1 <= sourceXDim2) ||
//                (targetXDim2 >= sourceXDim1 && targetXDim2 <= sourceXDim2) &&
//                        (targetYDim1 >= sourceYDim1 && targetYDim1 <= sourceYDim2) ||
//                (targetYDim2 >= sourceYDim1 && targetYDim2 <= sourceYDim2));
//    }
}
