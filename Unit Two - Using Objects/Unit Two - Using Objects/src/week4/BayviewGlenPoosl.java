package week4;

public class BayviewGlenPoosl {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;

        final int linerCost = 2;

        double volume = getVolume(length,width,shallowHeight,shallowLength,transition,deepHeight);
        double surfaceArea = getSurfaceArea(length,width,shallowHeight,shallowLength,transition,deepHeight);
        

        
    }

    private static double getSurfaceArea(int length, int width, int shallowHeight,int shallowLength, int transition,int deepHeight) {
        double transitionLength = Math.sqrt(Math.pow(transition,2) - Math.pow((deepHeight-shallowHeight ),2));
        double deepLength = (length - (transitionLength+shallowLength));
        double shallowAreaBottom = (length-deepLength-transitionLength)*width;
        double shallowSideArea = shallowHeight*(length-deepLength-transitionLength);
        double shallowSurfaceArea = shallowAreaBottom+2*(shallowSideArea)+(shallowHeight*width);
        

        
        return 0;
    }

    private static double getVolume(int length, int width, int shallowHeight,int shallowLength, int transition,int deepHeight) {
        double transitionLength = Math.sqrt(Math.pow(transition,2) - Math.pow((deepHeight-shallowHeight ),2));
        double deepLength = (length - (transitionLength+shallowLength));
        double volumeShallow = shallowLength*shallowHeight*width;
        double volumeDeep = deepLength*deepHeight*width;
        double transitionVolumeOne = 0.5*(transitionLength*(deepHeight-shallowHeight)*width);
        double transitionVolumeTwo = (transitionLength*shallowHeight*width);
        double volume = transitionVolumeOne+transitionVolumeTwo+volumeDeep+volumeShallow;
        return volume;
        
        
        
    }
    
    
    
}
